package app.templateMethod;

import com.oozinoz.firework.Rocket;

import java.util.Comparator;

public class ApogeeComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    Rocket r1 = (Rocket) o1;
    Rocket r2 = (Rocket) o2;
    return Double.compare(r1.getApogee(), r2.getApogee());
  }
}
