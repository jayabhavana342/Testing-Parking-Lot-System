package parkinglot.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class SearchFrequentParkingLotUser extends JFrame {
    private JPanel contentPane;
    private JTextField lastNameTextField;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table = new JTable();
    private JPanel panel = new JPanel();

    private JPanel panel_1;
    private JButton btnAddFrequentParkingUser;

    public SearchFrequentParkingLotUser() {

        setTitle("FrequentParker Search App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblEnterLastName = new JLabel("Enter last name");
        panel.add(lblEnterLastName);

        lastNameTextField = new JTextField();
        panel.add(lastNameTextField);
        lastNameTextField.setColumns(10);

        btnSearch = new JButton("Search");
        panel.add(btnSearch);

        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        scrollPane.setViewportView(table);

        panel_1 = new JPanel();
        contentPane.add(panel_1,BorderLayout.SOUTH);

        btnAddFrequentParkingUser = new JButton("Add Frequent Parker");

        panel_1.add(btnAddFrequentParkingUser);

    }

    public JButton getButton(){
        return btnSearch;
    }

    public JPanel getPanel(){
        return panel;
    }

    public JTable getTable(){
        return table;
    }

    public JTextField getlastNameTextField(){
        return lastNameTextField;
    }

    public JPanel getPanel_1() {
        return panel_1;
    }

    public JButton getBtnAddFrequentParkingUser() {
        return btnAddFrequentParkingUser;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
