package com.oozinoz.testing;

import com.oozinoz.function.Arithmetic;
import com.oozinoz.function.Constant;
import com.oozinoz.function.Function;
import com.oozinoz.function.Scale;
import junit.framework.TestCase;

public class FunctionTest extends TestCase {
  double fuzz = 0.00001;

  public void testConstant() {
    Constant c = new Constant(42);
    assertEquals(42, c.f(0), fuzz);
    assertEquals(42, c.f(0.5), fuzz);
    assertEquals(42, c.f(1), fuzz);
  }

  public void testScale() {
    Function c = new Scale(0, 100); // let Celsius go 0 to 100
    Function f = new Scale(new Constant(0), c, new Constant(100),
      new Constant(32), new Constant(212));

    assertEquals(32.0, f.f(0), fuzz);
    assertEquals(-40, f.f(-0.4), fuzz);
    assertEquals(212, f.f(1), fuzz);
  }

  public void testArithmetic() {
    Function f = new Arithmetic('+', new Constant(3), new Constant(4));
    assertEquals(7, f.f(0), fuzz);
    assertEquals(7, f.f(0.5), fuzz);
    assertEquals(7, f.f(1), fuzz);
  }
}
