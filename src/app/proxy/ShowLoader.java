package app.proxy;

import com.oozinoz.imaging.LoadingImageIcon;
import com.oozinoz.ui.SwingFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowLoader implements ActionListener {
  private JFrame frame;
  private JButton loadButton;
  private LoadingImageIcon loader = new LoadingImageIcon("images/fest.jpg");

  public static void main(String[] args) {
    ShowLoader sl = new ShowLoader();
    sl.frame = SwingFacade.launch(sl.mainPanel(), " Proxy");
  }

  public void actionPerformed(ActionEvent e) {
    loader.load(frame);
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
    p.add("Center", new JLabel(loader));
    p.add("South", loadButton());
    return p;
  }
}
