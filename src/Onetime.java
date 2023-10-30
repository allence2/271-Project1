package src;

import java.util.GregorianCalendar;

public class Onetime extends Appointment {
    public Onetime(String description, GregorianCalendar date) {
        super(description, date, false);
    }

    public boolean occursOn(int year, int month, int day) {
        return false;
    }
}
