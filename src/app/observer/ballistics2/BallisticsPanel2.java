package app.observer.ballistics2;

import com.oozinoz.ballistics.BallisticsFunction;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class BallisticsPanel2 extends JPanel implements ChangeListener {
  protected BallisticsFunction func;

  protected int nPoint = 101;

  protected double tPeak = 0.0;

  protected int[] x = new int[nPoint];

  protected int[] y = new int[nPoint];

  protected JSlider slider;

  public BallisticsPanel2(BallisticsFunction func, JSlider slider) {
    this.func = func;
    this.slider = slider;
    slider.addChangeListener(this);
  }

  public void stateChanged(ChangeEvent e) {
    double val = slider.getValue();
    double max = slider.getMaximum();
    double min = slider.getMinimum();
    tPeak = (val - min) / (max - min);
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
