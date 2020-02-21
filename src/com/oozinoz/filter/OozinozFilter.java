package com.oozinoz.filter;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class OozinozFilter extends FilterWriter {
  protected OozinozFilter(Writer out) {
    super(out);
  }

  public void write(char[] cbuf, int offset, int length) throws IOException {
    for(int i = 0; i < length; i++) { write(cbuf[offset + i]); }
  }

  public abstract void write(int c) throws IOException;

  public void write(String s, int offset, int length) throws IOException {
    write(s.toCharArray(), offset, length);
  }
}
