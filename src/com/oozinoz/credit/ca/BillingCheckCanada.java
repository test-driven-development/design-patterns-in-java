package com.oozinoz.credit.ca;

import com.oozinoz.credit.BillingCheck;

public class BillingCheckCanada implements BillingCheck {
  public boolean isResidential() {
    return true;
  }
}
