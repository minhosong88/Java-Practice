package gradeCalculator.school;

import gradeCalculator.util.Define;

import java.util.ArrayList;

public class Subject {
    private int subjectID;
    private String subjectName;

    private int gradeType;

    public Subject(int subjectID, String subjectName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.gradeType = Define.AB_TYPE;
    }

    ArrayList<Student> studentList = new ArrayList<>();

    public void register(Student student) {
        studentList.add(student);
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
