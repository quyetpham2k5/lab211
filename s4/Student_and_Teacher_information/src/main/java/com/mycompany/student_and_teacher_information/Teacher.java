/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_and_teacher_information;



import java.util.Calendar;
import java.util.Scanner;

public class Teacher extends Person {
    private int yearInProfession;
    private String contractType; // Long / Short
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        this.yearInProfession = readYearInProfession(sc);
        this.contractType = readContractType(sc);
        this.salaryCoefficient = readSalaryCoeff(sc);
    }

    private int readYearInProfession(Scanner sc) {
        int current = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            System.out.print("Year in the profession: ");
            String s = sc.nextLine().trim();
            try {
                int y = Integer.parseInt(s);
                int age = current - getYearOfBirth();
                if (y >= 0 && y < age) return y;
            } catch (Exception ignored) {}
            System.out.println("Data input is  invalid");
        }
    }

    private String readContractType(Scanner sc) {
        while (true) {
            System.out.print("Contract type: ");
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("Long") || s.equalsIgnoreCase("Short")) {
                return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
            }
            System.out.println("Data input is  invalid");
        }
    }

    private double readSalaryCoeff(Scanner sc) {
        while (true) {
            System.out.print("Salary coefficient: ");
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v >= 0) return v;
            } catch (Exception ignored) {}
            System.out.println("Data input is  invalid");
        }
    }

    // Getters / Setters
    public int getYearInProfession() { return yearInProfession; }
    public void setYearInProfession(int y) { this.yearInProfession = y; }

    public String getContractType() { return contractType; }
    public void setContractType(String c) { this.contractType = c; }

    public double getSalaryCoefficient() { return salaryCoefficient; }
    public void setSalaryCoefficient(double s) { this.salaryCoefficient = s; }

    public String toTeacherLine() {
        return getId() + " - " + getFullName() + " - " + getPhoneNumber() + " - "
                + getYearOfBirth() + " - " + getMajor() + " - "
                + yearInProfession + " - " + contractType + " - " + salaryCoefficient;
    }
}
