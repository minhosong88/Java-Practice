package logging;

public class Student {
    private String studentName;
    MyLogger mylogger = MyLogger.getLogger(); //singleton pattern. Mylogger 타입의 변수는 getLogger로 받는다.

    public Student(String studentName) {
        if (studentName == null) {
            throw new StudentNameFormatException("name cannot be null");
        }
        if (studentName.split(" ").length > 3) {
            throw new StudentNameFormatException("name is too long");
        }
        this.studentName = studentName; //조건에 맞으면 생성시에 입력한 매개변수 String 값이 멤버변수 값이 된다.
    }

    public String getStudentName() {
        mylogger.fine("begin getStudentName()");
        return studentName;
    }
}
