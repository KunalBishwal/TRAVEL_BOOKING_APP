package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {
    String username;
    Conn conn; // Database connection instance

    public static void main(String[] args) {
        new Home("").setVisible(true);
    }

    public Home(String username) {
        super("Travel and Tourism Management System");
        this.username = username;
        conn = new Conn(); // Initialize the database connection

        setForeground(Color.CYAN);
        setLayout(null);

        // Load and scale the background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/resources/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);

        // Title label
        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 55));
        l1.setBounds(500, 60, 1000, 100);
        NewLabel.add(l1);

        // Menu bar setup
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Customer Menu
        JMenu m1 = new JMenu("CUSTOMER");
        m1.setForeground(Color.BLUE);
        menuBar.add(m1);

        JMenuItem mi1 = new JMenuItem("ADD CUSTOMER");
        m1.add(mi1);
        JMenuItem mi2 = new JMenuItem("UPDATE CUSTOMER DETAIL");
        m1.add(mi2);
        JMenuItem mi3 = new JMenuItem("VIEW CUSTOMER DETAILS");
        m1.add(mi3);
        JMenuItem mi4 = new JMenuItem("DELETE CUSTOMER DETAILS");
        m1.add(mi4);

        mi1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddCustomer(username).setVisible(true);
                } catch (Exception e) {}
            }
        });

        mi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new UpdateCustomer(username).setVisible(true);
                } catch (Exception e) {}
            }
        });

        mi3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new ViewCustomers().setVisible(true);
                } catch (Exception e) {}
            }
        });

        mi4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new DeleteCustomer().setVisible(true);
                } catch (Exception e) {}
            }
        });

        // Packages Menu
        JMenu m2 = new JMenu("PACKAGES");
        m2.setForeground(Color.RED);
        menuBar.add(m2);

        JMenuItem mi5 = new JMenuItem("VIEW PACKAGE");
        m2.add(mi5);
        JMenuItem mi6 = new JMenuItem("CHECK PACKAGE");
        m2.add(mi6);
        JMenuItem mi7 = new JMenuItem("BOOK PACKAGE");
        m2.add(mi7);

        mi5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new ViewPackage(username).setVisible(true);
                } catch (Exception e) {}
            }
        });

        mi6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new CheckPackage().setVisible(true);
                } catch (Exception e) {}
            }
        });

        mi7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new BookPackage(username).setVisible(true);
                } catch (Exception e) {}
            }
        });

        // Tickets Menu
        JMenu m3 = new JMenu("TICKETS");
        m3.setForeground(Color.BLUE);
        menuBar.add(m3);

        JMenuItem mi8 = new JMenuItem("BOOK TICKET");
        m3.add(mi8);
        JMenuItem mi9 = new JMenuItem("VIEW TICKETS");
        m3.add(mi9);

        mi8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new BookTicket(username).setVisible(true); // Replace with actual BookTicket class
                } catch (Exception e) {}
            }
        });

        mi9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new ViewTicket(username).setVisible(true); // Replace with actual ViewTicket class
                } catch (Exception e) {}
            }
        });

        // Hotels Menu
        JMenu m4 = new JMenu("HOTELS");
        m4.setForeground(Color.RED);
        menuBar.add(m4);

        JMenuItem mi10 = new JMenuItem("BOOK HOTELS");
        m4.add(mi10);
        JMenuItem mi11 = new JMenuItem("VIEW HOTELS");
        m4.add(mi11);
        JMenuItem mi12 = new JMenuItem("VIEW BOOKED HOTEL");
        m4.add(mi12);

        mi10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new BookHotel(username).setVisible(true);
            }
        });

        mi11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new CheckHotels().setVisible(true);
                } catch (Exception e) {}
            }
        });

        mi12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new ViewBookedHotel(username).setVisible(true);
                } catch (Exception e) {}
            }
        });

        // Destination Menu
        JMenu m5 = new JMenu("DESTINATION");
        m5.setForeground(Color.RED);
        menuBar.add(m5);

        JMenuItem mi13 = new JMenuItem("DESTINATION");
        m5.add(mi13);
        mi13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Destination().setVisible(true);
            }
        });

        // Payment Menu
        JMenu m6 = new JMenu("PAYMENT");
        m6.setForeground(Color.BLUE);
        menuBar.add(m6);

        JMenuItem mi14 = new JMenuItem("PAY USING GPAY");
        m6.add(mi14);
        mi14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Payment().setVisible(true);
            }
        });

        // Utility Menu
        JMenu m7 = new JMenu("UTILITY");
        m7.setForeground(Color.RED);
        menuBar.add(m7);

        JMenuItem mi15 = new JMenuItem("NOTEPAD");
        m7.add(mi15);
        JMenuItem mi16 = new JMenuItem("CALCULATOR");
        m7.add(mi16);

        mi15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                } catch (Exception e) {}
            }
        });

        mi16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (Exception e) {}
            }
        });

        // About Menu
        JMenu m8 = new JMenu("ABOUT");
        m8.setForeground(Color.BLUE);
        menuBar.add(m8);

        JMenuItem mi17 = new JMenuItem("ABOUT");
        m8.add(mi17);
        mi17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new About().setVisible(true);
            }
        });

        // Frame settings
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
