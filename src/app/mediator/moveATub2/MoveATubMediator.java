package app.mediator.moveATub2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveATubMediator implements ListSelectionListener, ActionListener {
  MoveATub2 gui;
  NameBase data;

  private Object selectedMachine;
  private Object selectedTub;

  public MoveATubMediator(MoveATub2 gui, NameBase data) {
    this.gui = gui;
    this.data = data;
  }

  public void actionPerformed(ActionEvent e) {
    if(selectedMachine == null || selectedTub == null)
      return;
    String tubName = selectedTub.toString();
    String fromMachineName = data.getMachineContaining(tubName);
    String toMachineName = selectedMachine.toString();
    data.put(tubName, toMachineName);
    updateTubList(fromMachineName);
    gui.assignButton().setEnabled(false);
  }

  public void valueChanged(ListSelectionEvent e) {
    JList sender = (JList) e.getSource();

    if(!sender.isSelectionEmpty()) {
      Object selection = sender.getSelectedValue();

      if(sender.equals(gui.boxList()))
        this.updateTubList(selection.toString());
      else if(sender.equals(gui.machineList()))
        selectedMachine = selection;
      else if(sender.equals(gui.tubList()))
        selectedTub = selection;
    }

    gui.assignButton().setEnabled(
      !gui.tubList().isSelectionEmpty() && !gui.machineList().isSelectionEmpty());
  }

  public void updateTubList(String machineName) {
    gui.tubList().setListData(data.tubNames(machineName));
  }
}
