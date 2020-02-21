package com.oozinoz.function;

public class Cos extends Function {
  public Cos(Function f) {
    super(f);
  }

  public double f(double t) {
    return Math.cos(sources[0].f(t));
  }
}
