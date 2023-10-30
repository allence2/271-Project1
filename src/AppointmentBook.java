package src;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AppointmentBook {

    public enum Type {
        ONETIME, MONTHLY, DAILY;
    }

    ArrayList<Object> appBook = new ArrayList<Object>();

    /**
     * Method to add dates of any types to the Appointment Book
     * 
     * @param appType - Monthly, Daily, Onetime
     * @param desc    - Description of what the appointment is for
     * @param date    - Date of the appointemnt
     */
    public void addAppointment(Type appType, String desc, GregorianCalendar date) {
        switch (appType) {
            case ONETIME:
                appBook.add(new Onetime(desc, date));
                break;
            case MONTHLY:
                appBook.add(new Monthly(desc, date));
                break;
            case DAILY:
                appBook.add(new Onetime(desc, date));
                break;
        }
    }

}
