package pattern.strategy;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        Order order = new Order("1","20187857576576",2113.23);

        order.pay(PayType.UNION_PAY);

        new ArrayList<Object>().sort(
                new Comparator<Object>(){
                    @Override
                    public int compare(Object o1, Object o2) {
                        return 0;
                    }
                }
        );

    }

}
