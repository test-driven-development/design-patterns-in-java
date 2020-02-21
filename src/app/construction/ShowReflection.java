package app.construction;

import java.awt.*;
import java.lang.reflect.Constructor;

public class ShowReflection {

  public static void main(String[] args) {
    Constructor[] cc = Point.class.getConstructors();

    Constructor cons = null;
    for(int i = 0; i < cc.length; i++) {
      if(cc[i].getParameterTypes().length == 2)
        cons = cc[i];
    }

    try {
      Object obj = cons.newInstance(
        new Integer(3), new Integer(4));

      System.out.println(obj);

    }
    catch(Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }
}
