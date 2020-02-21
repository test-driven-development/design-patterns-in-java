package com.oozinoz.businessCore;

import java.util.ArrayList;

public class Factory {
  private static Factory factory;

  private static Object classLock = Factory.class;

  private long wipMoves;

  private Factory() {
    wipMoves = 0;
  }

  public static Factory getFactory() {
    synchronized(classLock) {
      if(factory == null)
        factory = new Factory();

      return factory;
    }
  }

  public static ArrayList upMachineNames() {
    ArrayList result = new ArrayList();
    result.add("Mixer:1201");
    result.add("ShellAssembler:1301");
    result.add("StarPress:1401");
    result.add("UnloadBuffer:1501");
    return result;
  }

  public void recordWipMove() {
    synchronized(classLock) {
      wipMoves++;
    }
  }

  // for the Aster star press example; not implemented
  public void collectPaste() {
  }
}
