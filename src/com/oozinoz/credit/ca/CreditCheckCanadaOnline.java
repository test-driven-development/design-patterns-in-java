package com.oozinoz.credit.ca;

import com.oozinoz.credit.CreditCheck;
import com.oozinoz.utility.Dollars;

public class CreditCheckCanadaOnline implements CreditCheck {
  public Dollars creditLimit(int id) {
    // logic goes here to contact a Canadian credit agency
    return new Dollars(0);
  }
}
