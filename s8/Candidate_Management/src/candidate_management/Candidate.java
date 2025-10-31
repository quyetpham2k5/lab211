/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package candidate_management;

public class Candidate {
    private String candidateId;
    private String firstName;
    private String lastName;
    private int birthYear;      // YYYY
    private String address;
    private String phone;
    private String email;
    private int candidateType;  // 0=Experience, 1=Fresher, 2=Intern

    public Candidate(String candidateId, String firstName, String lastName, int birthYear,
                     String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getCandidateId() { return candidateId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getBirthYear() { return birthYear; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public int getCandidateType() { return candidateType; }

    public void setCandidateId(String candidateId) { this.candidateId = candidateId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setCandidateType(int candidateType) { this.candidateType = candidateType; }

    public String fullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return String.format("%s | %d | %s | %s | %s | %d",
                fullName(), birthYear, address, phone, email, candidateType);
    }
}
