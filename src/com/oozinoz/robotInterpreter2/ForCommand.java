package com.oozinoz.robotInterpreter2;

import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.MachineComposite;

import java.util.List;

public class ForCommand extends Command {
  protected MachineComponent root;
  protected Variable variable;
  protected Command body;

  public ForCommand(MachineComponent mc, Variable v, Command body) {
    this.root = mc;
    this.variable = v;
    this.body = body;
  }

  public void execute() {
    execute(root);
  }

  private void execute(MachineComponent mc) {
    if(mc instanceof Machine) {
      Machine m = (Machine) mc;
      variable.assign(new Constant(m));
      body.execute();
      return;
    }

    MachineComposite comp = (MachineComposite) mc;
    List children = comp.getComponents();
    for(int i = 0; i < children.size(); i++) {
      MachineComponent child = (MachineComponent) children.get(i);
      execute(child);
    }
  }
}
