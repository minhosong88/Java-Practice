package streamFunction;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareStrings implements BinaryOperator<String>{

    @Override
    public String apply(String s1, String s2) {
        if (s1.getBytes().length > s2.getBytes().length){
            return s1;
        }
        else return s2;
    }
}

public class ReduceTest {
    public static void main(String[] args) {
        //같은 결과를 다른 방식을 사용해서 구현해본다.
        String[] stringArray = {"Hello", "안녕하세요", "moshi moshi", "반갑습니다."};
        System.out.println(Arrays.stream(stringArray).reduce("", (s1, s2)->
        {if(s1.getBytes().length>s2.getBytes().length) return s1; else return s2;}));
        //BinaryOperator의 apply()메서드 없이 람다식으로 구현.

        String str = Arrays.stream(stringArray). reduce(new CompareStrings()).get();
        //reduce에서 CompareStrings() 생성하면, apply가 호출되면서 비교 시작.//reduce로 return 값을 가져온다.
        System.out.println(str);

    }
}
