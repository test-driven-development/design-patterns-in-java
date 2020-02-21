package com.oozinoz.carousel2;

public class DoorStayOpen extends DoorState {
  public void touch(Door door) {
    door.setState(CLOSING);
  }
}
