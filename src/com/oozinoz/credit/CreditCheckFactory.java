package com.oozinoz.credit;

public abstract class CreditCheckFactory {
  public static CreditCheck createCreditCheck() {
    if(isAgencyUp())
      return new CreditCheckOnline();

    return new CreditCheckOffline();
  }

  public static boolean isAgencyUp() {
    return true;
  }

  public abstract BillingCheck createBillingCheck();

  public abstract CreditCheck createCreditCheck2();

  public abstract ShippingCheck createShippingCheck();
}
