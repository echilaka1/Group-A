import java.util.List;

public class Main13 {

    public static void main(String[] args) {
        Book b = new Book("Java", 3);
        List<BookCopy> copies = b.getCopies();
        copies.forEach(c -> c.changeAvailability());

        System.out.println(b.isAvailable());
    }

}
