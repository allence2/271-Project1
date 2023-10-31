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
        Appointment b = new Daily("eat", new GregorianCalendar(1997, 10, 30));
        Appointment c = new Monthly("play", new GregorianCalendar(2009, 10, 15));

        /**
         * tests if the first three constructors are accurately setting the appointments
         * in the AppointmentBook arraylist
         */
        // System.out.println(appBook.get(0));
        // System.out.println(appBook.get(1));
        // System.out.println(appBook.get(2));

        File saveFile = new File("save_file.txt");
        /**
         * tests the save and load methods of the AppointmentBook class are done
         * correctly
         */
        AppointmentBook.save(c, saveFile);
        AppointmentBook.save(b, saveFile);
        AppointmentBook.save(a, saveFile);
        ab.load(saveFile);
        // System.out.println(appBook.get(3));
        // System.out.println(appBook.get(4));

        for (int i = 0; i < appBook.size(); i++) {
            System.out.println(i + " " + appBook.get(i).toString());
        }

        boolean flag = true;
        while (flag) {
            System.out.println("Please enter a date to check appointments scheduled (mm-dd-yyyy): ");
            String date = in.nextLine();
            int year = Integer.parseInt(date.substring(date.indexOf("-", 5) + 1, date.length()));
            int month = Integer.parseInt(date.substring(0, date.indexOf("-")));
            int day = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", 5)));

            for (int i = 0; i < appBook.size(); i++) {
                String apt = appBook.get(i).toString();

                int year2 = Integer.parseInt(apt.substring((apt.indexOf("-", 25) + 1), apt.indexOf(":")));
                int month2 = Integer.parseInt(apt.substring(22, apt.indexOf("-")));
                int day2 = Integer.parseInt(apt.substring(apt.indexOf("-") + 1, (apt.indexOf("-", 25))));

                if ((apt.charAt(0)) == ('O')) {
                    Appointment checkApt = new Onetime("null", new GregorianCalendar(year2, month2, day2));
                    if (checkApt.occursOn(year, month, day)) {
                        System.out.println(apt);
                    }
                } else if ((apt.charAt(0)) == ('D')) {
                    Appointment checkApt = new Daily("null", new GregorianCalendar(year2, month2, day2));
                    if (checkApt.occursOn(year, month, day)) {
                        System.out.println(apt);
                    }
                } else if ((apt.charAt(0)) == ('M')) {
                    Appointment checkApt = new Monthly("null", new GregorianCalendar(year2, month2, day2));
                    if (checkApt.occursOn(year, month, day)) {
                        System.out.println(apt);
                    }
                }
            }
            System.out.println("Check Another (y/n):");
            String check = in.nextLine();
            if (check.equals("y")) {
                flag = true;
            } else if (check.equals("n")) {
                flag = false;
            }
        }
        in.close();
        // Can be deleted if the user wants to keep the file of appointments
        saveFile.delete();

    }
}
