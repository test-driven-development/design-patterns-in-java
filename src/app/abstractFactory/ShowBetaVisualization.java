package app.abstractFactory;

import com.oozinoz.ui.BetaUI;
import com.oozinoz.ui.SwingFacade;
import com.oozinoz.visualization.Visualization;

import javax.swing.*;

public class ShowBetaVisualization {
  public static void main(String[] args) {
    JPanel panel = new Visualization(new BetaUI());
    SwingFacade.launch(panel, "Operational Model");
  }
}
