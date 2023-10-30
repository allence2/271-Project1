package src;

public class Onetime extends Appointment {
    public Onetime(String description, int month, int day, int year) {
        super(description, month, day, year, false);
    }

    public boolean occursOn(int year, int month, int day) {
        return false;
    }
}
