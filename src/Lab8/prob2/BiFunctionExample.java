package Lab8.prob2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
      BiFunction<Double, Double, List<Double>> newList =  (x, y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x,y));
            list.add(x * y);
            return list;
        };
        System.out.println("Print Exercise");
        System.out.println(newList.apply(2.0, 3.0));
    }
}
