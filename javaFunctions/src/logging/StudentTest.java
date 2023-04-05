package logging;

public class StudentTest {
    public static void main(String[] args) {
        MyLogger mylogger = MyLogger.getLogger();
        String name = null;

        try {
            Student student = new Student(name);
        } catch (StudentNameFormatException e) {
            mylogger.warning(e.getMessage());
        }
        try {
            Student student = new Student("Edward jon Kim Test");
        } catch (StudentNameFormatException e) {
            mylogger.warning(e.getMessage());

        }
        Student student = new Student ("James");
        String sName = student.getStudentName();
    }
}
