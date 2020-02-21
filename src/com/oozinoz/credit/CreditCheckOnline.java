package com.oozinoz.credit;

import com.oozinoz.utility.Dollars;

public class CreditCheckOnline implements CreditCheck {
  public Dollars creditLimit(int id) {
    // logic goes here to contact a credit agency
    return new Dollars(0);
  }
}
