package app.templateMethod;

import aster2.AsterStarPress;
import aster2.Hook;
import com.oozinoz.businessCore.MaterialManager;

public class ShowHook {
  public static void main(String[] args) {
    AsterStarPress p = new AsterStarPress();
    Hook h = new Hook() {
      public void execute(AsterStarPress p) {
        MaterialManager m = MaterialManager.getManager();
        m.setMoldIncomplete(p.getCurrentMoldID());
      }
    };

    p.setMoldIncompleteHook(h);
  }
}
