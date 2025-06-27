package com.hokusai.interfaces;

public interface ImageCommand {
  String source();
  double x();
  double y();
  double width();
  double height();
  Color color();
}