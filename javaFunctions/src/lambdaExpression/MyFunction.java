package lambdaExpression;
@FunctionalInterface
public interface MyFunction {
    void run();
}

class Execution{
    static void execution(MyFunction f) {
        f.run();
    }

    static MyFunction getMyFunction() {
//        MyFunction f = () -> System.out.println("f3.run");
//        return f;
        return () -> System.out.println("f3.run");
        //위에 복잡한 걸 한 줄로 줄이면 이렇게 된다.
    }

    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run");
        // void run() 과 비교를 하면, 반환타입도 없고(void), 매개변수도 없어서'()' 람다식으로 잘 표현됐음.

        MyFunction f2 = new MyFunction() { //익명클래스 복습
            @Override
            public void run() {
                System.out.println("f2.run");
            }
        };
        //MyFunction f3 = getMyFunction();
        MyFunction f3 = () -> System.out.println("f3.run");

        f1.run();
        f2.run();
        f3.run();
        execution(f1); //<=> execution(() -> System.out.println("f1.run"));
        execution(() -> System.out.println("run()"));
    }
}
