package app.adapter;

import com.oozinoz.firework.Rocket;

import javax.swing.table.AbstractTableModel;

public class RocketTableModel extends AbstractTableModel {
  protected Rocket[] rockets;
  protected String[] columnNames = new String[] {"Name", "Price", "Apogee"};

  public RocketTableModel(Rocket[] rockets) {
    this.rockets = rockets;
  }

  public int getColumnCount() {
    return columnNames.length;
  }

  public String getColumnName(int i) {
    return columnNames[i];
  }

  public int getRowCount() {
    return rockets.length;
  }

  public Object getValueAt(int row, int col) {
    switch(col) {
      case 0:
        return rockets[row].getName();
      case 1:
        return rockets[row].getPrice();
      case 2:
        return new Double(rockets[row].getApogee());
      default:
        return null;
    }
  }
}
