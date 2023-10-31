package src;

import java.util.GregorianCalendar;

public class Daily extends Appointment {
    public Daily(String description, GregorianCalendar startDate) {
        super(description, startDate);
    }

    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar compareDate = new GregorianCalendar(year, month, day);

        if (compareDate.equals(date) || compareDate.after(date)) {
            return true;
        }
        return false;
    }
}