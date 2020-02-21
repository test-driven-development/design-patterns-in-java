package app.proxy.dynamic;

import com.oozinoz.firework.Firecracker;
import com.oozinoz.firework.Sparkler;
import com.oozinoz.utility.Dollars;

import java.util.HashSet;
import java.util.Set;

public class ShowDynamicProxy {
  public static void main(String[] args) {
    Set s = new HashSet();
    s = (Set) ImpatientProxy.newInstance(s);
    s.add(new Sparkler("Mr. Twinkle", new Dollars(0.05)));
    s.add(new BadApple("Lemon"));
    s.add(new Firecracker("Mr. Boomy", new Dollars(0.25)));

    System.out.println("The set contains " + s.size() + " things.");
  }
}
