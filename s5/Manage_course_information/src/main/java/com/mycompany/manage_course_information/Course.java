/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manage_course_information;


import java.util.Scanner;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;

    public Course() {
        this.courseId = "";
        this.courseName = "";
        this.credits = 0;
    }

    // ==== Input with validation (basic & clear) ====
    public void inputAll(Scanner sc) {
        this.courseId = readNonEmpty(sc, "Course ID: ");
        this.courseName = readNonEmpty(sc, "Course name: ");
        this.credits = readPositiveInt(sc, "Credits: ");
    }

    protected String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Data input is  invalid");
        }
    }

    protected int readPositiveInt(Scanner sc, String prompt) {
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

    // ==== Getters / Setters ====
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    // Short line for "print all"
    public String toBasicLine() {
        return courseId + "-" + courseName + "-" + credits;
    }
}
