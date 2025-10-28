package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Reservation;

public class Validator {
    private final static Scanner sc = new Scanner(System.in);
    private final static String DATE_FORMAT = "dd/MM/yyyy";
    private final static String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";

    public static String getString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static String getBookingID(ArrayList<Reservation> list) {
        while (true) {
            String id = getString("ID: ");
            if (id.matches("^\\d{6}$")) {
                boolean isUnique = true;
                for (Reservation res : list) {
                    if (res.getBookingID().equals(id)) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) return id;
                System.out.println("⚠ This ID already exists!");
            } else {
                System.out.println("⚠ Data input is invalid! (ID must be 6 digits)");
            }
        }
    }
    
    public static String getName(String prompt) {
        while (true) {
            String name = getString(prompt);
            if (name.matches("^[a-zA-Z\\s]+$")) {
                return name;
            }
            System.out.println("⚠ Data input is invalid! (Name must be alphabet and blanks)");
        }
    }

    public static String getPhone() {
        while (true) {
            String phone = getString("Phone: ");
            if (phone.matches("^\\d{12}$")) {
                return phone;
            }
            System.out.println("⚠ Data input is invalid! (Phone must be 12 digits)");
        }
    }
    
    public static int getRoomNumber() {
        while (true) {
            String roomStr = getString("RoomNumber: ");
            if (roomStr.matches("^\\d{4}$")) {
                return Integer.parseInt(roomStr);
            }
            System.out.println("⚠ Data input is invalid! (Room number must be 4 digits)");
        }
    }

    public static Date getBookingDate() {
        while (true) {
            String dateStr = getString("BookingDate (dd/MM/yyyy): ");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                sdf.setLenient(false);
                Date bookingDate = sdf.parse(dateStr);
                if (bookingDate.after(new Date())) {
                    return bookingDate;
                }
                System.out.println("⚠ Booking date must be after present!");
            } catch (ParseException e) {
                System.out.println("⚠ Data input is invalid! (Incorrect date format)");
            }
        }
    }

    public static Date getTimePickUp(Date bookingDate) {
        while (true) {
            String timeStr = getString("TimePickUp (dd/MM/yyyy HH:mm): ");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
                sdf.setLenient(false);
                Date pickupTime = sdf.parse(timeStr);
                if (pickupTime.after(new Date()) && pickupTime.before(bookingDate)) {
                    return pickupTime;
                }
                System.out.println("⚠ Pickup time must be after present and before booking date!");
            } catch (ParseException e) {
                System.out.println("⚠ Data input is invalid! (Incorrect datetime format)");
            }
        }
    }
    
    public static boolean getYesNo(String prompt) {
        while (true) {
            String choice = getString(prompt).toUpperCase();
            if (choice.equals("Y")) return true;
            if (choice.equals("N")) return false;
            System.out.println("⚠ Data input is invalid! (Please enter Y or N)");
        }
    }
}
