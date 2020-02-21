package aster2;

public class AsterStarPress {
  public Hook moldIncompleteHook;

  protected int currentMoldID;

  public AsterStarPress() {
    moldIncompleteHook = new NullHook();
  }

  public void setMoldIncompleteHook(Hook hook) {
    moldIncompleteHook = hook;
  }

  public int getCurrentMoldID() {
    return currentMoldID;
  }

  public void dischargePaste() {
  }

  public void flush() {
  }

  public boolean inProcess() {
    return false;
  }

  public void shutDown() {
    if(inProcess()) {
      stopProcessing();
      moldIncompleteHook.execute(this);
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
