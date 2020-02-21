package app.interpreter;

import com.oozinoz.machine.*;
import com.oozinoz.robotInterpreter.CarryCommand;
import com.oozinoz.robotInterpreter.CommandSequence;

public class ShowInterpreter {
  public static void main(String[] args) {
    MachineComposite dublin = OozinozFactory.dublin();
    ShellAssembler assembler = (ShellAssembler) dublin.find("ShellAssembler:3302");
    StarPress press = (StarPress) dublin.find("StarPress:3404");
    Fuser fuser = (Fuser) dublin.find("Fuser:3102");

    assembler.load(new Bin(11011));
    press.load(new Bin(11015));

    CarryCommand carry1 = new CarryCommand(assembler, fuser);
    CarryCommand carry2 = new CarryCommand(press, fuser);

    CommandSequence seq = new CommandSequence();
    seq.add(carry1);
    seq.add(carry2);

    seq.execute();
  }
}
