package app.observer.ballistics3;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 *
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose,
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import com.oozinoz.ballistics.BallisticsFunction;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 Plot a ballistics function. This class is refactored from BallisticsPanel_2
 to rely on a Tpeak object from the business domain.

 @author Steven J. Metsker */
public class BallisticsPanel extends JPanel implements Observer {
  protected BallisticsFunction func;

  protected int nPoint = 101;
  protected int[] x = new int[nPoint];
  protected int[] y = new int[nPoint];
  double tPeak = 0;

  /**
   Create a panel that can display the provided function.

   @param func  the ballistics function to plot. Ballistics functions vary
   with time and with the time of peak burn area.
   @param tPeak an observable model of the time when burn area peaks
   */
  public BallisticsPanel(BallisticsFunction func, Tpeak tPeak) {
    this.func = func;
    tPeak.addObserver(this);
  }

  /**
   Respond to a change in the observed Tpeak model

   @param Observable presumably the model we are observing
   @param arg        ignored
   */
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
