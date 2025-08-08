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
  public static HokusaiNativeTextCommandCallback onDrawText;
  public static HokusaiNativeImageCommandCallback onDrawImage;
  public static HokusaiNativeScissorBeginCommandCallback onDrawScissorBegin;
  public static HokusaiNativeScissorEndCommandCallback onDrawScissorEnd;

  @CEntryPoint(name = "onDrawRect")
  public static void onDrawRect(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeRectCommandCallback callback) {
    onDrawRect = callback;
    HokusaiNativeRectCommandWrapper block = new HokusaiNativeRectCommandWrapper(onDrawRect);

    polyglot.eval("ruby", """
      -> block do
        wrapper = Java.type("com.hokusai.commands.RectCommandWrapper")
        Hokusai::Commands::Rect.on_draw do |command|
          block.call wrapper.new(command)
        end
      end
    """).execute(block);
  }

  @CEntryPoint(name = "onDrawCircle")
  public static void onDrawCircle(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeCircleCommandCallback callback) {
    onDrawCircle = callback;
    HokusaiNativeCircleCommandWrapper block = new HokusaiNativeCircleCommandWrapper(onDrawCircle);

    polyglot.eval("ruby", """
      -> block do
        wrapper = Java.type("com.hokusai.commands.CircleCommandWrapper")
        Hokusai::Commands::Circle.on_draw do |command|
          block.call wrapper.new(command)
        end
      end
    """).execute(block);
  }

  @CEntryPoint(name = "onDrawText")
  public static void onDrawText(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeTextCommandCallback callback) {
    onDrawText = callback;

    HokusaiNativeTextCommandWrapper block = new HokusaiNativeTextCommandWrapper(onDrawText);
    polyglot.eval("ruby", """
      -> block do
        wrapper = Java.type("com.hokusai.commands.TextCommandWrapper")
        Hokusai::Commands::Text.on_draw do |command|
          block.call wrapper.new(command)
        end
      end
    """).execute(block);
  }

  @CEntryPoint(name = "onDrawImage")
  public static void onDrawImage(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeImageCommandCallback callback) {
    onDrawImage = callback;
    HokusaiNativeImageCommandWrapper block = new HokusaiNativeImageCommandWrapper(onDrawImage);
    polyglot.eval("ruby", """
      -> block do
        wrapper = Java.type("com.hokusai.commands.ImageCommandWrapper")
        Hokusai::Commands::Image.on_draw do |command|
          block.call wrapper.new(command)
        end
      end
    """).execute(block);
  }

  @CEntryPoint(name = "onDrawScissorBegin")
  public static void onDrawScissorBegin(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeScissorBeginCommandCallback callback) {
    onDrawScissorBegin = callback;

    HokusaiNativeScissorBeginCommandWrapper block = new HokusaiNativeScissorBeginCommandWrapper(onDrawScissorBegin);
    polyglot.eval("ruby", """
      -> block do
        wrapper = Java.type("com.hokusai.commands.ScissorBeginCommandWrapper")
        Hokusai::Commands::ScissorBegin.on_draw do |command|
          block.call wrapper.new(command)
        end
      end
    """).execute(block);
  }

  @CEntryPoint(name = "onDrawScissorEnd")
  public static void onDrawScissorEnd(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeScissorEndCommandCallback callback) {
    onDrawScissorEnd = callback;
    HokusaiNativeScissorEndCommandWrapper block = new HokusaiNativeScissorEndCommandWrapper(onDrawScissorEnd);
    polyglot.eval("ruby", """
      -> block do
        Hokusai::Commands::ScissorEnd.on_draw do |command|
          block.call
        end
      end
    """).execute(block);
  }

  @CEntryPoint(name = "createIsolate", builtin = CEntryPoint.Builtin.CREATE_ISOLATE)
  public static native IsolateThread createIsolate();

  @CEntryPoint(name = "init")
  public static void init(@CEntryPoint.IsolateThreadContext long isolate, CCharPointer code) {
    System.out.println("In init");

    String home = System.getenv("HOKUSAI_RUBY_HOME");

    System.out.println("Home is " + home);
    System.setProperty("ruby.home", home);
    System.setProperty("org.graalvm.language.ruby.home", home);

    polyglot = Context.newBuilder("ruby")
      .allowAllAccess(true)
      .allowNativeAccess(true)
      .option("ruby.embedded", "false")
      .build();

    polyglot.eval("ruby", "require \"hokusai\"");

    System.out.println("callbcks setup");

    String app = CTypeConversion.toJavaString(code);

    // String app = System.getenv("HOKUSAI_APP");

    System.out.println("app " + app);
    block = polyglot.eval("ruby", app);

    System.out.println("setup input");
    input = polyglot.eval("ruby", """
      Hokusai::Input.new
    """);
  }

  @CEntryPoint(name = "execute")
  public static void execute(@CEntryPoint.IsolateThreadContext long isolate, CCharPointer code) {
    String app = CTypeConversion.toJavaString(code);
    polyglot.eval("ruby", app);
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
}
