package com.oozinoz.controller;

public class StarPressManager extends MachineManager {
  private StarPressController controller = new StarPressController();

  public void startMachine() {
    controller.start();
  }

  public void stopMachine() {
    controller.stop();
  }

  public void startProcess() {
    controller.startProcess();
  }

  public void stopProcess() {
    controller.endProcess();
  }

  public void conveyIn() {
    controller.index();
  }

  public void conveyOut() {
    controller.discharge();
  }
}
