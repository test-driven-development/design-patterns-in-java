package com.oozinoz.testing;

import com.oozinoz.machine.Fuser;
import com.oozinoz.machine.Machine;
import com.oozinoz.machine.Tub;
import com.oozinoz.machine.TubMediator;
import junit.framework.TestCase;

public class TubTest extends TestCase {
  public void testAddTub() {
    TubMediator mediator = new TubMediator();
    Tub tub = new Tub("T402", mediator);
    Machine m1 = new Fuser(1, mediator);
    Machine m2 = new Fuser(2, mediator);

    // place the tub on m1
    tub.setLocation(m1);
    assertEquals(1, m1.getTubs().size());

    // move the tub by adding it to m2
    m2.addTub(tub);
    assertEquals(m2, tub.getLocation());
    assertEquals(0, m1.getTubs().size());
    assertEquals(1, m2.getTubs().size());
  }

  public void testLocationChange() {
    TubMediator mediator = new TubMediator();
    Tub t = new Tub("T403", mediator);
    Machine m1 = new Fuser(1001, mediator);
    Machine m2 = new Fuser(1002, mediator);

    t.setLocation(m1);
    assertTrue(m1.getTubs().contains(t));
    assertTrue(!m2.getTubs().contains(t));

    t.setLocation(m2);
    assertFalse(m1.getTubs().contains(t));
    assertTrue(m2.getTubs().contains(t));
  }
}
