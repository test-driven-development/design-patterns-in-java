package app.observer.ballistics2;

import com.oozinoz.utility.Format;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BallisticsLabel2 extends JLabel implements ChangeListener {
  protected JSlider slider;

  public BallisticsLabel2(JSlider slider) {
    this.slider = slider;
    setText("0.00");
    slider.addChangeListener(this);
  }

  public void stateChanged(ChangeEvent e) {
    double val = slider.getValue();
    double max = slider.getMaximum();
    double min = slider.getMinimum();
    double tPeak = (val - min) / (max - min);
    setText(Format.formatToNPlaces(tPeak, 2));
  }
}
