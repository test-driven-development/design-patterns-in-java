package com.oozinoz.filter;

import java.io.IOException;
import java.io.Writer;

public class UpperCaseFilter extends OozinozFilter {
  public UpperCaseFilter(Writer out) {
    super(out);
  }

  public void write(int c) throws IOException {
    out.write(Character.toUpperCase((char) c));
  }
}
