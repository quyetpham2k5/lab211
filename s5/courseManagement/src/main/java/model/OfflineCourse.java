package model;

import validator.Validator;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class OfflineCourse extends Course {
    private Date begin;
    private Date end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }
    
    @Override
    public void input(ArrayList<Course> list) {
        this.courseID = Validator.getCourseID(list, "Course ID: ");
        this.courseName = Validator.getCourseName(list, "Course name: ");
        this.credits = Validator.getCredits("Credits: ");
        this.begin = Validator.getFutureDate("Begin (dd/MM/yyyy): ");
        this.end = Validator.getEndDate("End (dd/MM/yyyy): ", this.begin);
        this.campus = Validator.getString("Campus: ", true);
    }

    // Getters and Setters
    public Date getBegin() { return begin; }
    public void setBegin(Date begin) { this.begin = begin; }
    public Date getEnd() { return end; }
    public void setEnd(Date end) { this.end = end; }
    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + String.format("-%s-%s-%s", sdf.format(begin), sdf.format(end), campus);
    }
}