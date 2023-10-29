package src;

import java.util.GregorianCalendar;

public class Appointment {

    private boolean monthly;
    private boolean daily;
    private GregorianCalendar date;

    /**
     * Constructor that is used for One Time and Monthly appointments.
     * 
     * @param month   - month of the year
     * @param day     - day of the month
     * @param year    - year of the date
     * @param monthly - if the appointment is monthly
     */
    public Appointment(int month, int day, int year, boolean monthly) {
        this.date = new GregorianCalendar(year, month, day);
        this.daily = false;
        this.monthly = monthly;
    }

    /**
     * Constructor that will create a daily appointment.
     */
    public Appointment() {
        this.daily = true;
    }
}