import java.util.stream.IntStream;

public class Main {
    public static void printSquares(int num) {
        IntStream.iterate(1, x -> x + 1).limit(num).forEach(y -> System.out.println(y * y));

    }

    public static void main(String[] args) {
        printSquares(4);
    }
}
