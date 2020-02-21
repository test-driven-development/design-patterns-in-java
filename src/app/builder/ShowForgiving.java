package app.builder;

import com.oozinoz.reservation.ForgivingBuilder;
import com.oozinoz.reservation.Reservation;
import com.oozinoz.reservation.ReservationBuilder;
import com.oozinoz.reservation.ReservationParser;

public class ShowForgiving {
  public static void main(String[] args) {
    String sample = "Date, November 5, Headcount, 250, "
      + "City, Springfield, DollarsPerHead, 9.95, HasSite, False";
    ReservationBuilder builder = new ForgivingBuilder();
    try {
      new ReservationParser(builder).parse(sample);
      Reservation res = builder.build();
      System.out.println("Forgiving builder: " + res);
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
