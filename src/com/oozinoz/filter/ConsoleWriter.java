package com.oozinoz.filter;

import java.io.Writer;

public class ConsoleWriter extends Writer {
  public void close() {}

  public void flush() {}

  public void write(char[] buffer, int offset, int length) {
    for(int i = 0; i < length; i++) { System.out.print(buffer[offset + i]); }
  }
}
