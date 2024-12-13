package prob4;

import java.util.stream.Stream;

public class PrimeStream {
    // part A
    private final Stream<Integer> primes = Stream.iterate(2, this::nextPrime);

    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        if (number <= 3)
            return true;
        if (number % 2 == 0 || number % 3 == 0)
            return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Helper method to find the next prime number
    private int nextPrime(int number) {
        int next = number + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    private void printFirstNPrimes(int n) {
        Stream<Integer> reusablePrimes = Stream.iterate(2, this::nextPrime);
        reusablePrimes.limit(n).forEach(System.out::println);
    }

    public static void main(String[] args) {
        // Part B:
        PrimeStream ps = new PrimeStream();
        ps.printFirstNPrimes(10);
        ps.printFirstNPrimes(5);

    }
}
