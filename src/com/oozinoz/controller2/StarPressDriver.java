package com.oozinoz.controller2;

import com.oozinoz.controller.StarPressController;

public class StarPressDriver implements MachineDriver {
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
