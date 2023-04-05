package gradeCalculator.test;

import gradeCalculator.report.Report;
import gradeCalculator.school.School;
import gradeCalculator.school.Score;
import gradeCalculator.school.Student;
import gradeCalculator.school.Subject;
import gradeCalculator.util.Define;

public class GradeCalcTest {

    School goodSchool = School.getInstance();
    Subject korean;
    Subject math;

    Report report = new Report();
    public void createSubject() {
        korean = new Subject(Define.KOREAN, "Korean");
        math = new Subject(Define.MATH, "Math");

        goodSchool.addSubject(korean);
        goodSchool.addSubject(math);
        //과목을 생성해서 학교에 등록
    }

    public void createStudent() {
        Student kim = new Student(230124, "KIM", korean);
        Student lee = new Student(230125, "LEE", math);
        Student park = new Student(230126, "PARK", korean);
        Student song = new Student(230127, "SONG", math);
        Student lim = new Student(230128, "LIM", korean);
        Student hong = new Student(230129, "HONG", math);

        goodSchool.addStudent(kim);
        goodSchool.addStudent(lee);
        goodSchool.addStudent(park);
        goodSchool.addStudent(song);
        goodSchool.addStudent(lim);
        goodSchool.addStudent(hong);

        korean.register(kim);
        korean.register(lee);
        korean.register(park);
        korean.register(song);
        korean.register(lim);
        korean.register(hong);

        math.register(kim);
        math.register(lee);
        math.register(park);
        math.register(song);
        math.register(lim);
        math.register(hong);

        addStudentScore(kim, korean, 90);
        addStudentScore(kim, math, 75);

        addStudentScore(lee, korean, 80);
        addStudentScore(lee, math, 95);

        addStudentScore(park, korean, 60);
        addStudentScore(park, math, 90);

        addStudentScore(song, korean, 100);
        addStudentScore(song, math, 100);

        addStudentScore(lim, korean, 78);
        addStudentScore(lim, math, 88);

        addStudentScore(hong, korean, 80);
        addStudentScore(hong, math, 79);


    }

    public void addStudentScore(Student student, Subject subject, int point) {
        Score score = new Score(student.getStudentID(), subject, point);
        student.addScore(score);

    }

    public static void main(String[] args) {
        GradeCalcTest test = new GradeCalcTest();

        test.createSubject(); //과목부터 먼저 등록되어야 학생들을 과목에 등록시킬 수가 있음.
        test.createStudent();

        String report = test.report.getReport();
        System.out.println(report);

    }


}
