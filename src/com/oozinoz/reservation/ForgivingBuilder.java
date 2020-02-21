package com.oozinoz.reservation;

import com.oozinoz.utility.Dollars;

public class ForgivingBuilder extends ReservationBuilder {
  public Reservation build() throws BuilderException {
    boolean noHeadcount = (headcount == 0);
    boolean noDollarsPerHead = (dollarsPerHead.isZero());

    if(noHeadcount && noDollarsPerHead) {
      headcount = MINHEAD;
      dollarsPerHead = sufficientDollars(headcount);
    } else if(noHeadcount) {
      headcount = (int) Math.ceil(MINTOTAL.dividedBy(dollarsPerHead));
      headcount = Math.max(headcount, MINHEAD);
    } else if(noDollarsPerHead) {
      dollarsPerHead = sufficientDollars(headcount);
    }

    check();

    return new Reservation(date, headcount, city, dollarsPerHead, hasSite);
  }

  private Dollars sufficientDollars(int headcount) {
    Dollars dollars = MINTOTAL.dividedBy(headcount);
    if(dollars.times(headcount).isLessThan(MINTOTAL))
      dollars = dollars.plus(Dollars.cent);
    return dollars;
  }

  protected void check() throws BuilderException {
    if(date == null)
      throw new BuilderException("Valid date not found");

    if(city == null)
      throw new BuilderException("Valid city not found");

    if(headcount < MINHEAD)
      throw new BuilderException("Minimum headcount is " + MINHEAD);

    if(dollarsPerHead.times(headcount).isLessThan(MINTOTAL))
      throw new BuilderException("Minimum total cost is " + MINTOTAL);
  }
}
