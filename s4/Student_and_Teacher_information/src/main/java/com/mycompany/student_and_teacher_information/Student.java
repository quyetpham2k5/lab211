/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_and_teacher_information;



import java.util.Calendar;
import java.util.Scanner;

public class Student extends Person {
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0;
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        this.yearOfAdmission = readYearOfAdmission(sc);
        this.entranceEnglishScore = readEnglishScore(sc);
    }

    private int readYearOfAdmission(Scanner sc) {
        int current = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            System.out.print("Year of admission: ");
            String s = sc.nextLine().trim();
            try {
                int y = Integer.parseInt(s);
                if (y >= getYearOfBirth() && y <= current) return y;
            } catch (Exception ignored) {}
            System.out.println("Data input is  invalid");
        }
    }

    private int readEnglishScore(Scanner sc) {
        while (true) {
            System.out.print("Entrance English score: ");
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= 0 && v <= 100) return v;
            } catch (Exception ignored) {}
            System.out.println("Data input is  invalid");
        }
    }

    // Getters / Setters
    public int getYearOfAdmission() { return yearOfAdmission; }
    public void setYearOfAdmission(int y) { this.yearOfAdmission = y; }

    public int getEntranceEnglishScore() { return entranceEnglishScore; }
    public void setEntranceEnglishScore(int v) { this.entranceEnglishScore = v; }

    public String toStudentLine() {
        return getId() + " - " + getFullName() + " - " + getPhoneNumber() + " - "
                + getYearOfBirth() + " - " + getMajor() + " - "
                + yearOfAdmission + " - " + entranceEnglishScore;
    }
}
