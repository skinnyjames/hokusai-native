package com.hokusai.interfaces;

public interface TextCommand extends Command {
  double x();
  double y();
  double size();
  Color color();
  Padding padding();
  Boolean wrap();
  String content();
  String font();
  Boolean bold();
  Boolean italic();
}