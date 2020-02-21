package app.decorator;

import app.decorator.brightness.FunPanel;
import com.oozinoz.function.*;
import com.oozinoz.ui.SwingFacade;

public class ShowFun {
  public static void main(String[] args) {
    Function theta = new Arithmetic('*', new T(), new Constant(2 * Math.PI));
    Function theta2 = new Arithmetic('*', new T(), new Constant(2 * Math.PI * 5));
    Function x = new Arithmetic('+', new Cos(theta), new Cos(theta2));
    Function y = new Arithmetic('+', new Sin(theta), new Sin(theta2));

    FunPanel panel = new FunPanel(1000);
    panel.setPreferredSize(new java.awt.Dimension(200, 200));

    panel.setXY(x, y);
    SwingFacade.launch(panel, "Chrysanthemum");
  }
}
