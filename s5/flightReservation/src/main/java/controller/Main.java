package controller;

import java.util.Scanner;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        String title = "*** Reservation Management ***";
        String[] options = {
            "Create new reservation",
            "Update reservation",
            "Delete reservation",
            "Print Flight Information",
            "Print all",
            "Exit"
        };
        
        Scanner sc = new Scanner(System.in);
        Menu myMenu = new Menu(title, options, sc);
        myMenu.run();
    }
}