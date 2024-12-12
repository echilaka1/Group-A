package LibrarySystem;

import LibrarySystem.Business.CheckoutRecordFactory;
import LibrarySystem.Business.LibraryMemberFactory;
import LibrarySystem.Model.CheckoutEntry;
import LibrarySystem.Model.CheckoutRecord;
import LibrarySystem.Model.LibraryMember;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ViewCheckedOutBooksPage {

    private JPanel panel;
    private DefaultTableModel tableModel;

    public ViewCheckedOutBooksPage() {
        panel = new JPanel(new BorderLayout());

        // Create search panel
        JPanel searchPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel = new JPanel(new GridLayout(2, 1, 0, 0));

        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(20);
        inputPanel.add(searchLabel);
        inputPanel.add(searchField);

        JLabel helpText = new JLabel("search by ISBN, book title or Member id only");
        helpText.setFont(new Font(helpText.getFont().getName(), Font.ITALIC, 10));
        helpText.setForeground(Color.GRAY);

        leftPanel.add(inputPanel);
        leftPanel.add(helpText);

        JButton printButton = new JButton("Print to console");
        printButton.setPreferredSize(new Dimension(160, 25));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonPanel.add(printButton);

        searchPanel.add(leftPanel, BorderLayout.WEST);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        panel.add(searchPanel, BorderLayout.NORTH);
        // Create the table for book listing
        String[] columnNames = { "ISBN", "Book Title", "Checkout Date", "Due Date", "Is Overdue", "Member ID" };
        tableModel = new DefaultTableModel(columnNames, 0);

        loadCheckoutRecords();

        JTable bookTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookTable);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Add search functionality
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                filterBooks(searchText);
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // print the table to console
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    System.out.println(
                            "ISBN: " + tableModel.getValueAt(i, 0) + "Book Title: " + tableModel.getValueAt(i, 1) +
                                    ", Checkout Date: " + tableModel.getValueAt(i, 2) +
                                    ", Due Date: " + tableModel.getValueAt(i, 3) +
                                    ", Is Overdue: " + tableModel.getValueAt(i, 4) +
                                    ", Member ID: " + tableModel.getValueAt(i, 5));
                }
            }
        });
    }

    private void loadCheckoutRecords() {
        Map<Integer, CheckoutRecord> records = CheckoutRecordFactory.getAllCheckoutRecords();
        for (Map.Entry<Integer, CheckoutRecord> entry : records.entrySet()) {
            for (CheckoutEntry checkoutEntry : entry.getValue().getCheckoutEntries()) {
                String[] row = new String[] {
                        checkoutEntry.getBookCopy().getBook().getIsbn(),
                        checkoutEntry.getBookCopy().getBook().getTitle(),
                        checkoutEntry.getCheckoutDate().toString(),
                        checkoutEntry.getDueDate().toString(),
                        String.valueOf(checkoutEntry.isOverdue(new Date())),
                        String.valueOf(entry.getKey().toString())
                };
                tableModel.addRow(row);
            }
        }
    }

    private void filterBooks(String searchText) {
        if (searchText.isEmpty()) {
            tableModel.setRowCount(0);
            loadCheckoutRecords();
            return;
        }

        List<String[]> filteredRows = new ArrayList<>();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String isbn = tableModel.getValueAt(i, 0).toString().toLowerCase();
            String bookTitle = tableModel.getValueAt(i, 1).toString().toLowerCase();
            String memberId = tableModel.getValueAt(i, 5).toString().toLowerCase();

            if (memberId.contains(searchText) || isbn.contains(searchText) || bookTitle.contains(searchText)) {
                filteredRows.add(new String[] {
                        tableModel.getValueAt(i, 0).toString(),
                        tableModel.getValueAt(i, 1).toString(),
                        tableModel.getValueAt(i, 2).toString(),
                        tableModel.getValueAt(i, 3).toString(),
                        tableModel.getValueAt(i, 4).toString(),
                        tableModel.getValueAt(i, 5).toString()
                });
            }
        }

        tableModel.setRowCount(0);

        for (String[] row : filteredRows) {
            tableModel.addRow(row);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
