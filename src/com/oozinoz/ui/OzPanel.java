package com.oozinoz.ui;

import javax.swing.*;

public class OzPanel extends JPanel implements Cloneable {

  public OzPanel copy() {
    return (OzPanel) this.clone();
  }

  public Object clone() {
    try {
      return super.clone();
    }
    catch(CloneNotSupportedException ignored) {
      throw new InternalError("OzPanel.clone() failed");
    }
  }

  public OzPanel copy2() {
    OzPanel result = new OzPanel();
    result.setBackground(this.getBackground());
    result.setForeground(this.getForeground());
    result.setFont(this.getFont());
    return result;
  }
}
