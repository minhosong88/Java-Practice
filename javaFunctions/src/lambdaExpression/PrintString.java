package lambdaExpression;
@FunctionalInterface
public interface PrintString {
    void showString(String str);

}

class StringTest{

    static PrintString returnString() { //반환값에 람다식 사용 가능.
        return s -> System.out.println(s + " \nGo to Work");
    } // 이 메서드를 사용하면 스트링 출력에 다른 문구가 추가된다.
    static void showMyString(PrintString lambda) {
        lambda.showString("Love you!");
    }
    public static void main(String[] args) {
        PrintString lambda = s -> System.out.println(s); //1. 변수에 람다식 사용
        lambda.showString("Wake up!");

        showMyString(lambda); // 2. 메서드(showMyString)의 매개변수로 람다식 사용.
        showMyString(s -> System.out.println(s)); // 2번과 같은 말이다. 메서드에 따라 Love you 반환.

        PrintString reStr = returnString(); //3.메서드의 반환 값으로 람다식 사용
        reStr.showString("Take a shower");
        // returnString의 정의에 따라 Take a shower 뒤에 go to work가 추가될 것.
    }

}


