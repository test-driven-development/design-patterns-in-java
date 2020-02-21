package app.abstractFactory;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;
import com.oozinoz.visualization.Visualization2;

import javax.swing.*;

public class ShowVisualization2 {
  public static void main(String[] args) {
    Visualization2 panel = new Visualization2(UI.NORMAL);
    JFrame frame = SwingFacade.launch(panel, "Operational Model");

    frame.setJMenuBar(panel.menus());
    frame.setVisible(true);
  }
}
