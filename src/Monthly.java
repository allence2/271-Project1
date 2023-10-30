package src;

import java.util.GregorianCalendar;

public class Monthly extends Appointment {
    public Monthly(String description, GregorianCalendar date) {
        super(description, date, true);
    }

    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar compareDate = new GregorianCalendar(year, month, day);

        if (compareDate.equals(date) || compareDate.after(date) && day == date.get(date.DATE)) {
            return true;
        }
        return false;
    }
}