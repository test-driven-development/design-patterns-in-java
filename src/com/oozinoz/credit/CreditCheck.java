package com.oozinoz.credit;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 *
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose,
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import com.oozinoz.utility.Dollars;

/**
 This interface defines the common behaviors for online and offline credit
 check classes.
 */
public interface CreditCheck {
  /**
   @param id the customer ID

   @return the acceptable credit limit for the person with the supplied
   identification number.
   */
  Dollars creditLimit(int id);
}
