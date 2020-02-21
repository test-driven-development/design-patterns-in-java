package com.oozinoz.chemical;

import java.util.HashMap;
import java.util.Map;

public class ChemicalFactory {
  private static Map chemicals = new HashMap();

  static {
    chemicals.put("carbon", new Chemical("Carbon", "C", 12));
    chemicals.put("sulfur", new Chemical("Sulfur", "S", 32));
    chemicals.put("saltpeter", new Chemical("Saltpeter", "KN03", 101));
    //...
  }

  public static Chemical getChemical(String name) {
    return (Chemical) chemicals.get(name.toLowerCase());
  }
}
