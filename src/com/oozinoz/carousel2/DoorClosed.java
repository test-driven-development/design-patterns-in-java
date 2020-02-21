package com.oozinoz.carousel2;

public class DoorClosed extends DoorState {
  public void touch(Door door) {
    door.setState(OPENING);
  }
}
