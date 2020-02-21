package app.visitor;

import com.oozinoz.filter.WrapFilter;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.OozinozFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class ShowRakeVisitor {
  public static void main(String[] args) throws IOException {
    MachineComponent f = OozinozFactory.dublin();
    Writer out = new PrintWriter(System.out);
    out = new WrapFilter(new BufferedWriter(out), 60);
    out.write(new RakeVisitor().getLeaves(f).toString());
    out.close();
  }
}
