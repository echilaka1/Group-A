package Lab2.Prob2A;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> listOfStudents = createStudents();
        assignGrades(listOfStudents, new String[]{"A", "B", "A", "C"});
        System.out.println("Students and their grades:\n  " + listOfStudents);

    }
    private static List<Student> createStudents() {
        Student studentOne = new Student("Emmanuel");
        Student studentTwo = new Student("Hossam");
        Student studentThree = new Student("Nonso");
        Student studentFour = new Student("Tunji");
        return Arrays.asList(studentOne, studentTwo, studentThree, studentFour);
    }
    private static void assignGrades(List<Student> list, String[] grades) {
        for(int i = 0; i < grades.length; ++i) {
            list.get(i).getReport().setGrade(grades[i]);
        }
    }
}
