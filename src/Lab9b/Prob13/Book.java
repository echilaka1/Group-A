
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Book {
	private List<BookCopy> copies = new ArrayList<BookCopy>();
	private String title;

	public Book(String title, int numCopies) {
		if (numCopies < 1)
			throw new IllegalArgumentException(
					"NumCopies must be positive");
		this.title = title;
		for (int i = 0; i < numCopies; ++i) {
			addCopy();
		}
	}

	public List<BookCopy> getCopies() {
		return copies;
	}

	public void addCopy() {
		BookCopy copy = new BookCopy(this, copies.size() + 1, true);
		copies.add(copy);
	}

	public boolean isAvailable() {
		// return this.copies.stream().anyMatch(BookCopy::isAvailable);
		return this.copies.stream().reduce(false, (x, y) -> x || y.isAvailable(), (a, b) -> a || b);
	}
}
