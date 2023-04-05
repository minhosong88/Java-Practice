package coffeeMachine;

public class Latte extends Decorator{
    public Latte(Coffee coffee) { //Latte 객체가 생성되면 결과로 데코레이터의 Coffee 객체가 생성.
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing(); //생성된 coffee 인스턴스로 메서드를 돌리고 추가로 메세지 출력.
        System.out.println("Milk added.");
    }
}
