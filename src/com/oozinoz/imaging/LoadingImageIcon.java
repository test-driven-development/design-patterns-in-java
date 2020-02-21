package com.oozinoz.imaging;

import javax.swing.*;

public class LoadingImageIcon extends ImageIcon implements Runnable {
  static final ImageIcon ABSENT = new ImageIcon(ClassLoader.getSystemResource("images/absent.jpg"));
  static final ImageIcon LOADING = new ImageIcon(ClassLoader.getSystemResource("images/loading.jpg"));
  protected String filename;
  protected JFrame callbackFrame;

  public LoadingImageIcon(String filename) {
    super(ABSENT.getImage());
    this.filename = filename;
  }

  public void load(JFrame callbackFrame) {
    this.callbackFrame = callbackFrame;
    setImage(LOADING.getImage());
    callbackFrame.repaint();
    new Thread(this).start();
  }

  public void run() {
    setImage(new ImageIcon(ClassLoader.getSystemResource(filename)).getImage());
    callbackFrame.pack();
  }
}
