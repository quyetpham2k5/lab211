package model;

import java.util.ArrayList;

public abstract class Course {
    protected String courseID;
    protected String courseName;
    protected int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    public Course(String courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }
    

    public abstract void input(ArrayList<Course> list);

    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public String getCourseName() {
        return courseName; 
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName; 
    }
    public int getCredits() { 
        return credits; 
    }
    public void setCredits(int credits) {
        this.credits = credits; 
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%d", courseID, courseName, credits);
    }
}
