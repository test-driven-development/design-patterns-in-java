package app.visitor;

import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.OozinozFactory;

public class ShowFindVisitor {
  public static void main(String[] args) {
    MachineComponent factory = OozinozFactory.dublin();
    MachineComponent machine = new FindVisitor().find(factory, 3404);
    System.out.println(machine != null ? machine.toString() : "Not found");
  }
}
