/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manage_course_information;

import java.util.Scanner;

public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        this.platform = readNonEmpty(sc, "Platform: ");
        // Spec yêu cầu platform & note không rỗng; instructors theo ví dụ cũng nhập đầy đủ
        this.instructors = readNonEmpty(sc, "Instructors: ");
        this.note = readNonEmpty(sc, "Note: ");
    }

    // ===== Getters/Setters =====
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getInstructors() { return instructors; }
    public void setInstructors(String instructors) { this.instructors = instructors; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String toDetailLine() {
        return getCourseId() + "-" + getCourseName() + "-" + getCredits()
                + "-" + platform + "-" + instructors + "-" + note;
    }

    private String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Data input is  invalid");
        }
    }
}
