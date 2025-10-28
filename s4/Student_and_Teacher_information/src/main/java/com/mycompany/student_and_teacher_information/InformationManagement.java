/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_and_teacher_information;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class InformationManagement {
    private final ArrayList<Teacher> teachers = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            int choice = readInt("You choose: ", 1, 4);
            if (choice == 1) teacherMenu();
            else if (choice == 2) studentMenu();
            else if (choice == 3) personMenu();
            else {
                System.out.println("BYE AND SEE YOU NEXT TIME");
                return;
            }
        }
    }

    private int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= min && value <= max) return value;
            } catch (Exception ignored) {}
            System.out.println("Please enter a number in range [" + min + ", " + max + "]");
        }
    }

    private void teacherMenu() {
        while (true) {
            System.out.println("*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            int c = readInt("You choose: ", 1, 3);
            if (c == 1) {
                int n = readInt("How many teacher(s) to add: ", 1, 1000);
                for (int i = 0; i < n; i++) {
                    Teacher t = new Teacher();
                    t.inputAll(sc);
                    teachers.add(t);
                }
            } else if (c == 2) {
                System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year in the profession - Contract type - Salary coefficient");
                ArrayList<Teacher> copy = new ArrayList<>(teachers);
                copy.sort((a, b) -> Integer.compare(b.getYearInProfession(), a.getYearInProfession()));
                for (int i = 0; i < copy.size(); i++) {
                    System.out.println((i + 1) + " - " + copy.get(i).toTeacherLine());
                }
            } else return;
        }
    }

    private void studentMenu() {
        while (true) {
            System.out.println("*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            int c = readInt("You choose: ", 1, 3);
            if (c == 1) {
                int n = readInt("How many student(s) to add: ", 1, 1000);
                for (int i = 0; i < n; i++) {
                    Student s = new Student();
                    s.inputAll(sc);
                    students.add(s);
                }
            } else if (c == 2) {
                System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year of admission - Entrance English score");
                ArrayList<Student> copy = new ArrayList<>(students);
                copy.sort(Comparator.comparingInt(Student::getYearOfAdmission));
                for (int i = 0; i < copy.size(); i++) {
                    System.out.println((i + 1) + " - " + copy.get(i).toStudentLine());
                }
            } else return;
        }
    }

    private void personMenu() {
        while (true) {
            System.out.println("*** Person Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print all");
            System.out.println("3. Exit");
            int c = readInt("You choose: ", 1, 3);
            if (c == 1) {
                System.out.print("Name: ");
                String key = sc.nextLine().trim().toLowerCase();
                ArrayList<Person> found = new ArrayList<>();
                for (Teacher t : teachers) {
                    if (t.getFullName().toLowerCase().contains(key)) found.add(t);
                }
                for (Student s : students) {
                    if (s.getFullName().toLowerCase().contains(key)) found.add(s);
                }
                if (found.isEmpty()) {
                    System.out.println("Result: not found");
                } else {
                    System.out.println("Result:");
                    System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
                    found.sort((a, b) -> Integer.compare(b.getYearOfBirth(), a.getYearOfBirth()));
                    for (int i = 0; i < found.size(); i++) {
                        System.out.println((i + 1) + " - " + found.get(i).toPersonLine());
                    }
                }
            } else if (c == 2) {
                ArrayList<Person> all = new ArrayList<>();
                all.addAll(teachers);
                all.addAll(students);
                for (int i = 0; i < all.size(); i++) {
                    System.out.println((i + 1) + " - " + all.get(i).toPersonLine());
                }
            } else return;
        }
    }
}
