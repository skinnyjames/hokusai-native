package com.hokusai;

import org.graalvm.polyglot.*;
import com.hokusai.commands.*;
import java.util.function.*;

public class Backend {
  public Consumer<ScissorBeginCommandWrapper> onDrawScissorBegin;
  public Consumer<ScissorEndCommandWrapper> onDrawScissorEnd;
  public Consumer<CircleCommandWrapper> onDrawCircle;
  public Consumer<ImageCommandWrapper> onDrawImage;
  public Consumer<TextCommandWrapper> onDrawText;
  public Consumer<RectCommandWrapper> onDrawRect;

  public Context polyglot;

  public Backend(Context polyglot) {
    this.polyglot = polyglot;
  }

  public static void runApp(String app) {
    Context polyglot = setupRuby();
    Backend backend = new Backend(polyglot);

    backend.setupHokusaiCallbacks();
    backend.run(app);
  }

  public static Context setupRuby() {
     Context polyglot = Context.newBuilder("ruby")
        .allowAllAccess(true)
        .allowNativeAccess(true)
        .build();

     
      polyglot.eval("ruby", "require \"hokusai\"");

      return polyglot;
  }

  public void run(String app) {
    Value block = this.polyglot.eval("ruby", app);

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

    this.polyglot.eval("ruby", backend).execute(block);
  }

  public void setupHokusaiCallbacks() {
      this.polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.CircleCommandWrapper")
          Hokusai::Commands::Circle.on_draw do |command|
            block.call(wrapper.new(command))
          end
        end
      """).execute(this.onDrawCircle);

      this.polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.RectCommandWrapper")
          Hokusai::Commands::Rect.on_draw do |command|
            block.call(wrapper.new(command))
          end
        end
      """).execute(this.onDrawRect);


      this.polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.TextCommandWrapper")
          Hokusai::Commands::Text.on_draw do |command|
            block.call(wrapper.new(command))
          end
        end
      """).execute(this.onDrawText);

      this.polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.ImageCommandWrapper")
          Hokusai::Commands::Image.on_draw do |command|
            block.call(wrapper.new(command))
          end
        end
      """).execute(this.onDrawImage);

      this.polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.ScissorBeginCommandWrapper")
          Hokusai::Commands::ScissorBegin.on_draw do |command|
            block.call(wrapper.new(command))
          end
        end
      """).execute(this.onDrawScissorBegin);

      this.polyglot.eval("ruby", """
        -> block do
          wrapper = Java.type("com.hokusai.commands.ScissorEndCommandWrapper")
          Hokusai::Commands::ScissorEnd.on_draw do |command|
            block.call(wrapper.new(command))
          end
        end
      """).execute(this.onDrawScissorEnd);
  }

  public void setOnDrawScissorBegin(Consumer<ScissorBeginCommandWrapper> callback) {
    this.onDrawScissorBegin = callback;
  }

  public void setOnDrawScissorEnd(Consumer<ScissorEndCommandWrapper> callback) {
    this.onDrawScissorEnd = callback;
  }

  public void setOnDrawCircle(Consumer<CircleCommandWrapper> callback) {
    this.onDrawCircle = callback;
  }

  public void setOnDrawImage(Consumer<ImageCommandWrapper> callback) {
    this.onDrawImage = callback;
  }

  public void setOnDrawText(Consumer<TextCommandWrapper> callback) {
    this.onDrawText = callback;
  }
  
  public void setOnDrawRect(Consumer<RectCommandWrapper> callback) {
    this.onDrawRect = callback;
  }
}
