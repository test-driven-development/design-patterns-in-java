package com.oozinoz.function;

public class Sqrt extends Function {
  public Sqrt(Function f) {
    super(f);
  }

  public double f(double t) {
    return Math.sqrt(sources[0].f(t));
  }
}
