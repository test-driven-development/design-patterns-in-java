package com.oozinoz.controller2;

public class MachineManager2 {
  protected MachineDriver driver;

  public MachineManager2(MachineDriver driver) {
    this.driver = driver;
  }

  public void shutdown() {
    driver.stopProcess();
    driver.conveyOut();
    driver.stopMachine();
  }
}
