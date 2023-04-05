package gradeCalculator.report;

import gradeCalculator.grade.BasicEvaluation;
import gradeCalculator.grade.GradeEvaluation;
import gradeCalculator.grade.MajorEvaluation;
import gradeCalculator.school.School;
import gradeCalculator.school.Score;
import gradeCalculator.school.Student;
import gradeCalculator.school.Subject;
import gradeCalculator.util.Define;

import java.util.ArrayList;

public class Report {
    School school = School.getInstance();
    public static final String TITLE = "Student Grade \t\t\n";
    public static final String HEADER = "NAME  | ID   | MAJOR  | POINT   \n";
    public static final String LINE = "------------------------------------\n";
    private StringBuffer stringBuffer = new StringBuffer();

    public String getReport() {
        ArrayList<Subject> subjectList = school.getSubjectList();
        for (Subject subject : subjectList) {
            makeHeader(subject);
            makeBody(subject);
            makeFooter();
        }
        return stringBuffer.toString();
    }

    public void makeHeader(Subject subject) {
        stringBuffer.append(School.SCHOOL_NAME + "\n");
        stringBuffer.append(Report.LINE);
        stringBuffer.append("\t" + subject.getSubjectName());
        stringBuffer.append(Report.TITLE);
        stringBuffer.append(Report.HEADER);
        stringBuffer.append(Report.LINE);
    }

    public void makeBody(Subject subject) {
        ArrayList<Student> studentList = subject.getStudentList();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            stringBuffer.append(student.getStudentName());
            stringBuffer.append(" | ");
            stringBuffer.append(student.getStudentID());
            stringBuffer.append(" | ");
            stringBuffer.append(student.getMajor().getSubjectName());
            //Student 타입을 불러서 Subject 타입의 변수를 가져오는 방법이 바로 이것.(major는 Subject type)
            stringBuffer.append(" | ");
            getScoreGrade(student, subject.getSubjectID());
            stringBuffer.append("\n");
            stringBuffer.append(LINE);
        }
    }

    public void getScoreGrade(Student student, int subjectID) {
        ArrayList<Score> scoreList = student.getScoreList();
        int majorID = student.getMajor().getSubjectID();
        GradeEvaluation[] gradeEvaluations = {new BasicEvaluation(), new MajorEvaluation()};

        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            if (score.getSubject().getSubjectID() == subjectID) {
                String grade;
                if (score.getSubject().getSubjectID() == majorID) {
                    grade = gradeEvaluations[Define.SAB_TYPE].getGrade(score.getPoint());
                } else grade = gradeEvaluations[Define.AB_TYPE].getGrade(score.getPoint());
                stringBuffer.append(score.getPoint());
                stringBuffer.append(":");
                stringBuffer.append(grade);
                stringBuffer.append("|");
            }
        }
    }

    public void makeFooter() {
        stringBuffer.append("\n");
    }
}
