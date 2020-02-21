package app.decorator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ShowDecorator {
  public static void main(String[] args) throws IOException {
    FileWriter file = new FileWriter("sample.txt");
    BufferedWriter writer = new BufferedWriter(file);
    writer.write("a small amount of sample text");
    writer.newLine();
    writer.close();
  }
}
