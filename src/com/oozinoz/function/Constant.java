package com.oozinoz.function;

public class Constant extends Function {
  protected double constant;

  public Constant(double constant) {
    super(new Function[] {});
    this.constant = constant;
  }

  public double f(double t) {
    return constant;
  }
}
