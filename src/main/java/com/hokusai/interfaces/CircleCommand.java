package com.hokusai.interfaces;

public interface CircleCommand extends Command {
  double x();
  double y();
  double radius();
  Color color();
  Color outline_color();
  double outline();
}