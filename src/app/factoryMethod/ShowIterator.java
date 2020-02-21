package app.factoryMethod;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ShowIterator {
  public static void main(String[] args) {
    List list = Arrays.asList(
      "fountain", "rocket", "sparkler");

    Iterator iter = list.iterator();

    while(iter.hasNext())
      System.out.println(iter.next());

    // Uncomment the next line to see the iterator's actual class:
    // System.out.println(iter.getClass().getName());
  }
}
