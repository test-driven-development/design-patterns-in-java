package com.oozinoz.reservation;

import com.oozinoz.utility.Dollars;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ReservationParser {
  private ReservationBuilder builder;

  public ReservationParser(ReservationBuilder builder) {
    this.builder = builder;
  }

  public void parse(String s) throws ParseException {
    String[] tokens = s.split(",\\s*");
    for(int i = 0; i < tokens.length; i += 2) {
      String type = tokens[i];
      String val = tokens[i + 1];

      if("date".compareToIgnoreCase(type) == 0) {
        Calendar now = Calendar.getInstance();
        DateFormat formatter = DateFormat.getDateInstance();
        Date d = formatter.parse(val + ", " + now.get(Calendar.YEAR));
        builder.setDate(ReservationBuilder.futurize(d));
      } else if("headcount".compareToIgnoreCase(type) == 0)
        builder.setHeadcount(Integer.parseInt(val));
      else if("City".compareToIgnoreCase(type) == 0)
        builder.setCity(val.trim());
      else if("DollarsPerHead".compareToIgnoreCase(type) == 0)
        builder.setDollarsPerHead(new Dollars(Double.parseDouble(val)));
      else if("HasSite".compareToIgnoreCase(type) == 0)
        builder.setHasSite(val.equalsIgnoreCase("true"));
    }
  }
}
