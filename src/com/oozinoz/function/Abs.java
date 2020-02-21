package com.oozinoz.function;

public class Abs extends Function {
  public Abs(Function f) {
    super(f);
  }

  public double f(double t) {
    return Math.abs(sources[0].f(t));
  }
}
