/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package candidate_management;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CandidateManager {
    // Theo guideline: dùng ArrayList để lưu từng loại
    private final ArrayList<ExperienceCandidate> experienceList = new ArrayList<>();
    private final ArrayList<FresherCandidate> fresherList = new ArrayList<>();
    private final ArrayList<InternCandidate> internList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    // ====== Helpers: đọc & kiểm tra ======
    private String readNonEmpty(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input must not be empty!");
        }
    }

    private int readIntRange(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer in range [" + min + "," + max + "]");
            }
        }
    }

    private int readBirthYear() {
        int current = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            String raw = readNonEmpty("Birth year (YYYY): ");
            if (raw.matches("\\d{4}")) {
                int y = Integer.parseInt(raw);
                if (y >= 1900 && y <= current) return y;
            }
            System.out.println("Birth year must be 4 digits in [1900.." + current + "]");
        }
    }

    private String readPhone() {
        while (true) {
            String p = readNonEmpty("Phone (>=10 digits): ");
            if (p.matches("\\d{10,}")) return p;
            System.out.println("Phone must be numeric and at least 10 digits");
        }
    }

    private String readEmail() {
        while (true) {
            String e = readNonEmpty("Email: ");
            if (e.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) return e;
            System.out.println("Email must be in format account@domain");
        }
    }

    private int readYOE() { return readIntRange("Year of Experience (0..100): ", 0, 100); }

    private String readRank() {
        while (true) {
            String r = readNonEmpty("Rank of Graduation (Excellence/Good/Fair/Poor): ");
            String v = r.toLowerCase(Locale.ROOT);
            if (v.equals("excellence") || v.equals("good") || v.equals("fair") || v.equals("poor"))
                return capitalize(v);
            System.out.println("Rank must be one of: Excellence, Good, Fair, Poor");
        }
    }

    private String capitalize(String s) {
        if (s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    // ====== Tạo ứng viên chung (phần base) ======
    private CandidateInfo inputBaseInfo() {
        String id = readNonEmpty("Candidate ID: ");
        String first = readNonEmpty("First name: ");
        String last = readNonEmpty("Last name: ");
        int year = readBirthYear();
        String addr = readNonEmpty("Address: ");
        String phone = readPhone();
        String email = readEmail();
        return new CandidateInfo(id, first, last, year, addr, phone, email);
    }

    // ====== API cho Main ======
    public void createExperience() {
        while (true) {
            System.out.println("=== CREATE EXPERIENCE CANDIDATE ===");
            CandidateInfo base = inputBaseInfo();
            int yoe = readYOE();
            String skill = readNonEmpty("Professional Skill: ");

            experienceList.add(new ExperienceCandidate(
                    base.id, base.first, base.last, base.year, base.addr, base.phone, base.email,
                    yoe, skill));

            if (!askContinue()) break;
        }
        printAllByGroup();
    }

    public void createFresher() {
        while (true) {
            System.out.println("=== CREATE FRESHER CANDIDATE ===");
            CandidateInfo base = inputBaseInfo();
            String gradDate = readNonEmpty("Graduation date (e.g., 2024 or 2024-06): ");
            String rank = readRank();
            String edu = readNonEmpty("University: ");

            fresherList.add(new FresherCandidate(
                    base.id, base.first, base.last, base.year, base.addr, base.phone, base.email,
                    gradDate, rank, edu));

            if (!askContinue()) break;
        }
        printAllByGroup();
    }

    public void createIntern() {
        while (true) {
            System.out.println("=== CREATE INTERN CANDIDATE ===");
            CandidateInfo base = inputBaseInfo();
            String majors = readNonEmpty("Majors: ");
            String semester = readNonEmpty("Semester: ");
            String uni = readNonEmpty("University name: ");

            internList.add(new InternCandidate(
                    base.id, base.first, base.last, base.year, base.addr, base.phone, base.email,
                    majors, semester, uni));

            if (!askContinue()) break;
        }
        printAllByGroup();
    }

    public void searchCandidate() {
        // Hiển thị toàn bộ trước khi tìm (đúng yêu cầu)
        printAllByGroup();

        String keyword = readNonEmpty("\nInput Candidate name (First name or Last name): ").toLowerCase();
        int type = readIntRange("Input type of candidate (0=Experience,1=Fresher,2=Intern): ", 0, 2);

        System.out.println("\nThe candidates found:");
        if (type == 0) {
            for (ExperienceCandidate c : experienceList) {
                if (c.getFirstName().toLowerCase().contains(keyword)
                        || c.getLastName().toLowerCase().contains(keyword)) {
                    System.out.println(c);
                }
            }
        } else if (type == 1) {
            for (FresherCandidate c : fresherList) {
                if (c.getFirstName().toLowerCase().contains(keyword)
                        || c.getLastName().toLowerCase().contains(keyword)) {
                    System.out.println(c);
                }
            }
        } else {
            for (InternCandidate c : internList) {
                if (c.getFirstName().toLowerCase().contains(keyword)
                        || c.getLastName().toLowerCase().contains(keyword)) {
                    System.out.println(c);
                }
            }
        }
    }

    // ====== Utils ======
    private boolean askContinue() {
        System.out.print("Do you want to continue (Y/N)? ");
        String s = sc.nextLine().trim();
        return s.equalsIgnoreCase("Y");
    }

    public void printAllByGroup() {
        System.out.println("\nList of candidate:");
        System.out.println("============EXPERIENCE CANDIDATE============");
        for (ExperienceCandidate c : experienceList) System.out.println(c.fullName());
        System.out.println("=============FRESHER CANDIDATE==============");
        for (FresherCandidate c : fresherList) System.out.println(c.fullName());
        System.out.println("==============INTERN CANDIDATE==============");
        for (InternCandidate c : internList) System.out.println(c.fullName());
    }

    // Struct nhỏ gọn để mang base info (tránh trùng biến)
    private static class CandidateInfo {
        String id, first, last, addr, phone, email;
        int year;
        CandidateInfo(String id, String first, String last, int year,
                      String addr, String phone, String email) {
            this.id=id; this.first=first; this.last=last; this.year=year;
            this.addr=addr; this.phone=phone; this.email=email;
        }
    }
}
