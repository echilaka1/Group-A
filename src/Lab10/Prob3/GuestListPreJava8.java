package lesson10.labs.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lesson10.labs.prob3.GuestListPreJava8.IllegalGuestException;

public class GuestListPreJava8 {

	public static void main(String[] args) {
		final boolean yes = true;
		final boolean no = false;
		GuestListPreJava8 gl = new GuestListPreJava8();
		List<Guest> invited = Arrays.asList(new Guest("Joe Stevens", Status.COMMON, Gender.M, 5, yes),
				new Guest("Susan Richards", Status.GOLD, Gender.F, 10, no),
				new Guest("Toni Smith", Status.COMMON, Gender.F, 4, yes),
				new Guest("Anthony Hawkins", Status.ILLEGAL, Gender.M, 0, yes),
				new Guest("Tony Thomas", Status.SILVER, Gender.M, 8, no),
				new Guest("Antoinette Cerisier", Status.SILVER, Gender.F, 7, yes),
				new Guest("Ricardo Salhuega", Status.COMMON, Gender.M, 2, yes));
		try {
			gl.printListOfExpectedFemaleGuests(invited);
		} catch (IllegalGuestException e) {
			e.printStackTrace();
		}
	}

	private boolean checkLegal(Guest g) throws IllegalGuestException {
		boolean isIllegal = (g.getStatus() == Status.ILLEGAL);
		if (isIllegal)
			throw new IllegalGuestException(String.format(
					"Illegal guest %s has attempted entry to the event", g.getName()));
		else
			return true;
	}

	public void printListOfExpectedFemaleGuests(List<Guest> invited) {
		try {
			String guests = invited.stream()
					// Filter out illegal guests by handling the exception
					.filter(g -> {
						try {
							return checkLegal(g);
						} catch (IllegalGuestException e) {
							throw new RuntimeException(e);
						}
					})
					// Filter only female guests who plan to come
					.filter(g -> g.getGender() == Gender.F && g.isPlanningToCome())
					// Map to guest names
					.map(Guest::getName)
					// Sort names alphabetically
					.sorted()
					// Collect to a comma-separated string
					.collect(Collectors.joining(", "));

			System.out.println(guests);
		} catch (RuntimeException e) {
			if (e.getCause() instanceof IllegalGuestException) {
				System.err.println(e.getCause().getMessage());
			} else {
				throw e; // Rethrow other runtime exceptions
			}
		}
	}

	class IllegalGuestException extends Exception {
		private static final long serialVersionUID = 1L;

		IllegalGuestException() {
			super("An illegal guest has attempted entry.");
		}

		IllegalGuestException(String msg) {
			super(msg);
		}

		IllegalGuestException(Throwable t) {
			super(t);
		}
	}
}
