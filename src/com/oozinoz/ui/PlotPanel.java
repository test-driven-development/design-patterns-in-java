package com.oozinoz.ui;

import com.oozinoz.function.Function;

import javax.swing.*;
import java.awt.*;

public class PlotPanel extends JPanel {
  private int points;

  private int[] xPoints;
  private int[] yPoints;

  private Function xFunction;
  private Function yFunction;

  public PlotPanel(int nPoint, Function xFunc, Function yFunc) {
    points = nPoint;
    xPoints = new int[points];
    yPoints = new int[points];
    xFunction = xFunc;
    yFunction = yFunc;
    setBackground(Color.WHITE);
  }

  protected void paintComponent(Graphics graphics) {
    double w = getWidth() - 1;
    double h = getHeight() - 1;

    for(int i = 0; i < points; i++) {
      double t = ((double) i) / (points - 1);
      xPoints[i] = (int) (xFunction.f(t) * w);
      yPoints[i] = (int) (h * (1 - yFunction.f(t)));
    }

    graphics.drawPolyline(xPoints, yPoints, points);
  }
}
