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
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(20);
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Create the table for book listing
        String[] columnNames = {"Book Title", "Checkout Date", "Due Date", "Is Overdue"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Add some dummy data
        addDummyMembers();

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
    }

    private void addDummyMembers() {
        Map<Integer, CheckoutRecord> records = CheckoutRecordFactory.getAllCheckoutRecords();
        for (CheckoutRecord record : records.values()) {
            for (CheckoutEntry entry : record.getCheckoutEntries()) {
                String[] row = new String[] {
                        entry.getBookCopy().getBook().getTitle(),
                        entry.getCheckoutDate().toString(),
                        entry.getDueDate().toString(),
                        String.valueOf(entry.isOverdue(new Date()))
                };
                tableModel.addRow(row);
            }
        }
    }


    private void filterBooks(String searchText) {
        if (searchText.isEmpty()) {
            tableModel.setRowCount(0);
            addDummyMembers();
            return;
        }

        List<String[]> filteredRows = new ArrayList<>();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String bookTitle = tableModel.getValueAt(i, 0).toString().toLowerCase();
            String checkoutDate = tableModel.getValueAt(i, 1).toString().toLowerCase();
            String dueDate = tableModel.getValueAt(i, 2).toString().toLowerCase();
            String isOverdue = tableModel.getValueAt(i, 3).toString().toLowerCase();

            if (bookTitle.contains(searchText) || checkoutDate.contains(searchText) ||
                    dueDate.contains(searchText) || isOverdue.contains(searchText)) {
                filteredRows.add(new String[]{
                        tableModel.getValueAt(i, 0).toString(),
                        tableModel.getValueAt(i, 1).toString(),
                        tableModel.getValueAt(i, 2).toString(),
                        tableModel.getValueAt(i, 3).toString()
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
