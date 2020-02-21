package com.oozinoz.recommendation;

import com.oozinoz.firework.Firework;

public class RandomAdvisor implements Advisor {
  public Firework recommend(Customer c) {
    return Firework.getRandom();
  }
}
