package com.oozinoz.chemical2;

import java.util.HashMap;
import java.util.Map;

public class ChemicalFactory2 {
  private static Map chemicals = new HashMap();

  static {
    ChemicalFactory2 factory = new ChemicalFactory2();
    chemicals.put("carbon", factory.new ChemicalImpl("Carbon", "C", 12));
    chemicals.put("sulfur", factory.new ChemicalImpl("Sulfur", "S", 32));
    chemicals.put("saltpeter", factory.new ChemicalImpl("Saltpeter", "KN03", 101));
    //...
  }

  public static Chemical getChemical(String name) {
    return (Chemical) chemicals.get(name.toLowerCase());
  }

  class ChemicalImpl implements Chemical {
    private String name;
    private String symbol;
    private double atomicWeight;

    ChemicalImpl(String name, String symbol, double atomicWeight) {
      this.name = name;
      this.symbol = symbol;
      this.atomicWeight = atomicWeight;
    }

    public String getName() {
      return name;
    }

    public String getSymbol() {
      return symbol;
    }

    public double getAtomicWeight() {
      return atomicWeight;
    }

    public String toString() {
      return name + "(" + symbol + ")[" + atomicWeight + "]";
    }
  }
}
