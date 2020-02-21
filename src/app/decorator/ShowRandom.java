package app.decorator;

import com.oozinoz.filter.ConsoleWriter;
import com.oozinoz.filter.RandomCaseFilter;

import java.io.BufferedWriter;
import java.io.IOException;

public class ShowRandom {
  public static void main(String[] args) throws IOException {
    BufferedWriter w =
      new BufferedWriter(new RandomCaseFilter(new ConsoleWriter()));
    w.write("buy two packs now and get a "
      + "zippie pocket rocket -- free!");
    w.newLine();
    w.close();
  }
}
