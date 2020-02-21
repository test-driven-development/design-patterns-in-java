package com.oozinoz.filter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class WrapFilter extends OozinozFilter {
  protected int lineLength;
  protected StringBuffer lineBuf = new StringBuffer();
  protected StringBuffer wordBuf = new StringBuffer();
  protected boolean center = false;
  protected boolean inWhite = false;
  protected boolean needBlank = false;

  public WrapFilter(BufferedWriter out, int lineLength) {
    super(out);
    this.lineLength = lineLength;
  }

  public void close() throws IOException {
    flush();
    out.close();
  }

  public void flush() throws IOException {
    if(wordBuf.length() > 0)
      postWord();

    if(lineBuf.length() > 0)
      postLine();

    out.flush();
  }

  protected void postLine() throws IOException {
    if(center) {
      int adjustment = Math.max(0, (lineLength - lineBuf.length()) / 2);
      char[] skootch = new char[adjustment];
      Arrays.fill(skootch, ' ');
      out.write(skootch);
    }
    out.write(lineBuf.toString());
  }

  protected void postWord() throws IOException {
    if(lineBuf.length() + 1 + wordBuf.length() > lineLength) {
      postLine();
      ((BufferedWriter) out).newLine();
      lineBuf = wordBuf;
      wordBuf = new StringBuffer();
    } else {
      if(needBlank)
        lineBuf.append(" ");

      lineBuf.append(wordBuf);
      needBlank = true;
      wordBuf = new StringBuffer();
    }
  }

  public void setCenter(boolean center) {
    this.center = center;
  }

  public void write(int c) throws IOException {
    if(Character.isWhitespace((char) c)) {
      if(!inWhite)
        postWord();
      inWhite = true;
    } else {
      wordBuf.append((char) c);
      inWhite = false;
    }
  }
}
