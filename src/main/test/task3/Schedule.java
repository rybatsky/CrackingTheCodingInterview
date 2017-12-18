package test.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//Task 3. O(n)
public class Schedule {

    public static ArrayList<Course> schedule(ArrayList<Course> courses) {
        ArrayList<Course> maxNumber = new ArrayList<>();
        int end = 0;
        Collections.sort(courses);
        Iterator<Course> it = courses.iterator();
        while (it.hasNext()) {
            Course currentCourse = it.next();
            int begin = currentCourse.getBeginning();
            if (begin > end) {
                maxNumber.add(currentCourse);
                end = currentCourse.getEnding();
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(1, 10));
        courses.add(new Course(2, 15));
        courses.add(new Course(3, 4));
        courses.add(new Course(11, 30));
        courses.add(new Course(15, 20));
        courses.add(new Course(9, 12));
        courses.add(new Course(5, 28));

        System.out.println(schedule(courses));
    }
}
