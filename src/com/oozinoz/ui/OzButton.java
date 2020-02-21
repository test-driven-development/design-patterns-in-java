package com.oozinoz.ui;

import javax.swing.*;

public class OzButton extends JButton {
  OzButton() {
  }

  public Object clone() {
    OzButton b = new OzButton();
    b.setFont(getFont());
    b.setCursor(getCursor());
    return b;
  }
}
