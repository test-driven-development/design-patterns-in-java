package com.oozinoz.chemical2;

public class Substance2 {
  private double grams;

  private Chemical chemical;

  public Substance2(double grams, Chemical chemical) {
    this.grams = grams;
    this.chemical = chemical;
  }

  public String getName() {
    return chemical.getName();
  }

  public String getSymbol() {
    return chemical.getSymbol();
  }

  public double getAtomicWeight() {
    return chemical.getAtomicWeight();
  }

  public double getGrams() {
    return grams;
  }

  public double getMoles() {
    return grams / getAtomicWeight();
  }
}
