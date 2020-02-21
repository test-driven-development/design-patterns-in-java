package com.oozinoz.recommendation;

import com.oozinoz.firework.Firework;

public interface Advisor {
  Firework recommend(Customer c);
}
