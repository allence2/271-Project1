package src;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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

    public ArrayList<Object> getAppBook() {
        return appBook;
    }

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
