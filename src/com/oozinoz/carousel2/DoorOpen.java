package com.oozinoz.carousel2;

public class DoorOpen extends DoorState {
  public void touch(Door door) {
    door.setState(STAYOPEN);
  }

  public void timeout(Door door) {
    door.setState(DoorConstants.CLOSING);
  }
}
