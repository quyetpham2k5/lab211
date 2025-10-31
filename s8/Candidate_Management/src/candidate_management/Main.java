
package candidate_management;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidateManager manager = new CandidateManager();

        while (true) {
            System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Please choose 1..5: ");

            String raw = sc.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(raw); } catch (Exception e) { choice = -1; }

            switch (choice) {
                case 1 -> manager.createExperience();
                case 2 -> manager.createFresher();
                case 3 -> manager.createIntern();
                case 4 -> manager.searchCandidate();
                case 5 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
