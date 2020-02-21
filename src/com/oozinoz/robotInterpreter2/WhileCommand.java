package com.oozinoz.robotInterpreter2;

public class WhileCommand extends Command {
  protected Term term;

  protected Command body;

  public WhileCommand(Term term, Command body) {
    this.term = term;
    this.body = body;
  }

  public void execute() {
    while(term.eval() != null)
      body.execute();
  }
}
