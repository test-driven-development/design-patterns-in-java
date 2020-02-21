package com.oozinoz.testing;

import com.oozinoz.chemical.ChemicalFactory;
import com.oozinoz.chemical2.ChemicalFactory2;
import junit.framework.TestCase;

public class ChemicalFactoryTest extends TestCase {
  public void testGetFactory() {
    assertEquals("Carbon(C)[12.0]", ChemicalFactory.getChemical("CARBON").toString());
  }

  public void testChemicalFactory2() {
    assertEquals("Carbon(C)[12.0]", ChemicalFactory2.getChemical("CARBON").toString());
  }
}
