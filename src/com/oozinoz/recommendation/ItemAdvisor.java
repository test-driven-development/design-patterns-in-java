package com.oozinoz.recommendation;

import com.oozinoz.firework.Firework;

public class ItemAdvisor implements Advisor {
  public Firework recommend(Customer c) {
    return (Firework) LikeMyStuff.suggest(c);
  }
}
