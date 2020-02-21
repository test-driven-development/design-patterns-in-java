package com.oozinoz.visualization;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualization2 extends Visualization {
  public Visualization2(UI ui) {
    super(ui);
  }

  public static void main(String[] args) {
    Visualization2 panel = new Visualization2(UI.NORMAL);
    JFrame frame = SwingFacade.launch(panel, "Operational Model");
    frame.setJMenuBar(panel.menus());
    frame.setVisible(true);
  }

  public JMenuBar menus() {
    JMenuBar menuBar = new JMenuBar();

    JMenu menu = new JMenu("File");
    menuBar.add(menu);

    JMenuItem menuItem = new JMenuItem("Save As...");
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        save();
      }
    });

    menu.add(menuItem);

    menuItem = new JMenuItem("Restore From...");
    menuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        restore();
      }

    });
    menu.add(menuItem);

    return menuBar;
  }

  public void save() {
    try {
      mediator.save(this);
    }
    catch(Exception ex) {
      System.out.println("Failed save: " + ex.getMessage());
    }
  }

  public void restore() {
    try {
      mediator.restore(this);
    }
    catch(Exception ex) {
      System.out.println("Failed restore: " + ex.getMessage());
    }
  }
}
