package streamFunction;

public class Customer {
    private String customerName;
    private int age;
    private int status;
    private int price;

    public Customer(String name, int age) {
        this.customerName = name;
        this.age = age;
        this.status = PriceTable.NORMAL;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Customer customer) {
        this.price = customer.calcPrice(customer);
    }

    public int calcPrice(Customer customer) {
        int price;
        if (customer.getAge() < 8) {
            price = PriceTable.CHILD;
        }
        else if (customer.getAge() >= 65) {
            price = PriceTable.SENIOR;
        }
        else if (customer.getStatus() != 0 && (customer.getAge() > 7 && customer.getAge() < 65)) {
            customer.status = PriceTable.SPECIAL;
            price = PriceTable.HANDICAPPED;
        } else {
            price = PriceTable.ADULT;
        }
        return price;
    }


    public void showAll() {
        System.out.println("Name: " + customerName +"."+" Age: " + age + "."+" Price: "+ price);
    }

    @Override
    public String toString() {
        return "Name: " + customerName +"."+" Age: " + age + "."+" Price: " + price;
    }
}
