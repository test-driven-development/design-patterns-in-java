package app.decorator;

import com.oozinoz.filter.ConsoleWriter;
import com.oozinoz.filter.LowerCaseFilter;

import java.io.IOException;
import java.io.Writer;

public class ShowLowerCase {
  public static void main(String[] args) throws IOException {
    Writer out = new ConsoleWriter();
    out = new LowerCaseFilter(out);
    out.write("This Text, notably ALL in LoWeR casE!");
    out.close();
  }
}
