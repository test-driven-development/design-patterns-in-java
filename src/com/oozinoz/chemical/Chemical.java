package com.oozinoz.chemical;

public class Chemical {
  private String name;

  private String symbol;

  private double atomicWeight;

  Chemical(String name, String symbol, double atomicWeight) {
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
