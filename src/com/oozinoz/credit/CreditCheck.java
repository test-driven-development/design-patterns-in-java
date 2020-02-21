package com.oozinoz.credit;

import com.oozinoz.utility.Dollars;

public interface CreditCheck {
  Dollars creditLimit(int id);
}
