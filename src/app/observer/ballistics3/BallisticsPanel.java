package app.observer.ballistics3;

import com.oozinoz.ballistics.BallisticsFunction;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class BallisticsPanel extends JPanel implements Observer {
  protected BallisticsFunction func;

  protected int nPoint = 101;
  protected int[] x = new int[nPoint];
  protected int[] y = new int[nPoint];
  double tPeak = 0;

  public BallisticsPanel(BallisticsFunction func, Tpeak tPeak) {
    this.func = func;
    tPeak.addObserver(this);
  }

  public void update(Observable o, Object arg) {
    tPeak = ((Tpeak) o).getValue();
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
