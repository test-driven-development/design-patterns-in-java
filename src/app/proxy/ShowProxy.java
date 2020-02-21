package app.proxy;

import com.oozinoz.imaging.ImageIconProxy;
import com.oozinoz.imaging.LoadingImageIcon;
import com.oozinoz.ui.SwingFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowProxy implements ActionListener {
  private ImageIconProxy proxy = new ImageIconProxy("images/fest.jpg");
  private JFrame frame;
  private JButton loadButton;

  public static void main(String[] args) {
    ShowProxy sp = new ShowProxy();
    sp.frame = SwingFacade.launch(sp.mainPanel(), " Proxy");
  }

  public void actionPerformed(ActionEvent e) {
    proxy.load(frame);
    loadButton().setEnabled(false);
  }

  protected JButton loadButton() {
    if(loadButton == null) {
      loadButton = new JButton("Load");
      loadButton.addActionListener(this);
      loadButton.setFont(SwingFacade.getStandardFont());
    }
    return loadButton;
  }

  protected JPanel mainPanel() {
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add("Center", new JLabel(proxy));
    p.add("South", loadButton());
    return p;
  }
}
