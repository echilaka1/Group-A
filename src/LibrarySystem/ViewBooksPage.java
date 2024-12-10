package LibrarySystem;

import LibrarySystem.Business.BookFactory;
import LibrarySystem.Model.Book;
import LibrarySystem.Model.LibraryMember;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewBooksPage {

    private JPanel panel;
    private DefaultTableModel tableModel;
    private Book[] allBooks;


    public ViewBooksPage() {
        panel = new JPanel(new BorderLayout());

        // Create search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Submit");


        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.NORTH);


        // Create the table for book listing
        String[] columnNames = {"Title", "ISBN", "Authors", "No of Copies", "Max Checkout"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Add some dummy data
        addDummyBooks();

        JTable bookTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookTable);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                filterBooks(searchText);
            }
        });
        // Add search functionality
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                filterBooks(searchText);
            }
        });
    }

    private void addDummyBooks() {
        List<Book> books = BookFactory.getAllBooks();
            allBooks = books.toArray(new Book[0]);

            for (Book book : allBooks) {
                // Convert each Author object to a String array (each row is a String array)
                String[] row = new String[] {
                        book.getTitle(),
                        book.getIsbn(),
                        book.getAuthors().toString(),
                        String.valueOf(book.getCopies().size()),
                        String.valueOf(book.getMaxCheckoutLength()),
                };
                // Add the row to the table model
                tableModel.addRow(row);
            }
    }

    private void filterBooks(String searchText) {
        tableModel.setRowCount(0);

        if (searchText.isEmpty()) {
            for (Book book : allBooks) {
                addBookToTable(book);
            }
            return;
        }

        for (Book book : allBooks) {
            boolean matchesSearch = book.getTitle().toLowerCase().contains(searchText) ||
                    book.getIsbn().toLowerCase().contains(searchText) ||
                    book.getAuthors().toString().toLowerCase().contains(searchText) ||
                    String.valueOf(book.getCopies().size()).contains(searchText) ||
                    String.valueOf(book.getMaxCheckoutLength()).contains(searchText);

            if (matchesSearch) {
                addBookToTable(book);
            }
        }
    }

    private void addBookToTable(Book book) {
        String[] row = new String[] {
                book.getTitle(),
                book.getIsbn(),
                book.getAuthors().toString(),
                String.valueOf(book.getCopies().size()),
                String.valueOf(book.getMaxCheckoutLength())
        };
        tableModel.addRow(row);
    }


    public JPanel getPanel() {
        return panel;
    }
}
