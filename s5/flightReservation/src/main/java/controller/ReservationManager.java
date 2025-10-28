package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import model.FlightInformation;
import model.Reservation;

public class ReservationManager {
    private ArrayList<Reservation> reservations;

    public ReservationManager() {
        reservations = new ArrayList<>();
    }

    public void createReservation() {
        System.out.println("\n*** Create new reservation ***");
        String id = Validator.getBookingID(reservations);
        String name = Validator.getName("Name: ");
        String phone = Validator.getPhone();
        int room = Validator.getRoomNumber();
        Date bookingDate = Validator.getBookingDate();
        
        FlightInformation flightInfo = null;
        if (Validator.getYesNo("Need airport pick up? (Y/N): ")) {
            String flightNum = Validator.getString("Flight: ");
            String seatNum = Validator.getString("Seat: ");
            Date pickupTime = Validator.getTimePickUp(bookingDate);
            flightInfo = new FlightInformation(flightNum, seatNum, pickupTime);
        }

        reservations.add(new Reservation(id, name, phone, room, bookingDate, flightInfo));
        System.out.println("✅ Information saved successfully.");
    }

    private Reservation findById(String id) {
        for (Reservation res : reservations) {
            if (res.getBookingID().equals(id)) {
                return res;
            }
        }
        return null;
    }
    
    public void updateReservation() {
        System.out.println("\n*** Update reservation ***");
        if (reservations.isEmpty()) {
            System.out.println("No reservation data to update.");
            return;
        }

        Reservation resToUpdate = null;
        while(resToUpdate == null) {
            String id = Validator.getString("Enter bookingID to update: ");
            resToUpdate = findById(id);
            if (resToUpdate == null) {
                System.out.println("⚠ No information found.");
                if (!Validator.getYesNo("You want to find again? (Y/N): ")) return;
            }
        }
        
        System.out.println("Current information:");
        printSingleReservation(resToUpdate);
        System.out.println("If you do not want to change the information, just press enter to skip.");

        // Update logic for each field... (example for name)
        String newName = Validator.getString("New Name: ");
        if(!newName.isEmpty()) resToUpdate.setCustomerName(newName);
        // ... (add similar logic for phone, room, date, etc.)

        System.out.println("✅ Information updated successfully.");
    }

    public void deleteReservation() {
        System.out.println("\n*** Delete reservation ***");
         if (reservations.isEmpty()) {
            System.out.println("No reservation data to delete.");
            return;
        }
        
        Reservation resToDelete = null;
        while(resToDelete == null) {
            String id = Validator.getString("Enter bookingID to delete: ");
            resToDelete = findById(id);
            if (resToDelete == null) {
                System.out.println("⚠ No information found.");
                if (!Validator.getYesNo("You want to find again? (Y/N): ")) return;
            }
        }

        printSingleReservation(resToDelete);
        if (Validator.getYesNo("Are you sure you want to delete this information? (Y/N): ")) {
            reservations.remove(resToDelete);
            System.out.println("✅ Information deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    public void printFlightInfo() {
        System.out.println("\n*** Flight Information ***");
        ArrayList<Reservation> flightList = new ArrayList<>();
        for (Reservation res : reservations) {
            if (res.getFlightInformation() != null) {
                flightList.add(res);
            }
        }

        if (flightList.isEmpty()) {
            System.out.println("No flight information to view.");
            return;
        }

        // Sort by pickup time
        Collections.sort(flightList, Comparator.comparing(res -> res.getFlightInformation().getTimePickUp()));
        
        System.out.printf("%-10s %-20s %-15s %-10s %-10s %-20s\n",
                "ID", "Name", "Phone", "Flight", "Seat", "TimePickUp");
        for (Reservation res : flightList) {
            FlightInformation f = res.getFlightInformation();
            System.out.printf("%-10s %-20s %-15s %-10s %-10s %-20s\n",
                    res.getBookingID(), res.getCustomerName(), res.getPhoneNumber(),
                    f.getFlightNumber(), f.getSeatNumber(), new SimpleDateFormat("dd/MM/yyyy HH:mm").format(f.getTimePickUp()));
        }
    }

    public void printAll() {
        System.out.println("\n*** All Reservation Information ***");
        if (reservations.isEmpty()) {
            System.out.println("No information to view.");
            return;
        }
        
        System.out.printf("%-10s %-20s %-15s %-10s %-15s %s\n", 
                "ID", "Name", "Phone", "Room", "BookingDate", "FlightInfo");
        for (Reservation res : reservations) {
            printSingleReservation(res);
        }
    }

    private void printSingleReservation(Reservation res) {
        String bookingDate = new SimpleDateFormat("dd/MM/yyyy").format(res.getBookingDate());
        String flightInfoStr = "N/A";
        if(res.getFlightInformation() != null) {
            flightInfoStr = String.format("%s-%s @ %s", 
                res.getFlightInformation().getFlightNumber(),
                res.getFlightInformation().getSeatNumber(),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").format(res.getFlightInformation().getTimePickUp())
            );
        }
         System.out.printf("%-10s %-20s %-15s %-10d %-15s %s\n",
                res.getBookingID(), res.getCustomerName(), res.getPhoneNumber(),
                res.getRoomNumber(), bookingDate, flightInfoStr);
    }
}