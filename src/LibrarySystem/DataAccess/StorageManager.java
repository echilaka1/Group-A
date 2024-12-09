package LibrarySystem.DataAccess;

import java.util.Map;

import LibrarySystem.Model.Author;
import LibrarySystem.Model.Book;
import LibrarySystem.Model.CheckoutRecord;
import LibrarySystem.Model.LibraryMember;

public interface StorageManager {
	public Map<String, Author> readAuthorsFromStorage();
	public void saveAuthorsToStorage(Map<String, Author> authors);
	public Map<String, Book> readBooksFromStorage();
	public void saveBooksToStorage(Map<String, Book> books);
	public Map<Integer, CheckoutRecord> readCheckoutRecordsFromStorage();
	public void saveCheckoutRecordsToStorage(Map<Integer, CheckoutRecord> checkoutRecords);
	public Map<Integer, LibraryMember> readMembersFromStorage();
	public void saveMembersToStorage(Map<Integer, LibraryMember> members);
}
