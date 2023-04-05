package genericMethodPractice;

public class Plastic extends Material{

    @Override
    public String toString() {
        return "This is a plastic printer";
    }

    @Override
    public void doPrinting() {
        System.out.println("Print in Plastic Material.");
    }
}
