package coffeeMachine;

public class CoffeeMachineTest {
    public static void main(String[] args) {
        Coffee ethioEspresso = new EthiopianEspresso();


        Coffee ethioVanillaLatte = new WhippedCream(new Vanilla(new Latte(ethioEspresso)));
        ethioVanillaLatte.brewing();
        System.out.println("Vailla Latte is ready");
        System.out.println();
        System.out.println("박선하 고객님, 주문하신 바닐라 라테 나왔습니다.");
    }
}
