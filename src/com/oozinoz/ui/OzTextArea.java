package com.oozinoz.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OzTextArea extends JPanel {
  protected JTextArea textArea = new JTextArea();

  protected TitledBorder border;

  public OzTextArea() {
    setLayout(new BorderLayout());
    JScrollPane jsp = new JScrollPane(textArea);
    jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory
      .createRaisedBevelBorder(), BorderFactory.createEmptyBorder(5,
      5, 5, 5)));
    add(jsp, "Center");
  }

  public void append(String text) {
    textArea().append(text);
  }

  public void clear() {
    textArea().setText("");
  }

  public Object clone() {
    OzTextArea ta = new OzTextArea();
    ta.setFont(textArea().getFont());
    ta.setCursor(getCursor());
    return ta;
  }

  public void setFont(Font font) {
    textArea().setFont(font);
  }

  protected JTextArea textArea() {
    if(textArea == null) {
      textArea = new JTextArea();
      textArea.setMargin(new Insets(20, 20, 20, 20));
    }
    return textArea;
  }
}
