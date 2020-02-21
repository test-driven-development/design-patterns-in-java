package com.oozinoz.filter;

import java.io.IOException;
import java.io.Writer;

public class TitleCaseFilter extends OozinozFilter {
  boolean inWhite = true;

  public TitleCaseFilter(Writer out) {
    super(out);
  }

  public void write(int c) throws IOException {
    out.write(inWhite ? Character.toUpperCase((char) c) : Character.toLowerCase((char) c));
    inWhite = Character.isWhitespace((char) c) || c == '"';
  }
}
