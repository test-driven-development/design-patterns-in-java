package com.oozinoz.reservation;

public class UnforgivingBuilder extends ReservationBuilder {
  public Reservation build() throws BuilderException {
    if(date == null)
      throw new BuilderException("Valid date not found");

    if(city == null)
      throw new BuilderException("Valid city not found");

    if(headcount < MINHEAD)
      throw new BuilderException("Minimum headcount is " + MINHEAD);

    if(dollarsPerHead.times(headcount).isLessThan(MINTOTAL))
      throw new BuilderException("Minimum total cost is " + MINTOTAL);

    return new Reservation(date, headcount, city, dollarsPerHead, hasSite);
  }
}
