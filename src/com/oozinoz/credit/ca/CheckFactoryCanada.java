package com.oozinoz.credit.ca;

import com.oozinoz.credit.*;

public class CheckFactoryCanada extends CreditCheckFactory {
  public BillingCheck createBillingCheck() {
    return new BillingCheckCanada();
  }

  public CreditCheck createCreditCheck2() {
    if(isAgencyUp())
      return new CreditCheckCanadaOnline();
    return new CreditCheckOffline();
  }

  public ShippingCheck createShippingCheck() {
    return new ShippingCheckCanada();
  }
}
