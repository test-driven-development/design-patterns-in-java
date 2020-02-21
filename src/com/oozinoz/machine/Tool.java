package com.oozinoz.machine;

public class Tool implements VisualizationItem {
  protected ToolCart toolCart;

  public ToolCart getToolCart() {
    return toolCart;
  }

  public void setToolCart(ToolCart value) {
    toolCart = value;
  }

  public Engineer getResponsible() {
    return toolCart.getResponsible();
  }

}
