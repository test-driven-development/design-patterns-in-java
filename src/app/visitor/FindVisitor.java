package app.visitor;

import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.MachineComposite;
import com.oozinoz.machine.MachineVisitor;

import java.util.Iterator;

public class FindVisitor implements MachineVisitor {
  private int soughtId;

  private MachineComponent found;

  public MachineComponent find(MachineComponent mc, int id) {
    found = null;
    soughtId = id;
    mc.accept(this);
    return found;
  }

  public void visit(Machine m) {
    if(found == null && m.getId() == soughtId)
      found = m;
  }

  public void visit(MachineComposite mc) {
    if(found == null && mc.getId() == soughtId) {
      found = mc;
      return;
    }
    Iterator iter = mc.getComponents().iterator();
    while(found == null && iter.hasNext())
      ((MachineComponent) iter.next()).accept(this);
  }
}
