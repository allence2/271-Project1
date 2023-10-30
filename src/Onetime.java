package src;

import java.util.GregorianCalendar;

public class Onetime extends Appointment {
    public Onetime(String description, GregorianCalendar date) {
        super(description, date, false);
    }

    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar comparedDate = new GregorianCalendar(year, month, day);

        if (comparedDate.equals(date)) {
            return true;
        }
        return false;
    }
}
