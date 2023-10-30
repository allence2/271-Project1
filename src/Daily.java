package src;

public class Daily extends Appointment {
    public Daily() {
        super();
    }

    public boolean occursOn(int year, int month, int day) {
        return false;
    }
}