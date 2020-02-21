package app.observer.ballistics;

import com.oozinoz.ballistics.Ballistics;
import com.oozinoz.ui.SwingFacade;
import com.oozinoz.utility.Format;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ShowBallistics implements ChangeListener {
  protected BallisticsPanel burnPanel;
  protected JSlider slider;
  protected double sliderMax;
  protected double sliderMin;
  protected BallisticsPanel thrustPanel;
  protected JLabel valueLabel;

  public static void main(String[] args) {
    SwingFacade.launch(new ShowBallistics().mainPanel(),
      "Effects of tPeak");
  }

  protected JPanel curvePanel() {
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(1, 2));
    p.add(SwingFacade.createTitledPanel("Burn Rate", burnPanel()));
    p.add(SwingFacade.createTitledPanel("Thrust", thrustPanel()));
    return p;
  }

  protected JPanel mainPanel() {
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(curvePanel(), "Center");
    p.add(sliderBox(), "South");
    return p;
  }

  public JSlider slider() {
    if(slider == null) {
      slider = new JSlider();
      sliderMax = slider.getMaximum();
      sliderMin = slider.getMinimum();
      slider.addChangeListener(this);
      slider.setValue(slider.getMinimum());
    }
    return slider;
  }

  protected Box sliderBox() {
    Box b = Box.createHorizontalBox();
    JLabel label = new JLabel("tPeak");
    label.setFont(SwingFacade.getStandardFont());
    label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    label.setForeground(java.awt.Color.black);
    b.add(label);
    b.add(valueLabel());
    b.add(slider());
    return b;
  }

  public void stateChanged(ChangeEvent e) {
    double val = slider.getValue();
    double tp = (val - sliderMin) / (sliderMax - sliderMin);
    burnPanel().setTPeak(tp);
    thrustPanel().setTPeak(tp);
    valueLabel().setText(Format.formatToNPlaces(tp, 2));
  }

  protected JLabel valueLabel() {
    if(valueLabel == null) {
      valueLabel = new JLabel();
      valueLabel.setFont(SwingFacade.getStandardFont());
      valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
      valueLabel.setForeground(java.awt.Color.black);
    }
    return valueLabel;
  }

  protected BallisticsPanel burnPanel() {
    if(burnPanel == null) {
      burnPanel = new BallisticsPanel(Ballistics.rate());
      burnPanel.setPreferredSize(new Dimension(300, 200));
    }
    return burnPanel;
  }

  protected BallisticsPanel thrustPanel() {
    if(thrustPanel == null) {
      thrustPanel = new BallisticsPanel(Ballistics.thrust());
      thrustPanel.setPreferredSize(new Dimension(300, 200));
    }
    return thrustPanel;
  }
}
