package com.oozinoz.ozAster;

import aster.AsterStarPress;
import com.oozinoz.businessCore.Factory;
import com.oozinoz.businessCore.MaterialManager;

public class OzAsterStarPress extends AsterStarPress {
  public void dischargePaste() {
    super.dischargePaste();
    getFactory().collectPaste();
  }

  public MaterialManager getManager() {
    return MaterialManager.getManager();
  }

  public void markMoldIncomplete(int id) {
    getManager().setMoldIncomplete(id);
  }

  public Factory getFactory() {
    return null;
  }
}
