package LibrarySystem.Business;

import java.util.Map;

import LibrarySystem.DataAccess.DataAccessFacade;
import LibrarySystem.DataAccess.StorageManager;
import LibrarySystem.Model.Auth;
import LibrarySystem.Model.User;

public class UserFactory {

    public static void createTestUsers() {
        Map<String, User> users = Map.of(
                "1", new User("Joe", "111", Auth.LIBRARIAN),
                "2", new User("Ann", "101", Auth.ADMIN),
                "3", new User("Dave", "102", Auth.BOTH),
                "4", new User("emannuel", "123", Auth.BOTH),
                "5", new User("hossam", "123", Auth.BOTH));

        StorageManager manager = new DataAccessFacade();
        manager.saveUserToStorage(users);
        System.out.println("test users created");
    }

    public static User login(String username, String password) {
        StorageManager manager = new DataAccessFacade();
        Map<String, User> usersMap = manager.readUsersFromStorage();
        // search for the username with password in the user map
        for (User user : usersMap.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}
