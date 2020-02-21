package com.oozinoz.testing;

import com.oozinoz.machine.*;
import junit.framework.TestCase;

public class MachineTest extends TestCase {
  public static MachineComposite tree() {
    Machine m1 = new Fuser(1);
    Machine m2 = new Fuser(2);
    Machine m3 = new Fuser(3);
    MachineComposite m23 = new MachineComposite(23);
    m23.add(m2);
    m23.add(m3);
    MachineComposite m123 = new MachineComposite(123);
    m123.add(m1);
    m123.add(m23);
    return m123;
  }

  public static MachineComponent cycle() {
    MachineComposite m1 = new MachineComposite(1);
    MachineComposite m2 = new MachineComposite(2);
    MachineComposite m3 = new MachineComposite(3);
    m1.add(m2);
    m2.add(m3);
    m3.add(m1);
    return m1;
  }

  public static MachineComponent nonTree() {
    MachineComposite m1 = new MachineComposite(1);
    MachineComposite m3 = new MachineComposite(3);
    Machine m2 = new Fuser(2);
    m1.add(m2);
    m1.add(m3);
    m3.add(m2);
    return m1;
  }

  public void testCanCountLeaves() {
    assertEquals(3, tree().getMachineCount());
  }

  public void testThatCycleIsNotATree() {
    assertFalse(cycle().isTree());
    assertFalse(nonTree().isTree());
    assertTrue(tree().isTree());
    assertFalse(OozinozFactory.plant().isTree());
  }

  public void testThatAMachineIsATree() {
    assertTrue(new Fuser(1).isTree());
  }
}
