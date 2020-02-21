package com.oozinoz.utility;

import java.text.NumberFormat;

public class Format {
  private static NumberFormat numberFormatter = NumberFormat.getInstance();

  public static String formatToNPlaces(double d, int numberOfFractionDigits) {
    numberFormatter.setMinimumFractionDigits(numberOfFractionDigits);
    numberFormatter.setMaximumFractionDigits(numberOfFractionDigits);
    return numberFormatter.format(d);
  }
}
