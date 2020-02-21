package app.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowForeach {
  public static void main(String[] args) {
    ShowForeach example = new ShowForeach();
    example.showIterator();

    System.out.println();
    example.showForeach();
  }

  public void showIterator() {
    List names = new ArrayList();
    names.add("Fuser:1101");
    names.add("StarPress:991");
    names.add("Robot:1");

    System.out.println("JDK 1.2-style Iterator:");
    for(Iterator it = names.iterator(); it.hasNext(); ) {
      String name = (String) it.next();
      System.out.println(name);
    }
  }

  public void showForeach() {
    //        List<String> names = new ArrayList<String>();
    //        names.add("Fuser:1101");
    //        names.add("StarPress:991");
    //        names.add("Robot:1");

    //        System.out.println("JDK 1.5-style Extended For Loop:");
    //        for (String name: names)
    //           System.out.println(name);
  }
}
