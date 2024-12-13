package Lab8.prob1B;

import java.util.function.Supplier;

public class RandomNumberExample {
    public static void main(String[] args) {
        // Using method reference
        Supplier<Double> randomSupplier = Math::random;

        System.out.println("Random number: " + randomSupplier.get());
    }
}
