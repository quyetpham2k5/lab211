/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package candidate_management;

public class FresherCandidate extends Candidate {
    private String graduationDate;  // ví dụ: 2023-06 hoặc 2023
    private String graduationRank;  // Excellence/Good/Fair/Poor
    private String education;       // University

    public FresherCandidate(String candidateId, String firstName, String lastName, int birthYear,
                            String address, String phone, String email,
                            String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() { return graduationDate; }
    public String getGraduationRank() { return graduationRank; }
    public String getEducation() { return education; }

    public void setGraduationDate(String graduationDate) { this.graduationDate = graduationDate; }
    public void setGraduationRank(String graduationRank) { this.graduationRank = graduationRank; }
    public void setEducation(String education) { this.education = education; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | GradDate=%s | Rank=%s | Edu=%s",
                graduationDate, graduationRank, education);
    }
}

