package com.hokusai;

import com.hokusai.commands.*;
import com.hokusai.JavaBackend;

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
            vblock { :height="100.0" }
              circle { :radius="43.0" }
            vblock
              circle { :radius="20.0"}
            
        EOF

        uses(vblock: Hokusai::Blocks::Vblock, circle: Hokusai::Blocks::Circle)
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
        System.out.println(command);

        command = JavaBackend.getCommand();

        if (command instanceof CircleCommandWrapper) {
          System.out.println("Circle command!");
        }
      }

    } catch(Exception e) {
      System.out.println(e.toString());
    }
  }
}