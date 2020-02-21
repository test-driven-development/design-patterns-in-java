package com.oozinoz.function;

public class Sin extends Function {
  public Sin(Function f) {
    super(f);
  }

  public double f(double t) {
    return Math.sin(sources[0].f(t));
  }
}
