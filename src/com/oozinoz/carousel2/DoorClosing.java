package com.oozinoz.carousel2;

public class DoorClosing extends DoorState {
  public void touch(Door door) {
    door.setState(OPENING);
  }

  public void complete(Door door) {
    door.setState(DoorConstants.CLOSED);
  }
}
