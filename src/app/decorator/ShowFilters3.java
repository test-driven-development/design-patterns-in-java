package app.decorator;

import com.oozinoz.filter.RandomCaseFilter;
import com.oozinoz.filter.WrapFilter;

import java.io.*;

public class ShowFilters3 {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(args[0]));
    WrapFilter out = new WrapFilter(new BufferedWriter(
      new RandomCaseFilter(new PrintWriter(System.out))), 15);
    out.setCenter(true);

    while(true) {
      String s = in.readLine();
      if(s == null)
        break;
      out.write(s + "\n");
    }

    out.close();
    in.close();
  }
}
