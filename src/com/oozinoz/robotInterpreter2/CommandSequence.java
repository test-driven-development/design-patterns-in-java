package com.oozinoz.robotInterpreter2;

import java.util.ArrayList;
import java.util.List;

public class CommandSequence extends Command {
  protected List commands = new ArrayList();

  public void addCommand(Command c) {
    commands.add(c);
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    boolean needLine = false;

    for(int i = 0; i < commands.size(); i++) {
      Command c = (Command) commands.get(i);
      if(needLine)
        sb.append("\n");
      sb.append(c);
      needLine = true;
    }

    return sb.toString();
  }

  public void execute() {
    for(int i = 0; i < commands.size(); i++) {
      Command c = (Command) commands.get(i);
      c.execute();
    }
  }
}
