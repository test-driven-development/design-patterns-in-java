package app.observer.ballistics;

import com.oozinoz.ballistics.BallisticsFunction;

import javax.swing.*;
import java.awt.*;

public class BallisticsPanel extends JPanel {
  protected BallisticsFunction func;

  protected int nPoint = 101;

  protected double tPeak = 0.0;

  protected int[] x = new int[nPoint];

  protected int[] y = new int[nPoint];

  public BallisticsPanel(BallisticsFunction func) {
    this.func = func;
  }

  public void setTPeak(double tPeak) {
    this.tPeak = tPeak;
    repaint();
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // paint the background
    for(int i = 0; i < nPoint; i++) {
      double t = ((double) i) / (nPoint - 1);
      x[i] = (int) (t * getWidth());
      y[i] = (int) (getHeight() * (1 - func.function(t, tPeak)));
    }
    g.drawPolyline(x, y, nPoint);
  }
}
