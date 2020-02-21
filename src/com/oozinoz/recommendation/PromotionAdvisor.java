package com.oozinoz.recommendation;

import com.oozinoz.firework.Firework;

import java.util.Properties;

public class PromotionAdvisor implements Advisor {
  private Firework promoted;

  public PromotionAdvisor() {
    try {
      Properties p = new Properties();
      p.load(ClassLoader.getSystemResourceAsStream("config/strategy.dat"));
      String promotedFireworkName = p.getProperty("promote");
      if(promotedFireworkName != null)
        promoted = Firework.lookup(promotedFireworkName);
    }
    catch(Exception ignored) {
      // Resource not found or failed to load
      promoted = null;
    }
  }

  public boolean hasItem() {
    return promoted != null;
  }

  public Firework recommend(Customer c) {
    return promoted;
  }
}
