package genericMethodPractice;

public class GenericMethod {

    public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) {
        //T와 V는 변수의 타입인데, 미리 정한 것이 아니라 Generic 타입이라고 하고, 사용할 때 입력해서 사용하면 된다.
        double left = ((Number)p1.getX()).doubleValue(); // 타입이 안 정해져 있지만 가장 상위의 Number를 넣는다. (int, double 모두를 포함)
        double right = ((Number) p2.getX()).doubleValue();
        double top = ((Number) p1.getY()).doubleValue();
        double bottom = ((Number)p1.getY()).doubleValue();

        double width = right - left;
        double height = top - bottom;

        return width*height;
    }
    public static void main(String[] args) {
        Point<Integer, Double> p1 = new Point<>(0, 10.0); // 일부러 두 다른 타입을 넣어본 듯.
        Point<Integer, Double> p2 = new Point<>(10,0.0 );
        Integer width = p2.getX()-p1.getX();
        Double height = p1.getY()-p2.getY();
        System.out.println(p2.getX()-p1.getX());
        System.out.println(p1.getY()-p2.getY());
        System.out.println(width*height);
        double rect = GenericMethod.makeRectangle(p1, p2);
        System.out.println(rect);
    }
}
