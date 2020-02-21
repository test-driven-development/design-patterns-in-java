package com.oozinoz.reservation;

import com.oozinoz.utility.Dollars;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
  private Date date;

  private int headcount;

  private String city;

  private Dollars dollarsPerHead;

  private boolean hasSite;

  Reservation(Date date, int headcount, String city, Dollars dollarsPerHead, boolean hasSite) {
    this.date = date;
    this.headcount = headcount;
    this.city = city;
    this.dollarsPerHead = dollarsPerHead;
    this.hasSite = hasSite;
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("Date: ");
    sb.append(date.toString());
    sb.append(", Headcount: ");
    sb.append(headcount);
    sb.append(", City: ");
    sb.append(city);
    sb.append(", Dollars/Head: ");
    sb.append(dollarsPerHead);
    sb.append(", Has Site: ");
    sb.append(hasSite);
    return sb.toString();
  }

  public Date getDate() {
    return date;
  }

  public int getHeadcount() {
    return headcount;
  }

  public String getCity() {
    return city;
  }

  public Dollars getDollarsPerHead() {
    return dollarsPerHead;
  }

  public boolean hasSite() {
    return hasSite;
  }
}
