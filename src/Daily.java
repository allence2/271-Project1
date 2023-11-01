package src;

import java.util.GregorianCalendar;

/**
 * Subclass for appointments that occur every day on and after a parameterized
 * start date
 */
public class Daily extends Appointment {
    public Daily(String description, GregorianCalendar startDate) {
        super(description, startDate);
    }

    /**
     * Method to determine if the Daily appointment occurs on the
     * parameterized date
     */
    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar compareDate = new GregorianCalendar(year, month, day);

        if (compareDate.equals(this.date) || compareDate.after(this.date)) {
            return true;
        }
        return false;
    }
}