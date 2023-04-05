package coffeeMachine;

public abstract class Decorator extends Coffee {

    Coffee coffee;

    public Decorator(Coffee coffee) { //Create a Decorator instance with a variable of Coffee type.
        this.coffee = coffee;
    }

    @Override
    public void brewing() {
        coffee.brewing();   //method is run by the instance of Coffee created by the Decorator constructor.
    }
}
