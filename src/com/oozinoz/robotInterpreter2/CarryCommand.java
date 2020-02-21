package com.oozinoz.robotInterpreter2;

public class CarryCommand extends Command {
  protected Term from;
  protected Term to;

  public CarryCommand(Term fromTerm, Term toTerm) {
    from = fromTerm;
    to = toTerm;
  }

  public void execute() {
    Robot.singleton.carry(from.eval(), to.eval());
  }
}
