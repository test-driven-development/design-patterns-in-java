package com.oozinoz.filter;

import java.io.IOException;
import java.io.Writer;

public class RandomCaseFilter extends OozinozFilter {
  public RandomCaseFilter(Writer out) {
    super(out);
  }

  public void write(int c) throws IOException {
    out.write(Math.random() < .5 ? Character.toLowerCase((char) c)
      : Character.toUpperCase((char) c));
  }
}
