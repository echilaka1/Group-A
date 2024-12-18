import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyClass {

    public static void main(String[] args) {

        // Ansewr for "A"
        IntStream ones = IntStream.generate(() -> 1)
                // need to limit the stream creation because distincit will be working in
                // inifinite loop after creating infinite stram
                .limit(10)
                .distinct();
        ones.forEach(System.out::println);

        // Answer for "B"
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        System.out.println(stringStream.collect(Collectors.joining(", ")));

        // Answer for "C"
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Min: " + stats.getMin() + ", Max: " + stats.getMax());
    }
}
