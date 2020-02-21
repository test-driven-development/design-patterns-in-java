package com.oozinoz.robotInterpreter2;

public class IfCommand extends Command {
  protected Term term;
  protected Command body;
  protected Command elseBody;

  public IfCommand(Term term, Command body, Command elseBody) {
    this.term = term;
    this.body = body;
    this.elseBody = elseBody;
  }

  public void execute() {
    if(term.eval() != null)
      body.execute();
    else
      elseBody.execute();
  }
}
