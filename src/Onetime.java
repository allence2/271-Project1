package src;

import java.util.GregorianCalendar;

/**
 * Subclass for appointments that occur on the parameterized start date
 */
public class Onetime extends Appointment {
    public Onetime(String description, GregorianCalendar date) {
        super(description, date);
    }

    /**
     * Method to determine if the onetime appointment occurs on the parameterized
     * date
     */
    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar comparedDate = new GregorianCalendar(year, month, day);

        if (comparedDate.equals(this.date)) {
            return true;
        }
        return false;
    }
}
