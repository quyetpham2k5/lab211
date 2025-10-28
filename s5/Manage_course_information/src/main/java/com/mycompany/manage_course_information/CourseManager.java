/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manage_course_information;

 

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    private final ArrayList<Course> courses = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all / online course / offline course");
            System.out.println("5. Search information base on course name");
            System.out.println("6. Exit");
            int c = readInt("You choose: ", 1, 6);

            if (c == 1) addCourse();
            else if (c == 2) updateCourse();
            else if (c == 3) deleteCourse();
            else if (c == 4) printCourses();
            else if (c == 5) searchByName();
            else {
                System.out.println("BYE AND SEE YOU NEXT TIME");
                return;
            }
        }
    }

    // ===== 1. Add =====
    private void addCourse() {
        System.out.println("*** Add new course ***");
        String type = readType("Online (O) or Offline (F): ");
        if (type.equals("O")) {
            System.out.println("Create new online course");
            OnlineCourse oc = new OnlineCourse();
            // Enforce uniqueness while reading
            String id = readUniqueId();
            String name = readUniqueName();
            int credits = readPositiveInt("Credits: ");
            oc.setCourseId(id);
            oc.setCourseName(name);
            oc.setCredits(credits);
            // platform / instructors / note
            oc.setPlatform(readNonEmpty("Platform: "));
            oc.setInstructors(readNonEmpty("Instructors: "));
            oc.setNote(readNonEmpty("Note: "));
            courses.add(oc);
        } else {
            System.out.println("Create new offline course");
            OfflineCourse of = new OfflineCourse();
            String id = readUniqueId();
            String name = readUniqueName();
            int credits = readPositiveInt("Credits: ");
            of.setCourseId(id);
            of.setCourseName(name);
            of.setCredits(credits);
            // begin / end / campus with validation in helper
            of.setBegin(readFutureDate("Begin: "));
            String end = readFutureDate("End: ");
            while (!isBeginBeforeEnd(of.getBegin(), end)) {
                System.out.println("Data input is  invalid, end must be after begin");
                end = readFutureDate("End: ");
            }
            of.setEnd(end);
            of.setCampus(readNonEmpty("Campus: "));
            courses.add(of);
        }
    }

    // ===== 2. Update =====
    private void updateCourse() {
        System.out.println("*** Update course ***");
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            int idx = indexById(id);
            if (idx == -1) {
                if (!askYesNo("No data found, do you want to find again? (Y/N): ")) return;
            } else {
                Course c = courses.get(idx);
                printDetail(c);
                System.out.println("*** Updating ***");
                System.out.println("Note: Enter empty if you don't want to change it.");

                // ID
                System.out.print("Course ID: ");
                String newId = sc.nextLine().trim();
                if (!newId.isEmpty()) {
                    if (!newId.equalsIgnoreCase(c.getCourseId()) && existsId(newId)) {
                        System.out.println("Data input is  invalid, ID must be unique");
                    } else c.setCourseId(newId);
                }

                // Name
                System.out.print("Course name: ");
                String newName = sc.nextLine().trim();
                if (!newName.isEmpty()) {
                    if (!newName.equalsIgnoreCase(c.getCourseName()) && existsName(newName)) {
                        System.out.println("Data input is  invalid, name must be unique");
                    } else c.setCourseName(newName);
                }

                // Credits
                System.out.print("Credits: ");
                String cr = sc.nextLine().trim();
                if (!cr.isEmpty()) {
                    try {
                        int v = Integer.parseInt(cr);
                        if (v > 0) c.setCredits(v);
                        else System.out.println("Data input is  invalid");
                    } catch (Exception ex) {
                        System.out.println("Data input is  invalid");
                    }
                }

                if (c instanceof OnlineCourse oc) {
                    System.out.print("Platform: ");
                    String s = sc.nextLine().trim();
                    if (!s.isEmpty()) oc.setPlatform(s);

                    System.out.print("Instructors: ");
                    s = sc.nextLine().trim();
                    if (!s.isEmpty()) oc.setInstructors(s);

                    System.out.print("Note: ");
                    s = sc.nextLine().trim();
                    if (!s.isEmpty()) oc.setNote(s);
                } else if (c instanceof OfflineCourse of) {
                    System.out.print("Begin: ");
                    String s = sc.nextLine().trim();
                    if (!s.isEmpty()) {
                        if (isFutureDate(s)) of.setBegin(s);
                        else System.out.println("Data input is  invalid");
                    }

                    System.out.print("End: ");
                    s = sc.nextLine().trim();
                    if (!s.isEmpty()) {
                        if (isFutureDate(s) && isBeginBeforeEnd(of.getBegin(), s)) of.setEnd(s);
                        else System.out.println("Data input is  invalid, end must be after begin");
                    }

                    System.out.print("Campus: ");
                    s = sc.nextLine().trim();
                    if (!s.isEmpty()) of.setCampus(s);
                }

                System.out.println("Updated successfully");
                return;
            }
        }
    }

    // ===== 3. Delete =====
    private void deleteCourse() {
        System.out.println("*** Delete course ***");
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            int idx = indexById(id);
            if (idx == -1) {
                if (!askYesNo("No data found, do you want to find again? (Y/N): ")) return;
            } else {
                courses.remove(idx);
                System.out.println("Deleted successfully");
                return;
            }
        }
    }

    // ===== 4. Print =====
    private void printCourses() {
        System.out.println("*** Print course ***");
        String opt = readPrintOpt("Do you want to print all (A), online course (O) or offline course (F): ");
        if (opt.equals("A")) {
            System.out.println("Course ID-Course name-Credits");
            for (Course c : courses) System.out.println(c.toBasicLine());
        } else if (opt.equals("O")) {
            System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note");
            for (Course c : courses)
                if (c instanceof OnlineCourse oc) System.out.println(oc.toDetailLine());
        } else {
            // F
            System.out.println("Course ID-Course name-Credits-Begin-End-Campus");
            for (Course c : courses)
                if (c instanceof OfflineCourse of)
                    System.out.println(of.getCourseId() + "-" + of.getCourseName() + "-" + of.getCredits()
                            + "-" + of.getBegin() + "-" + of.getEnd() + "-" + of.getCampus());
        }
    }

    // ===== 5. Search by name =====
    private void searchByName() {
        System.out.println("*** Searching ***");
        while (true) {
            System.out.print("Course name: ");
            String key = sc.nextLine().trim().toLowerCase();
            ArrayList<Course> found = new ArrayList<>();
            for (Course c : courses)
                if (c.getCourseName().toLowerCase().contains(key)) found.add(c);

            if (found.isEmpty()) {
                if (!askYesNo("No data found, do you want to find again? (Y/N): ")) return;
            } else {
                for (Course c : found) printDetail(c);
                return;
            }
        }
    }

    // ===== Helpers =====
    private boolean existsId(String id) {
        for (Course c : courses) if (c.getCourseId().equalsIgnoreCase(id)) return true;
        return false;
    }

    private boolean existsName(String name) {
        for (Course c : courses) if (c.getCourseName().equalsIgnoreCase(name)) return true;
        return false;
    }

    private int indexById(String id) {
        for (int i = 0; i < courses.size(); i++)
            if (courses.get(i).getCourseId().equalsIgnoreCase(id)) return i;
        return -1;
    }

    private String readUniqueId() {
        while (true) {
            System.out.print("Course ID: ");
            String s = sc.nextLine().trim();
            if (s.isEmpty()) { System.out.println("Data input is  invalid"); continue; }
            if (existsId(s)) { System.out.println("Data input is  invalid, ID must be unique"); continue; }
            return s;
        }
    }

    private String readUniqueName() {
        while (true) {
            System.out.print("Course name: ");
            String s = sc.nextLine().trim();
            if (s.isEmpty()) { System.out.println("Data input is  invalid"); continue; }
            if (existsName(s)) { System.out.println("Data input is  invalid, name must be unique"); continue; }
            return s;
        }
    }

    private int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
            } catch (Exception ignored) {}
            System.out.println("Please enter a number in range [" + min + ", " + max + "]");
        }
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Data input is  invalid");
        }
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v > 0) return v;
            } catch (Exception ignored) {}
            System.out.println("Data input is  invalid");
        }
    }

    private String readType(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("O") || s.equalsIgnoreCase("Online")) return "O";
            if (s.equalsIgnoreCase("F") || s.equalsIgnoreCase("Offline")) return "F";
            System.out.println("Data input is  invalid");
        }
    }

    private String readPrintOpt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("A") || s.equalsIgnoreCase("All")) return "A";
            if (s.equalsIgnoreCase("O") || s.equalsIgnoreCase("Online")) return "O";
            if (s.equalsIgnoreCase("F") || s.equalsIgnoreCase("Offline")) return "F";
            System.out.println("Data input is  invalid");
        }
    }

    // --- Date helpers (simple; format d/M/yyyy) ---
    private boolean isFutureDate(String dmy) {
        return new OfflineCourse().isFutureDate(dmy); // reuse impl
    }
    private boolean isBeginBeforeEnd(String b, String e) {
        return new OfflineCourse().isBeginBeforeEnd(b, e);
    }

    private boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.println("Data input is  invalid");
        }
    }

    private void printDetail(Course c) {
        System.out.println("*** Search results ***");
        System.out.println("Course ID: " + c.getCourseId());
        System.out.println("Course name: " + c.getCourseName());
        System.out.println("Credits: " + c.getCredits());
        if (c instanceof OnlineCourse oc) {
            System.out.println("Platform: " + oc.getPlatform());
            System.out.println("Instructors: " + oc.getInstructors());
            System.out.println("Note: " + oc.getNote());
        } else if (c instanceof OfflineCourse of) {
            System.out.println("Begin: " + of.getBegin());
            System.out.println("End: " + of.getEnd());
            System.out.println("Campus: " + of.getCampus());
        }
    }
}

