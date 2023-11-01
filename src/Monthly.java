package src;

import java.util.GregorianCalendar;

/**
 * Subclass for appointments that occur every month on the same day on and after
 * a parameterized start date
 */
public class Monthly extends Appointment {
    public Monthly(String description, GregorianCalendar date) {
        super(description, date);
    }

    /**
     * Method to determine if the Monthly appointment occurs on the
     * parameterized
     * date
     */
    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar compareDate = new GregorianCalendar(year, month, day);

        if (compareDate.equals(this.date) || compareDate.after(this.date) && day == this.date.get(this.date.DATE)) {
            return true;
        }
        return false;
    }
}