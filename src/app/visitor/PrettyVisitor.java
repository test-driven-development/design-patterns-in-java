package app.visitor;

import com.oozinoz.process.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrettyVisitor implements ProcessVisitor {
  public static final String INDENT_STRING = "    ";

  private StringBuffer buf;
  private int depth;
  private Set visited;

  public StringBuffer getPretty(ProcessComponent pc) {
    buf = new StringBuffer();
    visited = new HashSet();
    depth = 0;
    pc.accept(this);
    return buf;
  }

  protected void printIndentedString(String s) {
    for(int i = 0; i < depth; i++) { buf.append(INDENT_STRING); }
    buf.append(s);
    buf.append("\n");
  }

  public void visit(ProcessStep s) {
    printIndentedString(s.getName());
  }

  public void visit(ProcessAlternation a) {
    visitComposite("?", a);
  }

  public void visit(ProcessSequence s) {
    visitComposite("", s);
  }

  protected void visitComposite(String prefix, ProcessComposite c) {
    if(visited.contains(c)) {
      printIndentedString(prefix + c.getName() + "...");
    } else {
      visited.add(c);
      printIndentedString(prefix + c.getName());
      depth++;

      List children = c.getChildren();

      for(int i = 0; i < children.size(); i++) {
        ProcessComponent child = (ProcessComponent) children.get(i);
        child.accept(this);
      }

      depth--;
    }
  }
}
