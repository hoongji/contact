package edu.java.contact05;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {
    public static void main(String[] args) {
        // Sample data for demonstration
        Object[][] data = {
                {1, "John Doe", "123-456-7890", "john@example.com"},
                {2, "Jane Smith", "987-654-3210", "jane@example.com"},
                {3, "Alice Johnson", "555-123-4567", "alice@example.com"}
        };
        
        // Column names
        String[] columns = {"번호", "이름", "전화번호", "이메일"};
        
        // Create a table model
        DefaultTableModel model = new DefaultTableModel(null, columns);

        // Create JTable with the model
        JTable table = new JTable(model);
        
        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Create and set up the frame
        JFrame frame = new JFrame("테이블 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add the scroll pane to the frame
        frame.add(scrollPane);
        
        // Set frame size and make it visible
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
