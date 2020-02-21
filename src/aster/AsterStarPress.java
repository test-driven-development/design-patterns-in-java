package aster;

public abstract class AsterStarPress {
  protected int currentMoldID;

  public void dischargePaste() {
  }

  public void flush() {
  }

  public boolean inProcess() {
    return false;
  }

  public abstract void markMoldIncomplete(int id);

  public void shutdown() {
    if(inProcess()) {
      stopProcessing();
      markMoldIncomplete(currentMoldID);
    }
    usherInputMolds();
    dischargePaste();
    flush();
  }

  public void stopProcessing() {
  }

  public void usherInputMolds() {
  }
}
