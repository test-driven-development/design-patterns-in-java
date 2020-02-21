package app.composite;

import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.OozinozFactory;

public class ShowPlant {
  public static void main(String[] args) {
    MachineComponent c = OozinozFactory.plant();
    System.out.println("Number of machines: " + c.getMachineCount());
  }
}
