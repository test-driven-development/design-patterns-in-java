package com.oozinoz.testing;

import com.oozinoz.reservation.*;
import com.oozinoz.utility.Dollars;
import junit.framework.TestCase;

import java.text.ParseException;
import java.util.Date;

public class ForgivingBuilderTest extends TestCase {
  Date nextNov5;

  public void setUp() {
    // Pick a date definitely in the past: 11-5-2000
    nextNov5 = ReservationBuilder.futurize(new Date(2000 - 1900, 11 - 1, 5));
  }

  public void testLowDollars() throws ParseException {
    String s = "Date, November 5, Headcount, 250, "
      + "City, Springfield, DollarsPerHead, 1.95, "
      + "HasSite, false";
    ReservationBuilder b = new ForgivingBuilder();
    new ReservationParser(b).parse(s);

    try {
      Reservation r = b.build();// should throw an exception
      fail("Should throw a BuilderException");
    }
    catch(BuilderException expected) {
    }
  }

  public void testLowHeadCount() throws ParseException {
    String s = "Date, November 5, Headcount, 2, "
      + "City, Springfield, DollarsPerHead, 9.95, "
      + "HasSite, false";
    ReservationBuilder b = new ForgivingBuilder();
    new ReservationParser(b).parse(s);

    try {
      Reservation r = b.build();// should throw an exception
      fail("Should throw a BuilderException");
    }
    catch(BuilderException expected) {
    }
  }

  public void testNoCity() throws ParseException {
    String s = "Date, November 5, Headcount, 250, "
      + "DollarsPerHead, 9.95, " + "HasSite, false";
    ReservationBuilder b = new ForgivingBuilder();
    new ReservationParser(b).parse(s);

    try {
      Reservation r = b.build();// should throw an exception
      fail("Should throw a BuilderException");
    }
    catch(BuilderException expected) {
    }
  }

  public void testNoDate() throws ParseException {
    String s = "Headcount, 250, "
      + "City, Springfield, DollarsPerHead, 9.95, "
      + "HasSite, false";
    ReservationBuilder b = new ForgivingBuilder();
    new ReservationParser(b).parse(s);
    try {
      Reservation r = b.build();// should throw an exception
      fail("Should throw a BuilderException");
    }
    catch(BuilderException expected) {
    }
  }

  public void testNoDollar() throws BuilderException, ParseException {
    String s = "Date, November 5, Headcount, 250, City, Springfield, "
      + "  HasSite, false";
    ForgivingBuilder b = new ForgivingBuilder();
    ReservationParser p = new ReservationParser(b);
    p.parse(s);
    Reservation r = b.build();

    assertEquals(nextNov5, r.getDate());
    assertEquals(250, r.getHeadcount());

    Dollars price = r.getDollarsPerHead().times(r.getHeadcount());
    assertFalse(price.isLessThan(ReservationBuilder.MINTOTAL));

    assertEquals("Springfield", r.getCity());
    assertFalse(r.hasSite());
  }

  public void testNoHeadcount() throws BuilderException, ParseException {
    String s = "Date, November 5,   City, Springfield, "
      + "DollarsPerHead, 9.95, HasSite, false";
    ForgivingBuilder b = new ForgivingBuilder();
    ReservationParser p = new ReservationParser(b);
    p.parse(s);
    Reservation r = b.build();

    assertEquals(nextNov5, r.getDate());
    assertTrue(r.getHeadcount() >= ReservationBuilder.MINHEAD);

    Dollars price = r.getDollarsPerHead().times(r.getHeadcount());
    assertFalse(price.isLessThan(ReservationBuilder.MINTOTAL));

    assertEquals("Springfield", r.getCity());
    assertEquals(new Dollars(9.95), r.getDollarsPerHead());
    assertFalse(r.hasSite());
  }

  public void testNoHeadcountNoDollar() throws BuilderException, ParseException {
    String s = "Date, November 5,   City, Springfield, "
      + "  HasSite, false";
    ForgivingBuilder b = new ForgivingBuilder();
    ReservationParser p = new ReservationParser(b);
    p.parse(s);
    Reservation r = b.build();

    assertEquals(nextNov5, r.getDate());
    assertEquals(ReservationBuilder.MINHEAD, r.getHeadcount());
    assertEquals("Springfield", r.getCity());

    assertEquals(
      ReservationBuilder.MINTOTAL.dividedBy(r.getHeadcount()),
      r.getDollarsPerHead());
    assertFalse(r.hasSite());
  }

  public void testNormal() throws BuilderException, ParseException {
    String s = "Date, November 5, Headcount, 250, City, Springfield, "
      + "DollarsPerHead, 9.95, HasSite, false";
    ForgivingBuilder b = new ForgivingBuilder();
    ReservationParser p = new ReservationParser(b);
    p.parse(s);
    Reservation r = b.build();

    assertEquals(nextNov5, r.getDate());
    assertEquals(250, r.getHeadcount());
    assertEquals("Springfield", r.getCity());
    assertEquals(new Dollars(9.95), r.getDollarsPerHead());
    assertFalse(r.hasSite());
  }
}
