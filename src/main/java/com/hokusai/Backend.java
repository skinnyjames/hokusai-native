package com.hokusai;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.word.Pointer;
import org.graalvm.nativeimage.IsolateThread;

import java.util.function.Consumer;
import com.hokusai.commands.*;
import com.hokusai.interfaces.ext.*;

public class Backend {
  public static Context polyglot;
  public static Value block;
  public static Value input;
  public static HokusaiNativeRectCommandCallback onDrawRect;
  public static HokusaiNativeCircleCommandCallback onDrawCircle;

  @CEntryPoint(name = "onDrawRect")
  public static void onDrawRect(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeRectCommandCallback callback) {
    onDrawRect = callback;
  }

  @CEntryPoint(name = "onDrawCircle")
  public static void onDrawCircle(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeCircleCommandCallback callback) {
    onDrawCircle = callback;
  }

  @CEntryPoint(name = "createIsolate", builtin = CEntryPoint.Builtin.CREATE_ISOLATE)
  public static native IsolateThread createIsolate();

  @CEntryPoint(name = "init")
  public static void init(@CEntryPoint.IsolateThreadContext long isolate) {
    System.out.println("In init");

    String home = System.getenv("HOKUSAI_RUBY_HOME");

    System.out.println("Home is " + home);
    System.setProperty("ruby.home", home);
    System.setProperty("org.graalvm.language.ruby.home", home);

    polyglot = Context.newBuilder("ruby")
      .allowAllAccess(true)
      .allowNativeAccess(true)
      .build();

    polyglot.eval("ruby", "require \"hokusai\"");
    setupHokusaiCallbacks();

    System.out.println("callbcks setup");
    String app = System.getenv("HOKUSAI_APP");

    System.out.println("app " + app);
    block = polyglot.eval("ruby", app);

    System.out.println("setup input");
    input = polyglot.eval("ruby", """
        ptr = FFI::MemoryPointer.new :pointer
        LibHokusai.hoku_input_init(ptr)
        raw = LibHokusai::HmlInput.new(ptr.get_pointer(0))
        input = Hokusai::Input.new(raw)
        ptr.free

        input
    """);
  }

  @CEntryPoint(name = "update")
  public static void update(@CEntryPoint.IsolateThreadContext long isolate) {
    polyglot.eval("ruby", """
      -> block do 
        block.update
      end
    """).execute(block);
  }

  @CEntryPoint(name = "render")
  public static void render(@CEntryPoint.IsolateThreadContext long isolate, float width, float height) {
    String render = """
      -> (width, height, input, block) do
        canvas = Hokusai::Canvas.new(width.to_f, height.to_f, 0.0, 0.0)
        painter = Hokusai::Painter.new(block, input)
        painter.render(canvas, false)
      end
    """;

    polyglot.eval("ruby", render).execute(width, height, input, block);
  }

  public static void setupHokusaiCallbacks() {
      CircleWrapper cb = new CircleWrapper(onDrawCircle);
      polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.CircleCommandWrapper")
          Hokusai::Commands::Circle.on_draw do |command|
            pp ["circle callback", command.outline]
            block.call wrapper.new(command)
            pp ["circle callback done"]
          end
        end
      """).execute(cb);

      polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.RectCommandWrapper")
          Hokusai::Commands::Rect.on_draw do |command|
            pp ["rect callback done"]
          end
        end
      """).execute(cb);

      // polyglot.eval("ruby", """
      //   -> commands do
      //     wrapper = Java.type("com.hokusai.commands.TextCommandWrapper")
      //     Hokusai::Commands::Text.on_draw do |command|
      //       commands.addLast wrapper.new(command)
      //     end
      //   end
      // """).execute(commands);

      // polyglot.eval("ruby", """
      //   -> commands do
      //     wrapper = Java.type("com.hokusai.commands.ImageCommandWrapper")
      //     Hokusai::Commands::Image.on_draw do |command|
      //       commands.addLast wrapper.new(command)
      //     end
      //   end
      // """).execute(commands);

      // polyglot.eval("ruby", """
      //   -> commands do
      //     wrapper = Java.type("com.hokusai.commands.ScissorBeginCommandWrapper")
      //     Hokusai::Commands::ScissorBegin.on_draw do |command|
      //       commands.addLast wrapper.new(command)
      //     end
      //   end
      // """).execute(commands);

      // polyglot.eval("ruby", """
      //   -> commands do
      //     wrapper = Java.type("com.hokusai.commands.ScissorEndCommandWrapper")
      //     Hokusai::Commands::ScissorEnd.on_draw do |command|
      //       commands.addLast wrapper.new(command)
      //     end
      //   end
      // """).execute(commands);
  }
}
