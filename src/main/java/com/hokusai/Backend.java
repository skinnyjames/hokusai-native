package com.hokusai;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.word.Pointer;
import org.graalvm.nativeimage.IsolateThread;

import java.util.HashMap;
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
  public static HashMap<String, Value> keySymbolMap = new HashMap<String, Value>();
  public static keys = [
    "null", "apostrophe", "comma", "minus", "period",
    "slash", "zero", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine", "semicolon", 
    "equal", "a", "b", "c", "d", "e", "f", "g", "h", 
    "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", 
    "s", "t", "u", "v", "w", "x", "y", "z", "left_bracket", 
    "backslash", "right_bracket", "grave", "space", "escape", 
    "enter", "tab", "backspace", "insert", "delete", "right", 
    "left", "down", "up", "page_up", "page_down", "home", "end", 
    "caps_lock", "scroll_lock", "num_lock", "print_screen", "pause", 
    "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", 
    "f9", "f10", "f11", "f12", "left_shift", "left_control", 
    "left_alt", "left_super", "right_shift", "right_control", "right_alt", 
    "right_super", "kb_menu", "kp_0", "kp_1", "kp_2", "kp_3", 
    "kp_4", "kp_5", "kp_6", "kp_7", "kp_8", "kp_9", "kp_decimal", 
    "kp_divide", "kp_multiply", "kp_subtract", "kp_add", "kp_enter", 
    "kp_equal", "back", "menu", "volume_up", "volume_down"
  ]

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

  public static void populateKeys()
  {
    for (String key : keys) {
      Value v = polyglot.eval("ruby", """
        -> name do
          name.to_sym
        end
      """).execute(key);

      keySymbolMap.put(key, v);
    }
  }

  @CEntryPoint(name = "processInput")
  public static void processInput(@CEntryPoint.IsolateThreadContext long isolate, HokusaiNativeInput nativeInput) {
    input.getMember("mouse").getMember("pos").putMember("x", nativeInput.mouse_x());
    input.getMember("mouse").getMember("pos").putMember("y", nativeInput.mouse_y());
    input.getMember("mouse").getMember("delta").putMember("x", nativeInput.delta_x());
    input.getMember("mouse").getMember("delta").putMember("y", nativeInput.delta_y());
    input.getMember("mouse").putMember("scroll", nativeInput.scroll());

    input.getMember("mouse").getMember("left").putMember("clicked", nativeInput.left().clicked());
    input.getMember("mouse").getMember("left").putMember("down", nativeInput.left().down());
    input.getMember("mouse").getMember("left").putMember("released", nativeInput.left().released());
    input.getMember("mouse").getMember("left").putMember("up", nativeInput.left().up());

    input.getMember("mouse").getMember("middle").putMember("clicked", nativeInput.middle().clicked());
    input.getMember("mouse").getMember("middle").putMember("down", nativeInput.middle().down());
    input.getMember("mouse").getMember("middle").putMember("released", nativeInput.middle().released());
    input.getMember("mouse").getMember("middle").putMember("up", nativeInput.middle().up());
    
    input.getMember("mouse").getMember("right").putMember("clicked", nativeInput.right().clicked());
    input.getMember("mouse").getMember("right").putMember("down", nativeInput.right().down());
    input.getMember("mouse").getMember("right").putMember("released", nativeInput.right().released());
    input.getMember("mouse").getMember("right").putMember("up", nativeInput.right().up());

    if (!input.getMember("keyboard_override").asBoolean()) {
      input.getMember("keyboard").execute("reset")
      for (int i = 0; i < HokusaiNativeKeyType.size - 1; i++) {
        HokusaiNativeKey key = nativeInput.addressOfKey().read(i);
        input.getMember("keyboard").execute("set", keySymbolMap.get(keys[i]), key.down());
      }
    }
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

    System.out.println("app " + app);
    block = polyglot.eval("ruby", app);

    System.out.println("setup input");
    input = polyglot.eval("ruby", """
      Hokusai::Input.new
    """);

    populateKeys();
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
