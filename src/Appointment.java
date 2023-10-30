package src;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Appointment {

    Calendar date = new GregorianCalendar();

    private boolean monthly;
    private boolean daily;
    private String AptDescription;

    /**
     * Constructor that is used for One Time and Monthly appointments.
     * 
     * @param month   - month of the year
     * @param day     - day of the month
     * @param year    - year of the date
     * @param monthly - if the appointment is monthly
     */
    public Appointment(String description, GregorianCalendar date, boolean monthly) {
        this.date = date;
        this.daily = false;
        this.monthly = monthly;
        this.AptDescription = description;
    }

    /**
     * Constructor that will create a daily appointment.
     */
    public Appointment() {
        this.daily = true;
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
     * Returns the integer of the corresponding month
     * 
     * @return
     */
    public int getMonth() {
        return date.get(Calendar.MONTH);
    }

    @Override
    public String toString() {
        String dateFormattedString = date.get(Calendar.DAY_OF_MONTH) + "-" + date.get(Calendar.MONTH) + "-"
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