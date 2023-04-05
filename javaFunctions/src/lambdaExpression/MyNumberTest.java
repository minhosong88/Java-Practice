package lambdaExpression;

public class MyNumberTest {
    public static void main(String[] args) {
        MyNumber max = (x, y) -> (x>=y)? x:y;
        System.out.println(max.getMax(30, 50));

    }
}
