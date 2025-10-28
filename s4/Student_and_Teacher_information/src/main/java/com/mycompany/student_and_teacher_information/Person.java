/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_and_teacher_information;


import java.util.Calendar;
import java.util.Scanner;

public class Person {
    private String id;
    private String fullName;
    private String phoneNumber;
    private int yearOfBirth;
    private String major;

    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }

    public void inputAll(Scanner sc) {
        this.id = readId(sc);
        this.fullName = readFullName(sc);
        this.phoneNumber = readPhone(sc);
        this.yearOfBirth = readBirthYear(sc);
        this.major = readMajor(sc);
    }

    protected String readId(Scanner sc) {
        while (true) {
            System.out.print("ID: ");
            String s = sc.nextLine().trim();
            if (s.matches("\\d{6}")) return s;
            System.out.println("Data input is  invalid");
        }
    }

    protected String readFullName(Scanner sc) {
        while (true) {
            System.out.print("Fullname: ");
            String s = sc.nextLine().trim();
            if (s.matches("[A-Za-z ]+")) return s;
            System.out.println("Data input is  invalid");
        }
    }

    protected String readPhone(Scanner sc) {
        while (true) {
            System.out.print("Phone number: ");
            String s = sc.nextLine().trim();
            if (s.matches("\\d{10}")) return s;
            System.out.println("Data input is  invalid");
        }
    }

    protected int readBirthYear(Scanner sc) {
        int current = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            System.out.print("Year of birth: ");
            String s = sc.nextLine().trim();
            try {
                int y = Integer.parseInt(s);
                if (y < current && y > 1900) return y;
            } catch (Exception ignored) {}
            System.out.println("Data input is  invalid");
        }
    }

    protected String readMajor(Scanner sc) {
        while (true) {
            System.out.print("Major: ");
            String s = sc.nextLine().trim();
            if (s.length() <= 30) return s;
            System.out.println("Data input is  invalid");
        }
    }

    // Getters / Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String toPersonLine() {
        return getId() + " - " + getFullName() + " - " + getPhoneNumber()
                + " - " + getYearOfBirth() + " - " + getMajor();
    }
}
