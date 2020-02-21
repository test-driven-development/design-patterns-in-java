package app.decorator.brightness;

import com.oozinoz.function.Function;

public class Brightness extends Function {
  public Brightness(Function f) {
    super(f);
  }

  public double f(double t) {
    return Math.exp(-4 * sources[0].f(t))
      * Math.sin(Math.PI * sources[0].f(t));
  }
}
