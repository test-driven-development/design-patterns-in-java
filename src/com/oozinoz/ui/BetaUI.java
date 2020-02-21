package com.oozinoz.ui;

import javax.swing.*;
import java.awt.*;

public class BetaUI extends UI {
  public BetaUI() {
    Font oldFont = getFont();
    font = new Font(oldFont.getName(), oldFont.getStyle() | Font.ITALIC, oldFont.getSize());
  }

  public JButton createButtonOk() {
    JButton b = super.createButtonOk();
    b.setIcon(getIcon("images/cherry-large.gif"));
    return b;
  }

  public JButton createButtonCancel() {
    JButton b = super.createButtonCancel();
    b.setIcon(getIcon("images/cherry-large-down.gif"));
    return b;
  }
}
