package src.service;

import java.util.ArrayList;
import src.model.Student;

public class GradeService {

    public double calculateAverage(ArrayList<Student> students) {
        int total = 0;
        for (Student s : students) {
            total += s.getMarks();
        }
        return (double) total / students.size();
    }

    public int getHighest(ArrayList<Student> students) {
        int highest = students.get(0).getMarks();
        for (Student s : students) {
            if (s.getMarks() > highest) {
                highest = s.getMarks();
            }
        }
        return highest;
    }

    public int getLowest(ArrayList<Student> students) {
        int lowest = students.get(0).getMarks();
        for (Student s : students) {
            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
            }
        }
        return lowest;
    }
}