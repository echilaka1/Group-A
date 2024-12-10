package LibrarySystem;

import LibrarySystem.Business.LibraryMemberFactory;
import LibrarySystem.Model.Author;
import LibrarySystem.Model.LibraryMember;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ManageMembersPage {

    private JPanel panel;
    private DefaultTableModel tableModel;

    private LibraryMember[] dummyMembers;

    public ManageMembersPage() {
        panel = new JPanel(new BorderLayout());

        // Create search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(20);
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Create the table for book listing
        String[] columnNames = {"Member ID", "First Name", "Last Name", "Street","City","State","Zip", "Phone"};
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
        List<LibraryMember> members = LibraryMemberFactory.getAllMembers();
        dummyMembers = members.toArray(new LibraryMember[0]);

        for (LibraryMember member : dummyMembers) {
            // Convert each Author object to a String array (each row is a String array)
            String[] row = new String[] {
                    String.valueOf(member.getMemberId()),
                    member.getFirstName(),
                    member.getLastName(),
                    member.getAddress().getStreet(),
                    member.getAddress().getCity(),
                    member.getAddress().getState(),
                    member.getAddress().getZip(),
                    member.getPhone()
            };
            // Add the row to the table model
            tableModel.addRow(row);
        }
    }

    private void filterBooks(String searchText) {
        // Clear the table model to reset the table
        tableModel.setRowCount(0);

        // If search text is empty, reload all members
        if (searchText.isEmpty()) {
            for (LibraryMember member : dummyMembers) {
                addMemberToTable(member);
            }
            return;
        }

        // Filter members based on the search text
        for (LibraryMember member : dummyMembers) {
            boolean matchesSearch = member.getFirstName().toLowerCase().contains(searchText) ||
                    member.getLastName().toLowerCase().contains(searchText) ||
                    member.getAddress().getStreet().toLowerCase().contains(searchText) ||
                    member.getAddress().getCity().toLowerCase().contains(searchText) ||
                    member.getAddress().getState().toLowerCase().contains(searchText) ||
                    member.getAddress().getZip().contains(searchText) ||
                    member.getPhone().contains(searchText);

            if (matchesSearch) {
                addMemberToTable(member);
            }
        }
    }

    // Helper method to add a library member to the table
    private void addMemberToTable(LibraryMember member) {
        String[] row = new String[] {
                String.valueOf(member.getMemberId()),
                member.getFirstName(),
                member.getLastName(),
                member.getAddress().getStreet(),
                member.getAddress().getCity(),
                member.getAddress().getState(),
                member.getAddress().getZip(),
                member.getPhone()
        };
        tableModel.addRow(row);
    }


    public JPanel getPanel() {
        return panel;
    }
}
