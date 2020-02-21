package app.observer.ballistics3;

import com.oozinoz.utility.Format;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class BallisticsLabel extends JLabel implements Observer {
  public BallisticsLabel(Tpeak tPeak) {
    tPeak.addObserver(this);
  }

  public void update(Observable obj, Object arg) {
    setText(Format.formatToNPlaces(((Tpeak) obj).getValue(), 2));
    repaint();
  }
}
