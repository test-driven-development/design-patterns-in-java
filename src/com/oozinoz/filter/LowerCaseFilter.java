package com.oozinoz.filter;

import java.io.IOException;
import java.io.Writer;

public class LowerCaseFilter extends OozinozFilter {
  public LowerCaseFilter(Writer out) {
    super(out);
  }

  public void write(int c) throws IOException {
    out.write(Character.toLowerCase((char) c));
  }
}
