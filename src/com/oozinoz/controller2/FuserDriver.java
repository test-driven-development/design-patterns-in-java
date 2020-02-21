package com.oozinoz.controller2;

import com.oozinoz.controller.FuserController;

public class FuserDriver implements MachineDriver {
  private FuserController controller = new FuserController();

  public void startMachine() {
    controller.startMachine();
  }

  public void stopMachine() {
    controller.stopMachine();
  }

  public void startProcess() {
    controller.begin();
  }

  public void stopProcess() {
    controller.end();
  }

  public void conveyIn() {
    controller.conveyIn();
  }

  public void conveyOut() {
    controller.conveyOut();
  }

  public void switchSpool() {
    controller.switchSpool();
  }
}
