package app.visitor;

import com.oozinoz.process.ProcessComponent;
import com.oozinoz.process.ShellProcess;

public class ShowPrettyVisitor {

  public static void main(String[] args) {
    ProcessComponent p = ShellProcess.make();
    PrettyVisitor v = new PrettyVisitor();
    System.out.println(v.getPretty(p));
  }
}
