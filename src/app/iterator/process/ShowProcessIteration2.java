package app.iterator.process;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.process.ProcessComponent;
import com.oozinoz.process.ShellProcess;

public class ShowProcessIteration2 {
  public static void main(String[] args) {
    ProcessComponent pc = ShellProcess.make();
    ComponentIterator iter = pc.iterator();
    while(iter.hasNext()) {
      for(int i = 0; i < 4 * iter.getDepth(); i++) { System.out.print(' '); }
      System.out.println(iter.next());
    }
  }
}
