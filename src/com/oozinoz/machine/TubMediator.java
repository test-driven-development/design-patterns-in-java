package com.oozinoz.machine;

import java.util.*;

public class TubMediator {
  protected Map tubToMachine = new HashMap();

  public Machine getMachine(Tub t) {
    return (Machine) tubToMachine.get(t);
  }

  public Set getTubs(Machine m) {
    Set set = new HashSet();
    Iterator i = tubToMachine.entrySet().iterator();
    while(i.hasNext()) {
      Map.Entry e = (Map.Entry) i.next();
      if(e.getValue().equals(m))
        set.add(e.getKey());
    }
    return set;
  }

  public void set(Tub t, Machine m) {
    tubToMachine.put(t, m);
  }
}
