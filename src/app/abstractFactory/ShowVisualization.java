package app.abstractFactory;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;
import com.oozinoz.visualization.Visualization;

import javax.swing.*;

public class ShowVisualization {
  public static void main(String[] args) {
    JPanel panel = new Visualization(UI.NORMAL);
    SwingFacade.launch(panel, "Operational Model");
  }
}
