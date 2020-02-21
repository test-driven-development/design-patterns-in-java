package com.oozinoz.machine;

public class AmbitiousMenu {
  public Engineer getResponsible(VisualizationItem item) {
    if(item instanceof Tool) {
      Tool t = (Tool) item;
      return t.getToolCart().getResponsible();
    }
    if(item instanceof ToolCart) {
      ToolCart tc = (ToolCart) item;
      return tc.getResponsible();
    }
    if(item instanceof MachineComponent) {
      MachineComponent c = (MachineComponent) item;
      if(c.getResponsible() != null)
        return c.getResponsible();

      if(c.getParent() != null)
        return c.getParent().getResponsible();
    }
    return null;
  }
}
