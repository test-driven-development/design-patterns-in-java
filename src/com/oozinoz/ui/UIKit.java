package com.oozinoz.ui;

import javax.swing.*;
import java.awt.*;

public class UIKit {
  protected OzButton button = new OzButton();

  protected OzTextArea textArea = new OzTextArea();

  public static UIKit fullScreen() {
    Font font = new Font("Dialog", Font.ITALIC, 18);
    UIKit kit = new UIKit();
    kit.button.setFont(font);
    kit.textArea.setFont(font);
    return kit;
  }

  public static UIKit handheld() {
    UIKit kit = new UIKit();
    Font font = new Font("Dialog", Font.PLAIN, 8);
    kit.button.setFont(font);
    kit.textArea = new OzTextArea();
    kit.textArea.setFont(font);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    kit.textArea.setCursor(cursor);
    return kit;
  }

  public JButton createButton(String text) {
    JButton b = new JButton(text);
    b.setFont(button.getFont());
    return b;
  }

  public OzTextArea createTextArea() {
    return (OzTextArea) textArea.clone();
  }
}
