package LibrarySystem.Business;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import LibrarySystem.DataAccess.DataAccessFacade;
import LibrarySystem.DataAccess.StorageManager;
import LibrarySystem.Model.Author;

public class AuthorFactory {

    public static String addAuthor(Author author) {
    	if (author == null) {
            throw new IllegalArgumentException("Author cannot be null.");
        }
    	
    	StorageManager manager = new DataAccessFacade();
    	Map<String, Author> authorMap = manager.readAuthorsFromStorage();
        
        String uniqueKey = author.getFirstName() + " " + author.getLastName();
        
        boolean exists = authorMap.keySet().stream()
                .anyMatch(key -> key.equals(uniqueKey));

        if (exists) {
        	return "Author already exists: " + uniqueKey;
        } else {
            authorMap.put(uniqueKey, author);
            manager.saveAuthorsToStorage(authorMap);
            return "Author added successfully: " + uniqueKey;
        }
    }

    public static List<Author> getAllAuthors() {
    	StorageManager manager = new DataAccessFacade();
    	Map<String, Author> authorMap = manager.readAuthorsFromStorage();
    	 
         return authorMap.values().stream()
                 .collect(Collectors.toUnmodifiableList());
    }

    public static Author findAuthorByName(String firstName, String lastName) {
    	StorageManager manager = new DataAccessFacade();
    	Map<String, Author> authorMap = manager.readAuthorsFromStorage();
        String uniqueKey = firstName + " " + lastName;
        
        return authorMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(uniqueKey))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
    }
}
