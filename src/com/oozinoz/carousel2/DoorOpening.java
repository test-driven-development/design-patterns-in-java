package com.oozinoz.carousel2;

public class DoorOpening extends DoorState {
  public void touch(Door door) {
    door.setState(CLOSING);
  }

  public void complete(Door door) {
    door.setState(DoorConstants.OPEN);
  }
}
