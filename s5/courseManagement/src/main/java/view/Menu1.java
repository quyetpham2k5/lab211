package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu1 {
    protected String title;
    protected ArrayList<String> mChon;
    protected Scanner sc;

    // ✅ Constructor có Scanner
    public Menu1(String td, String[] mc, Scanner sc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) mChon.add(s);
        this.sc = sc;
    }

    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < mChon.size(); i++)
            System.out.println((i + 1) + ". " + mChon.get(i));
        System.out.println("--------------------------------");
    }

    public int getSelected() {
        display();
        while (true) {
            try {
                System.out.print("Enter selection: ");
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= mChon.size()) return choice;
                System.out.println("⚠ Invalid selection!");
            } catch (NumberFormatException e) {
                System.out.println("⚠ Please enter a number!");
            }
        }
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n == mChon.size()) break;
        }
    }
}