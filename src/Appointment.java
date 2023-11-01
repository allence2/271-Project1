package src;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Superclass for the object appointment, subclasses: Onetime, Daily, Monthly
 */
public abstract class Appointment {

    /**
     * Instance Variables
     */
    GregorianCalendar date = new GregorianCalendar();
    private String AptDescription;

    /**
     * Super constructor that sets the date, description variables
     * 
     * @param month   - month of the year
     * @param day     - day of the month
     * @param year    - year of the date
     * @param monthly - if the appointment is monthly
     */
    public Appointment(String description, GregorianCalendar date) {
        this.date = date;
        this.AptDescription = description;
    }

    /**
     * Abstract method for checking if the date occurs on, each appointment subtype
     * will have it's own implementation of this method
     * 
     * @param year
     * @param month
     * @param day
     * @return
     */
    public abstract boolean occursOn(int year, int month, int day);

    /**
     * Override the toString() Method to properly format the type of appointment,
     * date, and description
     */
    @Override
    public String toString() {
        String dateFormattedString = date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH) + "-"
                + date.get(Calendar.YEAR);
        String appType = null;
        if (this instanceof Onetime) {
            appType = "Onetime Appointment   ";
        } else if (this instanceof Monthly) {
            appType = "Monthly Appointment   ";
        } else if (this instanceof Daily) {
            appType = "Daily Appointment     ";
        }

        return appType + dateFormattedString + ": " + AptDescription;
    }

}