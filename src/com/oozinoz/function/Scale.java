package com.oozinoz.function;

public class Scale extends Function {
  public Scale(double from, double to) {
    this(new Constant(from), new Constant(to));
  }

  public Scale(double aFrom, Function a, double aTo, double bFrom, double bTo) {
    this(new Constant(aFrom), a, new Constant(aTo), new Constant(bFrom),
      new Constant(bTo));
  }

  public Scale(Function f1, Function f2) {
    this(new Constant(0), new T(), new Constant(1), f1, f2);
  }

  public Scale(Function aFrom, Function a, Function aTo, Function bFrom,
    Function bTo) {
    super(new Function[] {aFrom, a, aTo, bFrom, bTo});
  }

  public double f(double t) {
    double aFrom = sources[0].f(t);
    double a = sources[1].f(t);
    double aTo = sources[2].f(t);
    double bFrom = sources[3].f(t);
    double bTo = sources[4].f(t);
    double denom = aTo - aFrom;
    if(denom == 0)
      return (bTo + bFrom) / 2;
    return (a - aFrom) / denom * (bTo - bFrom) + bFrom;
  }
}
