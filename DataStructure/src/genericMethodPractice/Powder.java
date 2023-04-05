package genericMethodPractice;

public class Powder extends Material{
    @Override
    public String toString() {
        return "This is a Powder Printer.";
    }

    @Override
    public void doPrinting() {
        System.out.println("Print in Powder Material.");
    }
}
