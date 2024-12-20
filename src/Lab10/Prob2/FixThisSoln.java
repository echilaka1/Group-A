package lesson10.labs.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixThisSoln {
	// Exception class
	static class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;

		public InputTooLongException() {
			super("Must be length 3 or less");
		}

		public InputTooLongException(String s) {
			super(s);
		}

		public InputTooLongException(Throwable t) {
			super(t);
		}
	}

	// Method to process the list with exception handling
	List<String> processList(List<String> list) {
		return list.stream()
				.map(x -> {
					try {
						return doNothingIfShort(x); // Handle exception here
					} catch (InputTooLongException e) {
						throw new RuntimeException(e); // Wrap into unchecked exception
					}
				})
				.collect(Collectors.toList());
	}

	// Original method with a checked exception
	String doNothingIfShort(String input) throws InputTooLongException {
		if (input.length() > 3)
			throw new InputTooLongException();
		else
			return input;
	}

	// Main method to test the solution
	public static void main(String[] args) {
		FixThisSoln ft = new FixThisSoln();

		// Test case 1: List with valid inputs
		List<String> words1 = Arrays.asList("not", "too", "big", "yet");
		System.out.println(ft.processList(words1)); // Output: [not, too, big, yet]

		// Test case 2: List with an input that is too long
		List<String> words2 = Arrays.asList("this", "is", "too", "long");
		try {
			System.out.println(ft.processList(words2)); // Expected: RuntimeException
		} catch (RuntimeException e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
}
