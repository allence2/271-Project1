package src;

import java.util.GregorianCalendar;

public abstract class Appointment {

    private boolean monthly;
    private boolean daily;
    private GregorianCalendar date;
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
}