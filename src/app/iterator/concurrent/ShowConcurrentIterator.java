package app.iterator.concurrent;

import java.util.*;

public class ShowConcurrentIterator implements Runnable {
  private List list;

  protected static List upMachineNames() {
    return new ArrayList(Arrays.asList("Mixer1201",
      "ShellAssembler1301", "StarPress1401", "UnloadBuffer1501"));
  }

  public static void main(String[] args) {
    new ShowConcurrentIterator().go();
  }

  protected void go() {
    list = Collections.synchronizedList(upMachineNames());
    Iterator iter = list.iterator();
    int i = 0;
    while(iter.hasNext()) {
      i++;
      if(i == 2) { // simulate wake-up
        new Thread(this).start();
        try { Thread.sleep(100); } catch(InterruptedException ignored) {}
      }
      System.out.println(iter.next());
    }
  }

  public void run() {
    list.add(0, "Fuser1101");
  }
}
