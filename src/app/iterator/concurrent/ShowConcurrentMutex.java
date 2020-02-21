package app.iterator.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShowConcurrentMutex implements Runnable {
  private List list;

  protected static List upMachineNames() {
    return new ArrayList(Arrays.asList("Mixer1201",
      "ShellAssembler1301", "StarPress1401", "UnloadBuffer1501"));
  }

  public static void main(String[] args) {
    new ShowConcurrentMutex().go();
  }

  protected void go() {
    System.out.println("This version synchronizes properly:");
    list = Collections.synchronizedList(upMachineNames());
    synchronized(list) {
      display();
    }
  }

  private void display() {
    for(int i = 0; i < list.size(); i++) {
      if(i == 1) { // simulate wake-up
        new Thread(this).start();
        try {
          Thread.sleep(100);
        }
        catch(InterruptedException ignored) {
        }
      }
      System.out.println(list.get(i));
    }
  }

  public void run() {
    synchronized(list) {
      list.add(0, "Fuser1101");
    }
  }
}
