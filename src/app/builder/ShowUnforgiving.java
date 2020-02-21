package app.builder;

import com.oozinoz.reservation.Reservation;
import com.oozinoz.reservation.ReservationBuilder;
import com.oozinoz.reservation.ReservationParser;
import com.oozinoz.reservation.UnforgivingBuilder;

public class ShowUnforgiving {
  public static void main(String[] args) {
    String sample = "Date, November 5, Headcount, 250, "
      + "City, Springfield, DollarsPerHead, 9.95, HasSite, False";
    ReservationBuilder builder = new UnforgivingBuilder();
    try {
      new ReservationParser(builder).parse(sample);
      Reservation res = builder.build();
      System.out.println("Unforgiving builder: " + res);
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
