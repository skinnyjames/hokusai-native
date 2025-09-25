package com.hokusai.interfaces;

import java.util.HashMap;
import java.util.ArrayList;
import org.graalvm.polyglot.Value;

public interface ShaderBeginCommand extends Command {
  String vertex_shader();
  String fragment_shader();
  Value uniforms();
}