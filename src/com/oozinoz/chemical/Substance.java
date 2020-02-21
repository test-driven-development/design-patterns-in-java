package com.oozinoz.chemical;

public class Substance {
  private String name;

  private String symbol;

  private double atomicWeight;

  private double grams;

  public Substance(String name, String symbol, double atomicWeight,
    double grams) {
    this.name = name;
    this.symbol = symbol;
    this.atomicWeight = atomicWeight;
    this.grams = grams;
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

  public double getGrams() {
    return grams;
  }

  public double getMoles() {
    return grams / atomicWeight;
  }
}
