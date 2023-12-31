package src;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AppointmentBook {

    /**
     * ENUM types for each subtype of appointment
     */
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
        if (appType == Type.ONETIME) {
            Onetime o = new Onetime(desc, date);
            appBook.add(o);
        } else if (appType == Type.DAILY) {
            Daily d = new Daily(desc, date);
            appBook.add(d);
        } else if (appType == Type.MONTHLY) {
            Monthly m = new Monthly(desc, date);
            appBook.add(m);
        }
    }

    /**
     * Returns the collection of appointments in the AppointmentBook object
     * 
     * @return - AppointmentBook object
     */
    public ArrayList<Object> getAppBook() {
        return appBook;
    }

    /**
     * Save parameterized appointment object to parameterized file with proper
     * formatting
     * 
     * @param app      - Appointment object to be added to file
     * @param fileName - File object that the appointment will be added to
     * @throws IOException
     */
    public static void save(Appointment app, File fileName) throws IOException {
        try {
            if (!fileName.exists()) {
                fileName.createNewFile();
            }
            FileWriter fw = new FileWriter(fileName, true);
            fw.append(app.toString());
            fw.append(String.format("%n"));
            fw.close();

        } catch (IOException e) {
            System.out.println("Could not log appointment to File.");
        }
    }

    /**
     * Load appointments from parameterized, formatted file
     * 
     * @param fileName - File object that contains the appointments
     * @throws FileNotFoundException
     */
    public void load(File fileName) throws FileNotFoundException {
        Scanner in = new Scanner(fileName);

        while (in.hasNextLine()) {
            String app = in.nextLine();
            int year = Integer.parseInt(app.substring((app.indexOf("-", 25) + 1), app.indexOf(":")));
            int month = Integer.parseInt(app.substring(22, app.indexOf("-")));
            int day = Integer.parseInt(app.substring(app.indexOf("-") + 1, (app.indexOf("-", 25))));
            String descString = app.substring((app.indexOf(":") + 2), app.length());
            GregorianCalendar appDate = new GregorianCalendar(year, month, day);
            if (app.charAt(0) == 'O') {
                addAppointment(Type.ONETIME, descString, appDate);
            } else if (app.charAt(0) == 'M') {
                addAppointment(Type.MONTHLY, descString, appDate);
            } else if (app.charAt(0) == 'D') {
                addAppointment(Type.DAILY, descString, appDate);
            }
        }

        in.close();
    }

}
