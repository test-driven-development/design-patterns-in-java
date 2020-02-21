package com.oozinoz.credit;

import com.oozinoz.utility.Dollars;

public class CreditCheckOffline implements CreditCheck {
  public Dollars creditLimit(int id) {
    // logic goes here to dialog with call center rep to
    // ascertain a reasonable credit limit
    return new Dollars(0);
  }
}
