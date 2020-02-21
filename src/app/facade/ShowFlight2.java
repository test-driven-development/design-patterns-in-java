package app.facade;

import com.oozinoz.function.Function;
import com.oozinoz.function.T;
import com.oozinoz.ui.PlotPanel;
import com.oozinoz.ui.UI;

import javax.swing.*;
import java.awt.*;

public class ShowFlight2 {
  public static void main(String[] args) {
    PlotPanel p = new PlotPanel(101, new T(), new ShowFlight2().new YFunction());
    p.setPreferredSize(new Dimension(300, 200));

    JFrame frame = new JFrame("Flight Path for Shell Duds");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(UI.NORMAL.createTitledPanel("Flight Path", p));

    frame.pack();
    frame.setVisible(true);
  }

  private class YFunction extends Function {
    public YFunction() {
      super(new Function[] {});
    }

    public double f(double t) {
      // y is 0 at t = 0, 1; y is 1 at t = .5
      return 4 * t * (1 - t);
    }
  }
}
