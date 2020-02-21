package com.oozinoz.filter;

import java.io.IOException;
import java.io.Writer;

public class CommaListFilter extends OozinozFilter {
  protected boolean needComma = false;

  public CommaListFilter(Writer writer) {
    super(writer);
  }

  public void write(int c) throws IOException {
    if(needComma) {
      out.write(',');
      out.write(' ');
    }
    out.write(c);
    needComma = true;
  }

  public void write(String s) throws IOException {
    if(needComma)
      out.write(", ");

    out.write(s);
    needComma = true;
  }
}
