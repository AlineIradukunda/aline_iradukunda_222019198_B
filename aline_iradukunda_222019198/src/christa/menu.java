package christa;

import javax.swing.*;

import aaaaaaaaa.customerform;
import bbbbbbb.employeeform;
import cccccccccc.menuform;
import ddddddd.Orderform;
import eeeee.Reservationform;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem customerItem;
    private JMenuItem employeeItem;
    private JMenuItem menuItem;
    private JMenuItem OrderItem;
    private JMenuItem ReservationItem;
    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;

    public menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        customerItem = new JMenuItem("customer");
        customerItem.addActionListener(this);
        employeeItem = new JMenuItem("employee");
        employeeItem.addActionListener(this);
        menuItem = new JMenuItem("menu");
        menuItem.addActionListener(this);
        OrderItem = new JMenuItem("Order");
        OrderItem.addActionListener(this);
        ReservationItem = new JMenuItem("Reservation");
        ReservationItem.addActionListener(this);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(customerItem);
        homeMenu.add( employeeItem);
        homeMenu.add(menuItem);
        homeMenu.add(OrderItem);
        homeMenu.add(ReservationItem);
        homeMenu.addSeparator();
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerItem) {
            JOptionPane.showMessageDialog(this, "Opening customer Form...");
            new customerform();
        } else if (e.getSource() == employeeItem) {
            JOptionPane.showMessageDialog(this, "Opening employee Form...");
            new employeeform();
        } else if (e.getSource() == menuItem) {
            JOptionPane.showMessageDialog(this, "Opening menu Form...");
            new menuform();
        } else if (e.getSource() == OrderItem) {
            JOptionPane.showMessageDialog(this, "Opening Order Form...");
            new Orderform();
        } else if (e.getSource() == ReservationItem) {
            JOptionPane.showMessageDialog(this, "Opening Reservation Form...");
            new Reservationform();
        } else if (e.getSource() == settingsItem) {
            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menu("aline_iradukunda_r_m_s"));
    }
}


