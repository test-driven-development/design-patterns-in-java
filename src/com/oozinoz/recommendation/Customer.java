package com.oozinoz.recommendation;

import com.oozinoz.firework.Firework;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Customer {
  public static final int BIG_SPENDER_DOLLARS = 1000;

  public static void main(String[] args) {
    Firework recommendation = new Customer().getRecommended();
    System.out.println("Customer recommendation: " + recommendation.toString());
  }

  public boolean isRegistered() {
    return false;
  }

  public Firework getRecommended() {
    // if we're promoting a particular firework, return it
    try {
      Properties p = new Properties();
      p.load(ClassLoader.getSystemResourceAsStream("config/strategy.dat"));
      String promotedName = p.getProperty("promote");

      if(promotedName != null) {
        Firework f = Firework.lookup(promotedName);
        if(f != null)
          return f;
      }
    }
    catch(Exception ignored) {
      // If resource missing or it failed to load,
      // fall through to the next approach.
    }

    // if registered, compare to other customers
    if(isRegistered()) {
      return (Firework) Rel8.advise(this);
    }

    // check spending over the last year
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.YEAR, -1);
    if(spendingSince(cal.getTime()) > 1000)
      return (Firework) LikeMyStuff.suggest(this);

    // oh well!
    return Firework.getRandom();
  }

  public double spendingSince(Date date) {
    return 1000;
  }

  private boolean isBigSpender() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.YEAR, -1);
    return (spendingSince(cal.getTime()) > BIG_SPENDER_DOLLARS);
  }
}
