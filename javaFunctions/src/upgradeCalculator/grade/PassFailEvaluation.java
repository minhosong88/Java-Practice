package upgradeCalculator.grade;

public class PassFailEvaluation implements GradeEvaluation{
    @Override
    public String getGrade(int point) {
        String grade;
        if (point >= 70 && point <= 100) {
            grade = "P";
        } else {
            grade = "F";
        }
        return grade;
    }
}
