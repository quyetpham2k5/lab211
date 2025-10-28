package view;

import controller.ReservationManager;
import java.util.Scanner;

public class Menu extends Menu1 {

    private ReservationManager manager;

    public Menu(String td, String[] mc, Scanner sc) {
        super(td, mc, sc);
        manager = new ReservationManager();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                manager.createReservation();
                break;
            case 2:
                manager.updateReservation();
                break;
            case 3:
                manager.deleteReservation();
                break;
            case 4:
                manager.printFlightInfo();
                break;
            case 5:
                manager.printAll();
                break;
            case 6:
                System.out.println("BYE AND SEE YOU NEXT TIME!");
                System.exit(0);
        }
    }
}
