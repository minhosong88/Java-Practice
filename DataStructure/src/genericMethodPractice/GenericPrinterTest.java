package genericMethodPractice;

public class GenericPrinterTest {
    public static void main(String[] args) {
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>(); //GenericPrinter with Powder class that extends Material.
        powderPrinter.setMaterial(new Powder()); // setMateiral() with an instance created in Powder class.
        //an instance, powderPrinter has elements of Powder class(toString Override, doPrinting())
        Powder powder = powderPrinter.getMaterial();
        //However it has gotten the elements, the instance powder is a type of Powder class
        powderPrinter.printing(); // powderPrinter is a GeneticPrinter type instance so it uses all the methods in the class.// the result is the same thou.
        powder.doPrinting(); //powder can only use the methods from Powder class.
        System.out.println(powderPrinter); //toString() 재정의 in Powder class.

        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
        plasticPrinter.setMaterial(new Plastic());
        Plastic plastic = plasticPrinter.getMaterial();
        plasticPrinter.printing();
        plastic.doPrinting();
        System.out.println(plasticPrinter);

    }
}
