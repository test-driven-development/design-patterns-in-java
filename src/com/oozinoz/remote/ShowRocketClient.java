package com.oozinoz.remote;

import java.rmi.Naming;

public class ShowRocketClient {
  public static void main(String[] args) {
    try {
      Object obj = Naming.lookup("rmi://localhost:5000/Biggie");
      Rocket biggie = (Rocket) obj;
      System.out.println("Apogee is " + biggie.getApogee());
    }
    catch(Exception e) {
      System.out.println("Exception while looking up a rocket:");
      e.printStackTrace();
    }
  }
}
