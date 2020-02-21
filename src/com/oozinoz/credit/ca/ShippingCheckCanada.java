package com.oozinoz.credit.ca;

import com.oozinoz.credit.ShippingCheck;

public class ShippingCheckCanada implements ShippingCheck {
  public boolean hasTariff() {
    return true;
  }
}
