package com.oozinoz.function;

public class Exp extends Function {
  public Exp(Function f) {
    super(f);
  }

  public double f(double t) {
    return Math.exp(sources[0].f(t));
  }
}
