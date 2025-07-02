package com.hokusai.interfaces;

public interface ScissorBeginCommand extends Command{
  double x();
  double y();
  double width();
  double height();
}