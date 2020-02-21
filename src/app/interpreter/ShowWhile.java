package app.interpreter;

import com.oozinoz.machine.Bin;
import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComposite;
import com.oozinoz.machine.OozinozFactory;
import com.oozinoz.robotInterpreter2.*;

public class ShowWhile {
  public static void main(String[] args) {
    MachineComposite dublin = OozinozFactory.dublin();
    Term starPress = new Constant((Machine) dublin.find("StarPress:1401"));
    Term fuser = new Constant((Machine) dublin.find("Fuser:1101"));

    starPress.eval().load(new Bin(77));
    starPress.eval().load(new Bin(88));

    WhileCommand command = new WhileCommand(
      new HasMaterial(starPress),
      new CarryCommand(starPress, fuser));
    command.execute();
  }
}
