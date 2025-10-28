package controller;

import java.util.Scanner;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        String title = "*** Course Management ***";
        String[] options = {
            "Add online course / offline course",
            "Update course",
            "Delete course",
            "Print course information",
            "Search information by course name",
            "Exit"
        };
        
        Scanner sc = new Scanner(System.in);
        Menu myMenu = new Menu(title, options, sc);
        myMenu.run();
    }
}
