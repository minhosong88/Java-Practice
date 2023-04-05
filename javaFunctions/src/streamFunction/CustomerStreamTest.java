package streamFunction;

import java.util.ArrayList;
import java.util.List;

public class CustomerStreamTest {
    public static void main(String[] args) {
        Customer lee = new Customer("Lee", 25);
        Customer kim = new Customer("Kim", 7 );
        Customer park = new Customer("Park", 67);
        Customer kang = new Customer("Kang", 70);
        Customer han = new Customer("Han", 18);
        Customer song = new Customer("Song", 34);
        Customer lim = new Customer("Lim", 24);

        han.setStatus(1);
        lim.setStatus(1);
/*        lee.setPrice(lee);
        kim.setPrice(kim);
        park.setPrice(park);
        kang.setPrice(kang);
        han.setPrice(han);
        song.setPrice(song);
        lim.setPrice(lim);*/ // 스트림 기능을 통해 한 번에 setPrice 가능하다.

        List<Customer> customerList = new ArrayList<>();
        customerList.add(lee);
        customerList.add(kim);
        customerList.add(park);
        customerList.add(kang);
        customerList.add(han);
        customerList.add(song);
        customerList.add(lim);

        System.out.println(customerList);
        System.out.println();

        customerList.stream().forEach(s->s.setPrice(s)); //스트림 기능을 통한 배열의 각 요소에 대해 setPrice 실행.

        System.out.println("List of Customers:");
        customerList.stream().forEach(s-> System.out.println(s));
        System.out.println();
        System.out.println("List of Customers whose age >=8");
        customerList.stream().filter(s->s.getAge() >=8).map(c-> c.getCustomerName()).forEach(s-> System.out.println(s));
        //filter나 map의 반환값은 Stream이므로 String이나 int로 바꾸려면 mapToInt나 mapToString 기능 사용해야함.
        System.out.println();
        System.out.println("List of Customers who need special helps:");
        customerList.stream().filter(s->s.getStatus() == PriceTable.SPECIAL).map(c->c.getCustomerName()).forEach(s-> System.out.println(s));

        int total = customerList.stream().mapToInt(c-> c.getPrice()).sum();
        int sCount = (int)customerList.stream().filter(s->s.getStatus() == PriceTable.SPECIAL).count();
        int cCount = (int)customerList.stream().filter(s->s.getPrice() == PriceTable.CHILD).count();
        //Stream의 count()는 long을 반환하므로, int로 강제전환
        System.out.println("total price: " + total+"원.");
        System.out.println("# of special guest: " + sCount+"명.");
        System.out.println("# of children: "+ cCount+"명.");
     }
}
