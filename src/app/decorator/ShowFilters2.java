package app.decorator;

import com.oozinoz.filter.RandomCaseFilter;
import com.oozinoz.filter.WrapFilter;

import java.io.*;

public class ShowFilters2 {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new FileReader(args[0]));
    Writer out = new PrintWriter(System.out);
    out = new WrapFilter(new BufferedWriter(out), 15);

    ((WrapFilter) out).setCenter(true);
    out = new RandomCaseFilter(out);

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
