package com.oozinoz.machine;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.iterator.LeafIterator;
import com.oozinoz.planning.BasicPlanner;
import com.oozinoz.planning.MachinePlanner;
import com.oozinoz.utility.Queue;

import java.util.Set;

public abstract class Machine extends MachineComponent {

  protected Queue bins = new Queue();

  protected MachinePlanner planner;

  protected boolean isUp = true;

  protected TubMediator mediator;

  protected Machine(int id, TubMediator mediator) {
    this(id, mediator, null);
  }

  public Machine(int id, TubMediator mediator, MachineComponent parent) {
    this(id, mediator, parent, null);
  }

  public Machine(int id, TubMediator mediator, MachineComponent parent, Engineer responsible) {
    super(id, parent, responsible);
    this.mediator = mediator;
    initialize();
  }


  public Machine(int id) {
    super(id);
  }

  public Machine(int id, MachineComponent parent) {
    super(id, parent);
    this.mediator = null; //TBD
    initialize();
  }

  public void initialize() {
    bins = new Queue();
  }

  public void load(Bin b) {
    bins.enqueue(b);
    System.out.println(toString() + " loading");
  }

  public MachinePlanner createPlanner() {
    return new BasicPlanner(this);
  }

  public int getMachineCount() {
    return 1;
  }

  public boolean hasMaterial() {
    return !bins.isEmpty();
  }

  public void shutdown() {
    System.out.println(toString() + " shutting down");
  }

  public void startup() {
    System.out.println(toString() + " starting up");
  }

  public Bin unload() {
    if(bins.isEmpty()) {
      System.out.println(toString() + " already empty");
      return null;
    }
    Bin b = (Bin) bins.dequeue();
    System.out.println(toString() + " unloading");
    return b;
  }

  public void accept(MachineVisitor v) {
    v.visit(this);
  }

  public void addTub(Tub t) {
    mediator.set(t, this);
  }

  public MachinePlanner getPlanner() {
    if(planner == null)
      planner = createPlanner();
    return planner;
  }

  public Set getTubs() {
    return mediator.getTubs(this);
  }

  protected boolean isTree(Set visited) {
    visited.add(this);
    return true;
  }

  public boolean isUp() {
    return isUp;
  }

  public ComponentIterator iterator(Set visited) {
    return new LeafIterator(this, visited);
  }

  public void setIsUp(boolean isUp) {
    this.isUp = isUp;
  }
}
