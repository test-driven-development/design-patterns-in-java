package app.observer.ballistics2;

import com.oozinoz.ballistics.Ballistics;
import com.oozinoz.ui.SwingFacade;

import javax.swing.*;
import java.awt.*;

public class ShowBallistics2 {
  protected BallisticsPanel2 burnPanel;

  protected JSlider slider;

  protected double sliderMax;

  protected double sliderMin;

  protected BallisticsPanel2 thrustPanel;

  protected JLabel valueLabel;

  public static void main(String[] args) {
    SwingFacade.launch(new ShowBallistics2().mainPanel(),
      "Effects of tPeak");
  }


  protected BallisticsPanel2 burnPanel() {
    if(burnPanel == null) {
      burnPanel = new BallisticsPanel2(Ballistics.rate(), slider());
      burnPanel.setPreferredSize(new Dimension(300, 200));
    }
    return burnPanel;
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

  protected JSlider slider() {
    if(slider == null) {
      slider = new JSlider();
      sliderMax = slider.getMaximum();
      sliderMin = slider.getMinimum();
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

  protected BallisticsPanel2 thrustPanel() {
    if(thrustPanel == null) {
      thrustPanel = new BallisticsPanel2(Ballistics.thrust(), slider());
      thrustPanel.setPreferredSize(new Dimension(300, 200));
    }
    return thrustPanel;
  }

  protected JLabel valueLabel() {
    if(valueLabel == null) {
      valueLabel = new BallisticsLabel2(slider());
      valueLabel.setFont(SwingFacade.getStandardFont());
      valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
      valueLabel.setForeground(java.awt.Color.black);
    }
    return valueLabel;
  }
}
