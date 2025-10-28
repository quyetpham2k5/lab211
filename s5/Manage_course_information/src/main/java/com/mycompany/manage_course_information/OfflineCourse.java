/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manage_course_information;

 

import java.util.Calendar;
import java.util.Scanner;

public class OfflineCourse extends Course {
    private String begin; // format d/M/yyyy
    private String end;   // format d/M/yyyy
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = "";
        this.end = "";
        this.campus = "";
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        this.begin = readFutureDate(sc, "Begin: ");
        this.end = readFutureDate(sc, "End: ");
        while (!isBeginBeforeEnd(this.begin, this.end)) {
            System.out.println("Data input is  invalid, end must be after begin");
            this.end = readFutureDate(sc, "End: ");
        }
        this.campus = readNonEmpty(sc, "Campus: ");
    }

    // ===== Validation helpers (basic parsing) =====
    private String readFutureDate(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (isFutureDate(s)) return s;
            System.out.println("Data input is  invalid");
        }
    }

    private boolean isFutureDate(String dmy) {
        // Accept "d/M/yyyy" numbers only
        try {
            String[] p = dmy.split("/");
            if (p.length != 3) return false;
            int d = Integer.parseInt(p[0]);
            int m = Integer.parseInt(p[1]);
            int y = Integer.parseInt(p[2]);
            if (m < 1 || m > 12) return false;
            if (d < 1 || d > 31) return false; // simple check
            Calendar now = Calendar.getInstance();
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.set(y, m - 1, d);
            return c.after(now);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isBeginBeforeEnd(String b, String e) {
        try {
            String[] pb = b.split("/");
            String[] pe = e.split("/");
            Calendar cb = Calendar.getInstance();
            Calendar ce = Calendar.getInstance();
            cb.set(Integer.parseInt(pb[2]), Integer.parseInt(pb[1]) - 1, Integer.parseInt(pb[0]), 0, 0, 0);
            cb.set(Calendar.MILLISECOND, 0);
            ce.set(Integer.parseInt(pe[2]), Integer.parseInt(pe[1]) - 1, Integer.parseInt(pe[0]), 0, 0, 0);
            ce.set(Calendar.MILLISECOND, 0);
            return ce.after(cb);
        } catch (Exception ex) {
            return false;
        }
    }

    private String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Data input is  invalid");
        }
    }

    // ===== Getters/Setters =====
    public String getBegin() { return begin; }
    public void setBegin(String begin) { this.begin = begin; }

    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }

    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus; }
}
