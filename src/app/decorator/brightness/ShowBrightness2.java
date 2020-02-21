package app.decorator.brightness;

import com.oozinoz.function.Function;
import com.oozinoz.function.T;
import com.oozinoz.ui.SwingFacade;

public class ShowBrightness2 {
  public static void main(String[] args) {
    FunPanel panel = new FunPanel();
    panel.setPreferredSize(new java.awt.Dimension(200, 200));

    Function brightness = new Brightness(new T());

    panel.setXY(new T(), brightness);

    SwingFacade.launch(panel, "Brightness");
  }
}
