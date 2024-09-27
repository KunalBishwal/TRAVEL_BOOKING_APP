package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewTicket extends Frame implements ActionListener {
    // Declare components
    Label customerIdLabel, customerNameLabel;
    TextField customerIdField, customerNameField;
    Button fetchButton;
    Conn conn;

    public ViewTicket() {
        // Establish the connection
        conn = new Conn();

        // Frame setup
        Frame frame = new Frame("View Ticket");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Customer ID
        customerIdLabel = new Label("Customer ID:");
        customerIdField = new TextField(20);
        frame.add(customerIdLabel);
        frame.add(customerIdField);

        // Customer Name
        customerNameLabel = new Label("Customer Name:");
        customerNameField = new TextField(20);
        customerNameField.setEditable(false);
        frame.add(customerNameLabel);
        frame.add(customerNameField);

        // Fetch Button
        fetchButton = new Button("Fetch");
        fetchButton.addActionListener(this);
        frame.add(fetchButton);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String customerId = customerIdField.getText();

        try {
            // Fetch customer details from the customer table
            String query = "SELECT name FROM customer WHERE id = ?";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String customerName = rs.getString("name");
                customerNameField.setText(customerName);
            } else {
                System.out.println("Customer not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewTicket();
    }
}
