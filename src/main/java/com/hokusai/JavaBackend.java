package com.hokusai;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import com.hokusai.commands.*;
import java.util.ArrayList;

public class JavaBackend {
  public static ArrayList<CommandWrapper> commands = new ArrayList<CommandWrapper>();
  public static Context polyglot;
  public static Value rubyCommands;
  public static Value bindings;

  public static CommandWrapper getCommand() {
    if (commands.size() == 0) {
      return null;
    }
    
    return commands.removeFirst();
  }

  public static void init() {
    String home = System.getenv("HOKUSAI_RUBY_HOME");

    System.out.println("Home is " + home);
    System.setProperty("ruby.home", home);
    System.setProperty("org.graalvm.language.ruby.home", home);

    polyglot = Context.newBuilder("ruby")
      .allowAllAccess(true)
      .allowNativeAccess(true)
      .build();

    bindings = polyglot.getPolyglotBindings();
    bindings.putMember("commands", commands);
    polyglot.eval("ruby", "require \"hokusai\"");

    setupHokusaiCallbacks();
  }

  public static void run(String app) {
    Value block = polyglot.eval("ruby", app);
    String backend = """
      -> app do
        
        block = app.mount
        canvas = Hokusai::Canvas.new(400.0, 300.0, 0.0, 0.0)

        ptr = FFI::MemoryPointer.new :pointer
        LibHokusai.hoku_input_init(ptr)
        raw = LibHokusai::HmlInput.new(ptr.get_pointer(0))
        input = Hokusai::Input.new(raw)
        ptr.free


        painter = Hokusai::Painter.new(block, input)

        painter.render(canvas, false)
      end
    """;

    polyglot.eval("ruby", backend).execute(block);
  }

  public static void setupHokusaiCallbacks() {
      polyglot.eval("ruby", """
        -> do
          wrapper = Java.type("com.hokusai.commands.CircleCommandWrapper")
          commands = Polyglot.import("commands")
          Hokusai::Commands::Circle.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute();

      polyglot.eval("ruby", """
        -> do
          wrapper = Java.type("com.hokusai.commands.RectCommandWrapper")
          commands = Polyglot.import("commands")
          Hokusai::Commands::Rect.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute();

      polyglot.eval("ruby", """
        -> commands do
          wrapper = Java.type("com.hokusai.commands.TextCommandWrapper")
          Hokusai::Commands::Text.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute(commands);

      polyglot.eval("ruby", """
        -> commands do
          wrapper = Java.type("com.hokusai.commands.ImageCommandWrapper")
          Hokusai::Commands::Image.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute(commands);

      polyglot.eval("ruby", """
        -> commands do
          wrapper = Java.type("com.hokusai.commands.ScissorBeginCommandWrapper")
          Hokusai::Commands::ScissorBegin.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute(commands);

      polyglot.eval("ruby", """
        -> commands do
          wrapper = Java.type("com.hokusai.commands.ScissorEndCommandWrapper")
          Hokusai::Commands::ScissorEnd.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute(commands);
  }
}
