package com.oozinoz.carousel2;

import java.util.Observable;

public class Door extends Observable implements DoorConstants {
  private DoorState state = CLOSED;

  public void touch() {
    state.touch(this);
  }

  public void complete() {
    state.complete(this);
  }

  public void setState(DoorState state) {
    this.state = state;
    setChanged();
    notifyObservers();
  }

  public String status() {
    return state.status();
  }

  public void timeout() {
    state.timeout(this);
  }
}
