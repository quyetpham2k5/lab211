/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package candidate_management;

public class InternCandidate extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public InternCandidate(String candidateId, String firstName, String lastName, int birthYear,
                           String address, String phone, String email,
                           String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() { return majors; }
    public String getSemester() { return semester; }
    public String getUniversityName() { return universityName; }

    public void setMajors(String majors) { this.majors = majors; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Majors=%s | Semester=%s | University=%s",
                majors, semester, universityName);
    }
}
