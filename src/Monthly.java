package src;

public class Monthly extends Appointment {
    public Monthly(String description, int day) {
        super(description, 0, day, 0, true);
    }

    public boolean occursOn(int year, int month, int day) {
        return false;
    }
}