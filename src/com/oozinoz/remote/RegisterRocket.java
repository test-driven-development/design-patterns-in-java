package com.oozinoz.remote;

import java.rmi.Naming;

public class RegisterRocket {
  public static void main(String[] args) {
    try {
      Rocket biggie = new RocketImpl(29.95, 820);
      Naming.rebind("rmi://localhost:5000/Biggie", biggie);
      System.out.println("Registered biggie");
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
