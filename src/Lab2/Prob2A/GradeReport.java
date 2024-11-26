package Lab2.Prob2A;

public class GradeReport implements Comparable<GradeReport> {
    private Student student;
    private String grade;

    GradeReport(Student stu) {
        student = stu;
    }
    public void setGrade(String g) {
        grade = g;
    }
    public Student getStudent() {
        return student;
    }
    public String getGrade() {
        return grade;
    }
    @Override
    public int compareTo(GradeReport o) {
        return grade.compareTo(o.grade);
    }

    @Override
    public String toString() {
        return grade;
    }
}
