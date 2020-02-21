package app.observer.ballistics3;

import com.oozinoz.ballistics.Ballistics;
import com.oozinoz.ui.SwingFacade;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ShowBallistics3 {
  protected BallisticsPanel burnPanel;
  protected JSlider slider;
  protected double sliderMax;
  protected double sliderMin;
  protected BallisticsPanel thrustPanel;
  protected JLabel valueLabel;
  protected Tpeak tPeak = new Tpeak(0);

  public static void main(String[] args) {
    SwingFacade.launch(new ShowBallistics3().mainPanel(),
      "Effects of tPeak");
  }

  protected BallisticsPanel burnPanel() {
    if(burnPanel == null) {
      burnPanel = new BallisticsPanel(Ballistics.rate(), tPeak);
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
      slider.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
          if(sliderMax == sliderMin)
            return;

          tPeak.setValue((slider.getValue() - sliderMin)
            / (sliderMax - sliderMin));
        }
      });
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

  protected BallisticsPanel thrustPanel() {
    if(thrustPanel == null) {
      thrustPanel = new BallisticsPanel(Ballistics.thrust(), tPeak);
      thrustPanel.setPreferredSize(new Dimension(300, 200));
    }
    return thrustPanel;
  }

  protected JLabel valueLabel() {
    if(valueLabel == null) {
      valueLabel = new BallisticsLabel(tPeak);
      valueLabel.setFont(SwingFacade.getStandardFont());
      valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
      valueLabel.setForeground(java.awt.Color.black);
    }
    return valueLabel;
  }
}
