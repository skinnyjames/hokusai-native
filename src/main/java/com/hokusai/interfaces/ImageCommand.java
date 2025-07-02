package com.hokusai.interfaces;

public interface ImageCommand extends Command {
  String source();
  double x();
  double y();
  double width();
  double height();
  Color color();
}