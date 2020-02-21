package app.visitor;

import com.oozinoz.machine.OozinozFactory;
import com.oozinoz.ui.SwingFacade;

import javax.swing.*;

public class ShowMachineTreeModel {

  public ShowMachineTreeModel() {
    MachineTreeModel model = new MachineTreeModel(OozinozFactory.dublin());
    JTree tree = new JTree(model);
    tree.setFont(SwingFacade.getStandardFont());
    SwingFacade.launch(new JScrollPane(tree), " A New Oozinoz Factory");
  }

  public static void main(String[] args) {
    new ShowMachineTreeModel();
  }
}
