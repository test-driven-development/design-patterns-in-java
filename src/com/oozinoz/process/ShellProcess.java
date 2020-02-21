package com.oozinoz.process;

public class ShellProcess {
  protected static ProcessSequence make;

  public static ProcessSequence make() {
    if(make == null) {
      make = new ProcessSequence("Make an aerial shell");
      make.add(buildInnerShell());
      make.add(inspect());
      make.add(reworkOrFinish());
    }
    return make;
  }

  protected static ProcessStep buildInnerShell() {
    return new ProcessStep("Build inner shell");
  }

  protected static ProcessStep inspect() {
    return new ProcessStep("Inspect");
  }

  protected static ProcessAlternation reworkOrFinish() {
    return new ProcessAlternation("Rework inner shell, or complete shell",
      new ProcessComponent[] {rework(), finish()});
  }

  protected static ProcessSequence rework() {
    return new ProcessSequence("Rework", new ProcessComponent[] {
      disassemble(), make()});
  }

  protected static ProcessStep disassemble() {
    return new ProcessStep("Disassemble");
  }

  protected static ProcessStep finish() {
    return new ProcessStep("Finish: Attach lift, insert fusing, wrap");
  }
}
