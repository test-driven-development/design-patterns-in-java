package com.oozinoz.visualization;

import com.oozinoz.ui.UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;

public class Visualization extends JPanel implements ChangeListener {
  protected UI ui;

  protected JPanel machinePanel;

  protected JPanel buttonPanel;

  protected JButton addButton;

  protected JButton undoButton;

  protected Icon image = UI.getIcon("images/machine.png");

  protected FactoryModel factoryModel = new FactoryModel();

  protected VisMediator mediator;

  public Visualization(UI ui) {
    super(new BorderLayout());
    this.ui = ui;
    mediator = new VisMediator(factoryModel);
    factoryModel.addChangeListener(this);
    add(machinePanel(), BorderLayout.CENTER);
    add(buttonPanel(), BorderLayout.SOUTH);
  }

  protected JPanel machinePanel() {
    if(machinePanel == null) {
      machinePanel = new JPanel(null);
      machinePanel.setBackground(Color.WHITE);
      machinePanel.setPreferredSize(new Dimension(600, 500));
    }
    return machinePanel;
  }

  protected JPanel buttonPanel() {
    if(buttonPanel == null) {
      buttonPanel = new JPanel();
      buttonPanel.add(addButton());
      buttonPanel.add(undoButton());
    }
    return buttonPanel;
  }

  protected JButton addButton() {
    if(addButton == null) {
      addButton = ui.createButtonOk();
      addButton.setText("Add");
      addButton.addActionListener(mediator.addAction());
    }
    return addButton;
  }

  protected JButton undoButton() {
    if(undoButton == null) {
      undoButton = ui.createButtonCancel();
      undoButton.setText("Undo");
      undoButton.setEnabled(false);
      undoButton.addActionListener(mediator.undoAction());
    }
    return undoButton;
  }

  // Create a standard picture of a machine
  protected Component createPictureBox(Point p) {
    Component result = new JButton("machine", image);
    result.setSize(128, 128);
    result.setLocation(p);

    result.addMouseListener(mediator.mouseDownAction());
    return result;
  }

  public void stateChanged(ChangeEvent e) {
    machinePanel().removeAll();

    List locations = factoryModel.getLocations();

    for(int i = 0; i < locations.size(); i++) {
      Point p = (Point) locations.get(i);
      machinePanel().add(createPictureBox(p));
    }

    undoButton().setEnabled(factoryModel.canUndo());

    repaint();
  }
}
