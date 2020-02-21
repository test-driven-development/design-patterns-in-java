package com.oozinoz.machine;

public class Tub {
  private String id;

  private TubMediator mediator = null;

  public Tub(String id, TubMediator mediator) {
    this.id = id;
    this.mediator = mediator;
  }

  public Machine getLocation() {
    return mediator.getMachine(this);
  }

  public void setLocation(Machine value) {
    mediator.set(this, value);
  }

  public String toString() {
    return id;
  }

  public int hashCode() {
    return id.hashCode();
  }

  public boolean equals(Object obj) {
    if(obj == this)
      return true;

    if(obj.getClass() != Tub.class)
      return false;

    Tub that = (Tub) obj;
    return id.equals(that.id);
  }
}
