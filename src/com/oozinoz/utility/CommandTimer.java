package com.oozinoz.utility;

import com.oozinoz.robotInterpreter.Command;

public class CommandTimer {
  public static long time(Command command) {
    long t1 = System.currentTimeMillis();
    command.execute();
    long t2 = System.currentTimeMillis();
    return t2 - t1;
  }
}
