package com.oozinoz.carousel;

public abstract class DoorState {
  protected Door2 door;

  public DoorState(Door2 door) {
    this.door = door;
  }

  public abstract void touch();

  public void complete() {
  }

  public void timeout() {
  }

  public String status() {
    String s = getClass().getName();
    return s.substring(s.lastIndexOf('.') + 1);
  }
}
