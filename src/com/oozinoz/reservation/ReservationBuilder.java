package com.oozinoz.reservation;

import com.oozinoz.utility.Dollars;

import java.util.Calendar;
import java.util.Date;

public abstract class ReservationBuilder {
  public static final int MINHEAD = 25;

  public static final Dollars MINTOTAL = new Dollars(495.95);

  protected Date date = null;

  protected String city;

  protected int headcount;

  protected Dollars dollarsPerHead = new Dollars(0);

  protected boolean hasSite;

  public static Date futurize(Date inDate) {
    Calendar now = Calendar.getInstance();
    Calendar then = Calendar.getInstance();
    then.setTime(inDate);

    while(then.before(now))
      then.add(Calendar.YEAR, 1);

    return then.getTime();
  }

  public abstract Reservation build() throws BuilderException;

  public String getCity() {
    return city;
  }

  public void setCity(String value) {
    city = value;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date value) {
    date = value;
  }

  public Dollars getDollarsPerHead() {
    return dollarsPerHead;
  }

  public void setDollarsPerHead(Dollars value) {
    dollarsPerHead = value;
  }

  public boolean hasSite() {
    return hasSite;
  }

  public void setHasSite(boolean value) {
    hasSite = value;
  }

  public int getHeadcount() {
    return headcount;
  }

  public void setHeadcount(int value) {
    headcount = value;
  }
}
