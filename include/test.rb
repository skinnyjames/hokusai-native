require "hokusai"

class Test < Hokusai::Block
  template <<~EOF
  [template]
    empty {
      @click="change_color"
    }
  EOF

  uses(empty: Hokusai::Blocks::Empty)

  def initialize(**args)
    @colors = [[255, 255, 0], [232, 20, 202], [22, 234, 40]]
    @color = @colors.last

    super
  end

  def change_color(event)
    @color = @colors.shift
    @colors << @color
  end

  def color
    @color
  end

  def render(canvas)
    draw do
      rect(canvas.x, canvas.y, canvas.width / 2.0, canvas.height) do |command|
        command.color = color
      end

      rect(canvas.x + canvas.width / 2.0, canvas.y, canvas.width / 2.0, canvas.height) do |command|
        command.color = Hokusai::Color.new(0, 0, 255)
      end

      text("hello world", canvas.x + (canvas.width / 2.0) + 20, canvas.y + 20) do |command|
        command.size = 24
        command.color = Hokusai::Color.new(0, 255, 0)
      end
    end

    yield canvas
  end
end

class App < Hokusai::Block
  template <<~EOF
  [template]
    test
    circle {
      :radius="20.0"
      color="165,51,51"
    }
  EOF

  uses(test: Test, circle: Hokusai::Blocks::Circle)
end

App.mount