/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package candidate_management;

public class ExperienceCandidate extends Candidate {
    private int expInYear;      // 0..100
    private String proSkill;

    public ExperienceCandidate(String candidateId, String firstName, String lastName, int birthYear,
                               String address, String phone, String email,
                               int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() { return expInYear; }
    public String getProSkill() { return proSkill; }
    public void setExpInYear(int expInYear) { this.expInYear = expInYear; }
    public void setProSkill(String proSkill) { this.proSkill = proSkill; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | ExpYear=%d | ProSkill=%s", expInYear, proSkill);
    }
}
