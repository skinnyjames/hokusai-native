package com.hokusai;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import com.hokusai.commands.*;
import java.util.ArrayList;
import java.nio.file.Paths ;

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

    if (home == null)
    {
      home = Paths.get("./truffle").toString();
    }

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
    System.out.println("eval the app " + app);
    Value block = polyglot.eval("ruby", app);
    String backend = """
      -> app do
        block = app.mount
        canvas = Hokusai::Canvas.new(400.0, 300.0, 0.0, 0.0)
        input = Hokusai::Input.new
        painter = Hokusai::Painter.new(block, input)
        painter.render(canvas, false)
      end
    """;

    System.out.println("eval backend?");
    polyglot.eval("ruby", backend).execute(block);
  }

  public static void setupHokusaiCallbacks() {
    System.out.println("Setup callbacks");
      polyglot.eval("ruby", """
        -> do
          wrapper = Java.type("com.hokusai.commands.ShaderBeginCommandWrapper")
          commands = Polyglot.import("commands")

          Hokusai::Commands::ShaderBegin.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute();

      polyglot.eval("ruby", """
        -> do
          wrapper = Java.type("com.hokusai.commands.ShaderEndCommandWrapper")
          commands = Polyglot.import("commands")

          Hokusai::Commands::ShaderEnd.on_draw do |command|
            commands.addLast wrapper.new(command)
          end
        end
      """).execute();

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
