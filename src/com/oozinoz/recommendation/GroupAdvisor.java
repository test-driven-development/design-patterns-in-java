package com.oozinoz.recommendation;

import com.oozinoz.firework.Firework;

public class GroupAdvisor implements Advisor {
  public Firework recommend(Customer c) {
    return (Firework) Rel8.advise(c);
  }
}
