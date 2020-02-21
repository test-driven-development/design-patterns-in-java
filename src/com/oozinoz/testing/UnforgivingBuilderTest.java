package com.oozinoz.testing;

import com.oozinoz.reservation.*;
import com.oozinoz.utility.Dollars;
import junit.framework.TestCase;

import java.text.ParseException;
import java.util.Date;

public class UnforgivingBuilderTest extends TestCase {
  Date nextNov5;

  public void setUp() {
    // Pick a date definitely in the past: 11-5-2000
    nextNov5 = ReservationBuilder.futurize(new Date(2000 - 1900, 11 - 1, 5));
  }

  public void testDisallowLowDollarsPerHead() throws ParseException {
    String sample = "Date, November 5, Headcount, 250, "
      + "City, Springfield, DollarsPerHead, 1.95, "
      + "HasSite, false";
    ReservationBuilder b = new UnforgivingBuilder();
    new ReservationParser(b).parse(sample);

    try {
      Reservation r = b.build();
      fail("Expected BuilderException: built " + r);
    }
    catch(BuilderException expected) {
    }
  }

  public void testDisallowLowHeadCount() throws ParseException {
    String s = "Date, November 5, Headcount, 2, "
      + "City, Springfield, DollarsPerHead, 9.95, "
      + "HasSite, false";
    ReservationBuilder b = new UnforgivingBuilder();
    new ReservationParser(b).parse(s);
    try {
      Reservation r = b.build();
      fail("Expected BuilderException: built " + r);
    }
    catch(BuilderException expected) {
    }
  }

  public void testDisallowNoDollars() throws ParseException {
    String sample = "Date, November 5, Headcount, 250, "
      + "City, Springfield, " + "HasSite, false";
    ReservationBuilder b = new UnforgivingBuilder();
    new ReservationParser(b).parse(sample);
    try {
      Reservation r = b.build();
      fail("Expected BuilderException: built " + r);
    }
    catch(BuilderException expected) {
    }
  }

  public void testDisallowNoHeadCount() throws ParseException {
    String s = "Date, November 5, "
      + "City, Springfield, DollarsPerHead, 9.95, "
      + "HasSite, false";
    ReservationBuilder b = new UnforgivingBuilder();
    new ReservationParser(b).parse(s);
    try {
      Reservation r = b.build();
      fail("Expected BuilderException: built " + r);
    }
    catch(BuilderException expected) {
    }
  }

  public void testNormalReservation() throws BuilderException, ParseException {
    String s = "Date, November 5, Headcount, 250, City, Springfield, "
      + "DollarsPerHead, 9.95, HasSite, false";
    UnforgivingBuilder b = new UnforgivingBuilder();
    ReservationParser p = new ReservationParser(b);
    p.parse(s);
    Reservation r = b.build();

    assertEquals(nextNov5, r.getDate());
    assertEquals(250, r.getHeadcount());
    assertEquals("Springfield", r.getCity());
    assertEquals(new Dollars(9.95), r.getDollarsPerHead());
    assertFalse(r.hasSite());
  }

  public void testDisallowMissingCity() throws ParseException {
    String s = "Date, November 5, Headcount, 250, "
      + "DollarsPerHead, 9.95, " + "HasSite, false";
    ReservationBuilder b = new UnforgivingBuilder();
    new ReservationParser(b).parse(s);
    try {
      Reservation r = b.build();
      fail("BuilderException expected: built " + r);
    }
    catch(BuilderException expected) {
    }
  }

  public void testDisallowMissingDate() throws ParseException {
    String s = "Headcount, 250, "
      + "City, Springfield, DollarsPerHead, 9.95, "
      + "HasSite, false";
    ReservationBuilder b = new UnforgivingBuilder();
    new ReservationParser(b).parse(s);
    try {
      Reservation r = b.build();
      fail("BuilderException expected: built " + r);
    }
    catch(BuilderException expected) {
    }
  }
}
