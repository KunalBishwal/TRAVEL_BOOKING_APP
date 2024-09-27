package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookTicket extends Frame implements ActionListener {
    // Declare components
    TextField customerIdField, customerNameField, customerEmailField; // Add other fields as needed
    Button submitButton;
    Conn conn; // Class for MySQL connection

    public BookTicket() {
        // Initialize connection
        conn = new Conn();
        
        // Set up the frame
        Frame frame = new Frame("Book Ticket");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        
        // Customer ID
        Label customerIdLabel = new Label("Customer ID:");
        customerIdField = new TextField(20);
        frame.add(customerIdLabel);
        frame.add(customerIdField);
        
        // Customer Name
        Label customerNameLabel = new Label("Customer Name:");
        customerNameField = new TextField(20);
        frame.add(customerNameLabel);
        frame.add(customerNameField);

        // Customer Email
        Label customerEmailLabel = new Label("Customer Email:");
        customerEmailField = new TextField(20);
        frame.add(customerEmailLabel);
        frame.add(customerEmailField);
        
        // Submit Button
        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        frame.add(submitButton);
        
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String customerId = customerIdField.getText();
        String customerName = customerNameField.getText();
        String customerEmail = customerEmailField.getText();

        try {
            // Insert into tickets table
            String query = "INSERT INTO tickets (customer_id, customer_name, customer_email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, customerId);
            pstmt.setString(2, customerName);
            pstmt.setString(3, customerEmail);
            pstmt.executeUpdate();
            
            // Show confirmation or perform additional actions
            System.out.println("Ticket booked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BookTicket();
    }
}
