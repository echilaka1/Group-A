package Lab9.prob6;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
    public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
        if (m < 0 || n < 0 || n < m) {
            throw new IllegalArgumentException("Invalid range: m and n must satisfy 0 <= m <= n.");
        }
        // Split from m to n (inclusive)
        return stream.skip(m).limit(n - m + 1); // Add +1 to make the range inclusive
    }

    // Support method for the main method -- for testing
    private static Stream<String> nextStream() {
        return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
    }

    public static void main(String[] args) {
        System.out.println(streamSection(nextStream(), 0, 3).collect(Collectors.joining(", "))); // Outputs: aaa, bbb,
                                                                                                 // ccc, ddd
        System.out.println(streamSection(nextStream(), 2, 5).collect(Collectors.joining(", "))); // Outputs: ccc, ddd,
                                                                                                 // eee, fff
        System.out.println(streamSection(nextStream(), 7, 8).collect(Collectors.joining(", "))); // Outputs: hhh, iii

    }

}
