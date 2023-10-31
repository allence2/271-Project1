package src;

import java.util.GregorianCalendar;

public class Monthly extends Appointment {
    public Monthly(String description, GregorianCalendar date) {
        super(description, date);
    }

    public boolean occursOn(int year, int month, int day) {
        GregorianCalendar compareDate = new GregorianCalendar(year, month, day);

        if (compareDate.equals(this.date) || compareDate.after(this.date) && day == this.date.get(this.date.DATE)) {
            return true;
        }
        return false;
    }
}