package com.oozinoz.testing;

import com.oozinoz.process.ProcessComponent;
import com.oozinoz.process.ProcessSequence;
import com.oozinoz.process.ProcessStep;
import com.oozinoz.process.ShellProcess;
import junit.framework.TestCase;

public class ProcessTest extends TestCase {
  public static ProcessComponent abc() {
    ProcessSequence a = new ProcessSequence("a");
    ProcessSequence b = new ProcessSequence("b");
    ProcessStep c = new ProcessStep("c");
    a.add(c);
    a.add(b);
    b.add(c);
    return a;
  }

  public static ProcessComponent cycle() {
    ProcessSequence a = new ProcessSequence("a");
    ProcessSequence b = new ProcessSequence("b");
    ProcessSequence c = new ProcessSequence("c");
    a.add(b);
    b.add(c);
    c.add(a);
    return a;
  }

  public void testCountOfCycle() {
    assertEquals(0, cycle().getStepCount());
  }

  public void testStepCountForEmptyProcess() {
    ProcessSequence nil = new ProcessSequence("nil");
    assertEquals(0, nil.getStepCount());
  }

  public void testStepCountForOneStepProcess() {
    ProcessStep uno = new ProcessStep("uno");
    assertEquals(1, uno.getStepCount());
  }

  public void testShampooProcess_ShampooRinseRepeat() {
    ProcessStep shampoo = new ProcessStep("shampoo");
    ProcessStep rinse = new ProcessStep("rinse");
    ProcessSequence once = new ProcessSequence("once");
    once.add(shampoo);
    once.add(rinse);
    ProcessSequence instructions = new ProcessSequence("instructions");
    instructions.add(once);
    instructions.add(once);
    assertEquals(2, instructions.getStepCount());
  }

  public void testStepCountForAerialShellProcess() {
    assertEquals(4, ShellProcess.make().getStepCount());
  }

  public void testStepCountForNonTreeDirectedAcyclicGraph() {
    assertEquals(1, abc().getStepCount());
  }

  //
  //   abc
  //  / \
  // a   bc
  //     / \
  //    b   c
  //
  public void testSimpleTree() {
    ProcessStep a = new ProcessStep("a");
    ProcessStep b = new ProcessStep("b");
    ProcessStep c = new ProcessStep("c");
    ProcessSequence bc = new ProcessSequence("bc");
    bc.add(b);
    bc.add(c);
    ProcessSequence abc = new ProcessSequence("abc");
    abc.add(a);
    abc.add(bc);
    assertEquals(3, abc.getStepCount());
  }
}
