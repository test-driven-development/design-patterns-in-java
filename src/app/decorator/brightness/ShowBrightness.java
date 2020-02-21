package app.decorator.brightness;

import com.oozinoz.function.*;
import com.oozinoz.ui.SwingFacade;

public class ShowBrightness {
  public static void main(String[] args) {
    FunPanel panel = new FunPanel();
    panel.setPreferredSize(new java.awt.Dimension(200, 200));

    Function brightness = new Arithmetic(
      '*',
      new Exp(
        new Arithmetic(
          '*',
          new Constant(-4),
          new T())),
      new Sin(
        new Arithmetic(
          '*',
          new Constant(Math.PI),
          new T())));

    panel.setXY(new T(), brightness);

    SwingFacade.launch(panel, "Brightness");
  }
}
