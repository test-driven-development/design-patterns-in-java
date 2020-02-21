package app.decorator.brightness;

import com.oozinoz.function.Function;
import com.oozinoz.function.T;

import javax.swing.*;
import java.awt.*;

public class FunPanel extends JPanel {
  protected Function fx = new T();

  protected Function fy = new T();

  protected int nPoint;

  protected int[] xArray;

  protected double xMax = 1;

  protected double xMin = 0;

  protected int[] yArray;

  protected double yMax = 1;

  protected double yMin = 0;

  public FunPanel() {
    this(101);
  }

  public FunPanel(int nPoint) {
    this.nPoint = nPoint;
    xArray = new int[nPoint];
    yArray = new int[nPoint];
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    double h = getHeight() - 1;
    double w = getWidth() - 1;
    for(int i = 0; i < nPoint; i++) {
      double t = ((double) i) / (nPoint - 1);
      xArray[i] = (int) (w * (fx.f(t) - xMin) / (xMax - xMin));
      yArray[i] = (int) (h - h * (fy.f(t) - yMin) / (yMax - yMin));
    }
    g.setColor(Color.black);
    g.drawPolyline(xArray, yArray, nPoint);
  }

  public void setXY(Function fx, Function fy) {
    this.fx = fx;
    this.fy = fy;
    calculateExtrema();
    repaint();
  }

  protected void calculateExtrema() {
    for(int i = 0; i < nPoint; i++) {
      double t = ((double) i) / (nPoint - 1);
      double dx = fx.f(t);
      double dy = fy.f(t);

      if(i == 0 || dx > xMax)
        xMax = dx;
      if(i == 0 || dx < xMin)
        xMin = dx;
      if(i == 0 || dy > yMax)
        yMax = dy;
      if(i == 0 || dy < yMin)
        yMin = dy;
    }
  }
}
