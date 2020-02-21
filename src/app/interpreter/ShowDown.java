package app.interpreter;

import com.oozinoz.machine.MachineComposite;
import com.oozinoz.machine.OozinozFactory;
import com.oozinoz.robotInterpreter2.Command;
import com.oozinoz.robotInterpreter2.ForCommand;
import com.oozinoz.robotInterpreter2.ShutDownCommand;
import com.oozinoz.robotInterpreter2.Variable;

class ShowDown {
  public static void main(String[] args) {
    MachineComposite dublin = OozinozFactory.dublin();
    Variable v = new Variable("machine");
    Command c = new ForCommand(dublin, v, new ShutDownCommand(v));
    c.execute();
  }
}
