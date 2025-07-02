package com.hokusai.interfaces;

public interface RectCommand extends Command{
  double x();
  double y();
  double width();
  double height();
  double rounding();
  Color color();
  Outline outline();
  Color outline_color();
  Padding padding();
}