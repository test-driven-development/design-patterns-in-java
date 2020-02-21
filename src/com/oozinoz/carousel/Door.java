package com.oozinoz.carousel;

import java.util.Observable;

public class Door extends Observable {
  public final int CLOSED = -1;
  public final int OPENING = -2;
  public final int OPEN = -3;
  public final int CLOSING = -4;
  public final int STAYOPEN = -5;

  private int state = CLOSED;

  public void touch() {
    switch(state) {
      case OPENING:
      case STAYOPEN:
        setState(CLOSING);
        break;
      case CLOSING:
      case CLOSED:
        setState(OPENING);
        break;
      case OPEN:
        setState(STAYOPEN);
        break;
      default:
        throw new Error("can't happen");
    }
  }

  public void complete() {
    if(state == OPENING)
      setState(OPEN);
    else if(state == CLOSING)
      setState(CLOSED);
  }

  public void timeout() {
    setState(CLOSING);
  }

  public String status() {
    switch(state) {
      case OPENING:
        return "Opening";
      case OPEN:
        return "Open";
      case CLOSING:
        return "Closing";
      case STAYOPEN:
        return "StayOpen";
      default:
        return "Closed";
    }
  }

  private void setState(int state) {
    this.state = state;
    setChanged();
    notifyObservers();
  }
}
