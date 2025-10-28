package model;

import validator.Validator;
import java.util.ArrayList;

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
    public void input(ArrayList<Course> list) {
        this.courseID = Validator.getCourseID(list, "Course ID: ");
        this.courseName = Validator.getCourseName(list, "Course name: ");
        this.credits = Validator.getCredits("Credits: ");
        this.platform = Validator.getString("Platform: ", true);
        this.instructors = Validator.getString("Instructors: ", false); // Not required to be non-empty
        this.note = Validator.getString("Note: ", true);
    }

    // Getters and Setters
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public String getInstructors() { return instructors; }
    public void setInstructors(String instructors) { this.instructors = instructors; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    
    @Override
    public String toString() {
        return super.toString() + String.format("-%s-%s-%s", platform, instructors, note);
    }
}