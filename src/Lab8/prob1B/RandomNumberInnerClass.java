package Lab8.prob1B;

import java.util.function.Supplier;

public class RandomNumberInnerClass {
    // Inner class implementing Supplier
    static class RandomSupplier implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
    }
    public static void main(String[] args) {
        // Using the inner class
        Supplier<Double> randomSupplier = new RandomSupplier();

        System.out.println("Random number: " + randomSupplier.get());
    }
}
