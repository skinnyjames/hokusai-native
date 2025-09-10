package com.hokusai;

import com.hokusai.commands.*;
import com.hokusai.interfaces.*;
import com.hokusai.JavaBackend;
import java.util.Map;
import java.util.HashMap;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    try 
    {
      System.out.println("okay!");
      
      String app = """
      class App < Hokusai::Block
        template <<~EOF
        [template]
          vblock
            shader_begin {
              :vertex_shader="vs"
              :uniforms="uniforms"
            }
              vblock { :height="100.0" }
                circle { :radius="43.0" }
              shader_end
            vblock
              circle { :radius="20.0"}
            
        EOF

        uses(
          shader_begin: Hokusai::Blocks::ShaderBegin,
          shader_end: Hokusai::Blocks::ShaderEnd,
          vblock: Hokusai::Blocks::Vblock, 
          circle: Hokusai::Blocks::Circle
        )

        def vs
          <<-EOF
          some shader
          EOF
        end

        def uniforms
          {
            "okay" => [2.0, Hokusai::SHADER_UNIFORM_FLOAT],
            "then" => [[5.0, 3.0], Hokusai::SHADER_UNIFORM_VEC2]
          }
        end
      end

      App
      """;
    
      System.out.println("Init");
      JavaBackend.init();
      System.out.println("Run app");

      JavaBackend.run(app);


      System.out.println("Run commands");
      CommandWrapper command = JavaBackend.getCommand();

      while (command != null) {
        // System.out.println(command);

        command = JavaBackend.getCommand();

        if (command instanceof CircleCommandWrapper) {
          System.out.println("Circle command!");
        }
        if (command instanceof ShaderBeginCommandWrapper) {
          System.out.println("Shader begin!");

          ArrayList<ShaderBeginUniform> uniforms = ShaderBeginCommandWrapper.class.cast(command).uniforms();

          for (ShaderBeginUniform entry : uniforms) {
            System.out.println(entry.key + " key " + entry.type + " type " + entry.value);

          }

        }
      }

    } catch(Exception e) {
      System.out.println(e.toString());
    }
  }
}