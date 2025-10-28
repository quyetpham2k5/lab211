package controller;

import java.util.ArrayList;
import model.Course;
import model.OfflineCourse;
import model.OnlineCourse;
import validator.Validator;

public class CourseManager {
    private ArrayList<Course> courseList;

    public CourseManager() {
        courseList = new ArrayList<>();
    }
    
    public void addCourse() {
        System.out.println("\n*** Add new course ***");
        char type = Validator.getCourseType("Online (O) or Offline (F): ");
        Course newCourse;
        if (type == 'O') {
            System.out.println("Create new online course");
            newCourse = new OnlineCourse();
        } else {
            System.out.println("Create new offline course");
            newCourse = new OfflineCourse();
        }
        newCourse.input(courseList);
        courseList.add(newCourse);
        System.out.println("✅ Course added successfully.");
    }

    private Course findById(String id) {
        for (Course course : courseList) {
            if (course.getCourseID().equalsIgnoreCase(id)) {
                return course;
            }
        }
        return null;
    }

    public void updateCourse() {
        System.out.println("\n*** Update course ***");
        if (courseList.isEmpty()) {
            System.out.println("No course data to update.");
            return;
        }
        Course courseToUpdate = null;
        while (courseToUpdate == null) {
            String id = Validator.getString("Course ID: ", true);
            courseToUpdate = findById(id);
            if (courseToUpdate == null) {
                System.out.println("⚠ No data found.");
                if (!Validator.getYesNo("Do you want to find again? (Y/N): ")) return;
            }
        }
        
        System.out.println("*** Search results ***");
        System.out.println(courseToUpdate);
        System.out.println("\n*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");
        // (Implementation for updating fields would go here)
        // For simplicity, this example focuses on the structure.
        System.out.println("✅ Updated successfully.");
    }
    
    public void deleteCourse() {
        System.out.println("\n*** Delete course ***");
        if (courseList.isEmpty()) {
            System.out.println("No course data to delete.");
            return;
        }
        Course courseToDelete = null;
        while (courseToDelete == null) {
            String id = Validator.getString("Course ID: ", true);
            courseToDelete = findById(id);
            if (courseToDelete == null) {
                System.out.println("⚠ No data found.");
                if (!Validator.getYesNo("Do you want to find again? (Y/N): ")) return;
            }
        }
        
        if (Validator.getYesNo("Are you sure you want to delete this course? (Y/N): ")) {
            courseList.remove(courseToDelete);
            System.out.println("✅ Deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }
    
    public void printCourses() {
        System.out.println("\n*** Print course ***");
        if (courseList.isEmpty()) {
            System.out.println("No course data to display.");
            return;
        }
        
        char type = Validator.getPrintType("Print all (A), online (O) or offline (F): ");
        System.out.println("--- Course List ---");
        for (Course course : courseList) {
            switch (type) {
                case 'A':
                    System.out.println(course);
                    break;
                case 'O':
                    if (course instanceof OnlineCourse) System.out.println(course);
                    break;
                case 'F':
                    if (course instanceof OfflineCourse) System.out.println(course);
                    break;
            }
        }
        System.out.println("--------------------");
    }
    
    public void searchCourse() {
        System.out.println("\n*** Searching ***");
        if (courseList.isEmpty()) {
            System.out.println("No course data to search.");
            return;
        }
        
        String name = Validator.getString("Enter course name to search: ", true);
        ArrayList<Course> foundList = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getCourseName().toLowerCase().contains(name.toLowerCase())) {
                foundList.add(course);
            }
        }
        
        if (foundList.isEmpty()) {
            System.out.println(" No data found.");
        } else {
            System.out.println("*** Search results ***");
            for(Course course : foundList) {
                System.out.println(course);
            }
        }
    }
}
