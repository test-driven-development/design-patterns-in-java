package com.oozinoz.machine;

public class ToolCart implements VisualizationItem {
  protected Engineer responsible;

  public ToolCart(Engineer e) {
    this.responsible = e;
  }

  public Engineer getResponsible() {
    return responsible;
  }

  public void setResponsible(Engineer value) {
    this.responsible = value;
  }
}
