package app.iterator.process;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.process.ProcessComponent;
import com.oozinoz.process.ShellProcess;

public class ShowLeavesOnly {
  public static void main(String[] args) {
    ProcessComponent pc = ShellProcess.make();
    ComponentIterator iter = pc.iterator();
    iter.setShowInterior(false);

    while(iter.hasNext())
      System.out.println(iter.next());
  }
}
