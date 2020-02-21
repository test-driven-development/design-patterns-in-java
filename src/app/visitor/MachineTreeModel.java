package app.visitor;

import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.MachineComposite;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class MachineTreeModel implements TreeModel {
  protected MachineComponent root;

  public MachineTreeModel(MachineComponent root) {
    this.root = root;
  }

  public void addTreeModelListener(javax.swing.event.TreeModelListener l) {
  }

  public Object getChild(Object parent, int index) {
    if(parent instanceof MachineComposite) {
      MachineComposite c = (MachineComposite) parent;
      return c.getComponents().get(index);
    }
    return null;
  }

  public int getChildCount(Object parent) {
    if(parent instanceof MachineComposite) {
      MachineComposite c = (MachineComposite) parent;
      return c.getComponents().size();
    }
    return 0;
  }

  public int getIndexOfChild(Object parent, Object child) {
    if(parent instanceof MachineComposite) {
      MachineComposite c = (MachineComposite) parent;
      return c.getComponents().indexOf(child);
    }
    return 0;
  }

  public Object getRoot() {
    return root;
  }

  public boolean isLeaf(Object node) {
    return node instanceof Machine;
  }

  public void removeTreeModelListener(javax.swing.event.TreeModelListener l) {
  }

  public void valueForPathChanged(TreePath path, Object newValue) {
  }
}
