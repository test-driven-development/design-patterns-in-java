package app.observer.ballistics3;

import java.util.Observable;

public class Tpeak extends Observable {
  protected double value;

  public Tpeak(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
    setChanged();
    notifyObservers();
  }
}
