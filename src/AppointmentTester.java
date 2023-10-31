package src;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AppointmentTester {

    public static void main(String[] args) throws IOException {
        AppointmentBook ab = new AppointmentBook();
        ArrayList<Object> appBook = ab.getAppBook();
        Scanner in = new Scanner(System.in);

        ab.addAppointment(AppointmentBook.Type.ONETIME, "Work", new GregorianCalendar(2023, 01, 01));
        ab.addAppointment(AppointmentBook.Type.DAILY, "School", new GregorianCalendar(2023, 07, 15));
        ab.addAppointment(AppointmentBook.Type.MONTHLY, "My birthday", new GregorianCalendar(1997, 12, 30));

        Appointment a = new Onetime("die", new GregorianCalendar(3004, 04, 17));
        Appointment b = new Daily("eat", new GregorianCalendar(2023, 10, 30));
        Appointment c = new Monthly("play", new GregorianCalendar(2009, 10, 15));

        /**
         * tests if the first three constructors are accurately setting the appointments
         * in the AppointmentBook arraylist
         */
        System.out.println(appBook.get(0));
        System.out.println(appBook.get(1));
        System.out.println(appBook.get(2));

        File saveFile = new File("save_file.txt");
        /**
         * tests the save and load methods of the AppointmentBook class are done
         * correctly
         */
        AppointmentBook.save(c, saveFile);
        AppointmentBook.save(b, saveFile);
        AppointmentBook.save(a, saveFile);
        ab.load(saveFile);
        ab.load(saveFile);
        System.out.println(appBook.get(3));
        System.out.println(appBook.get(4));

        in.close();
        // Can be deleted if the user wants to keep the file of appointments
        // saveFile.delete();

    }
}
