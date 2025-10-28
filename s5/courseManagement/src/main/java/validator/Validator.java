package validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Course;

public class Validator {
    private final static Scanner sc = new Scanner(System.in);
    private final static String DATE_FORMAT = "dd/MM/yyyy";

    public static String getString(String prompt, boolean notEmpty) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!notEmpty || !s.isEmpty()) {
                return s;
            }
            System.out.println("Data input is invalid! Cannot be empty.");
        }
    }

    public static String getCourseID(ArrayList<Course> list, String prompt) {
        while (true) {
            String id = getString(prompt, true);
            boolean isUnique = true;
            for (Course course : list) {
                if (course.getCourseID().equalsIgnoreCase(id)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) return id;
            System.out.println(" Data input is invalid, ID must be unique!");
        }
    }

    public static String getCourseName(ArrayList<Course> list, String prompt) {
        while (true) {
            String name = getString(prompt, true);
            boolean isUnique = true;
            for (Course course : list) {
                if (course.getCourseName().equalsIgnoreCase(name)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) return name;
            System.out.println(" Data input is invalid, name must be unique!");
        }
    }
    
    public static int getCredits(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int credits = Integer.parseInt(sc.nextLine().trim());
                if (credits > 0) return credits;
                System.out.println(" Data input is invalid! Credits must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println(" Data input is invalid! Please enter a number.");
            }
        }
    }

    public static Date getFutureDate(String prompt) {
        while (true) {
            String dateStr = getString(prompt, true);
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                sdf.setLenient(false);
                Date date = sdf.parse(dateStr);
                if (date.after(new Date())) return date;
                System.out.println(" Data input is invalid, date must be in the future!");
            } catch (ParseException e) {
                System.out.println(" Data input is invalid! Incorrect date format (dd/MM/yyyy).");
            }
        }
    }
    
    public static Date getEndDate(String prompt, Date beginDate) {
        while (true) {
            Date endDate = getFutureDate(prompt);
            if(endDate.after(beginDate)) return endDate;
            System.out.println(" Data input is invalid, end must be after begin!");
        }
    }

    public static boolean getYesNo(String prompt) {
        while (true) {
            String choice = getString(prompt, true).toUpperCase();
            if (choice.equals("Y")) return true;
            if (choice.equals("N")) return false;
            System.out.println(" Data input is invalid! (Please enter Y or N)");
        }
    }
    
    public static char getCourseType(String prompt) {
        while (true) {
            String choice = getString(prompt, true).toUpperCase();
            if (choice.equals("O")) return 'O';
            if (choice.equals("F")) return 'F';
            System.out.println("Data input is invalid! Enter 'O' for Online or 'F' for Offline.");
        }
    }
    
    public static char getPrintType(String prompt) {
        while (true) {
            String choice = getString(prompt, true).toUpperCase();
            if (choice.equals("A") || choice.equals("O") || choice.equals("F")) {
                return choice.charAt(0);
            }
            System.out.println(" Data input is invalid! Enter 'A', 'O', or 'F'.");
        }
    }
}
