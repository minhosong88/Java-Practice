package coffeeMachine;

public class Vanilla extends Decorator{
    public Vanilla(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("Vanilla Syrup added");
    }
}
