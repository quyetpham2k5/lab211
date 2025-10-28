package view;

import controller.CourseManager;
import java.util.Scanner;

public class Menu extends Menu1 {

    private final CourseManager manager;

    public Menu(String td, String[] mc, Scanner sc) {
        super(td, mc, sc);
        this.manager = new CourseManager();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                manager.addCourse();
                break;
            case 2:
                manager.updateCourse();
                break;
            case 3:
                manager.deleteCourse();
                break;
            case 4:
                manager.printCourses();
                break;
            case 5:
                manager.searchCourse();
                break;
            case 6:
                System.out.println("BYE AND SEE YOU NEXT TIME!");
                System.exit(0);
        }
    }
}