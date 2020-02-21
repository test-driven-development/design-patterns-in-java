package app.visitor;

import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.MachineComposite;
import com.oozinoz.machine.MachineVisitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RakeVisitor implements MachineVisitor {
  private Set leaves;

  public Set getLeaves(MachineComponent mc) {
    leaves = new HashSet();
    mc.accept(this);
    return leaves;
  }

  public void visit(Machine m) {
    leaves.add(m);
  }

  public void visit(MachineComposite mc) {
    Iterator iter = mc.getComponents().iterator();
    while(iter.hasNext())
      ((MachineComponent) iter.next()).accept(this);
  }
}
