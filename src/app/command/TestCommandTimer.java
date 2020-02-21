package app.command;

import com.oozinoz.robotInterpreter.Command;
import com.oozinoz.utility.CommandTimer;
import junit.framework.TestCase;

public class TestCommandTimer extends TestCase {
  public void testSleep() {
    Command doze = new Command() {
      public void execute() {
        try {
          Thread.sleep(2000 + Math.round(10 * Math.random()));
        }
        catch(InterruptedException ignored) {
        }
      }
    };

    long actual = CommandTimer.time(doze);

    long expected = 2000;
    long delta = 20;
    System.out.println(actual);
    assertTrue("Should be " + expected + " +/- " + delta + " ms",
      expected - delta <= actual
        && actual <= expected + delta);
  }
}
