package parkinglot.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import parkinglot.controller.Controller;

public class AddFrequentParkingLotUser extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JTextField phoneTextField;
    private JTextField licenseTextField;
    private JTextField rewardsTextField;

    private JButton okButton;
    private JButton cancelButton;

    private SearchFrequentParkingLotUser searchFrequentParkingLotUser;


    public AddFrequentParkingLotUser(SearchFrequentParkingLotUser searchFrequentParkingLotUser) {
        this.searchFrequentParkingLotUser = searchFrequentParkingLotUser;
        setTitle("Add Frequent Parker");
        setBounds(100, 100, 500, 280);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        contentPanel.setLayout(new FormLayout(new ColumnSpec[]{
                FormFactory.RELATED_GAP_COLSPEC,
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
                new RowSpec[]{
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                }));

        JLabel lblFirstName = new JLabel("First Name");
        contentPanel.add(lblFirstName, "2, 2, right, default");
        firstNameTextField = new JTextField();
        contentPanel.add(firstNameTextField, "4, 2, fill, default");
        firstNameTextField.setColumns(10);

        JLabel lblLastName = new JLabel("Last Name");
        contentPanel.add(lblLastName, "2, 4, right, default");
        lastNameTextField = new JTextField();
        contentPanel.add(lastNameTextField, "4, 4, fill, default");
        lastNameTextField.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        contentPanel.add(lblEmail, "2, 6, right, default");
        emailTextField = new JTextField();
        contentPanel.add(emailTextField, "4, 6, fill, default");
        emailTextField.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        contentPanel.add(lblAddress, "2, 8, right, default");
        addressTextField = new JTextField();
        contentPanel.add(addressTextField, "4, 8, fill, default");
        addressTextField.setColumns(10);

        JLabel lblPhone = new JLabel("Phone");
        contentPanel.add(lblPhone, "2, 10, right, default");
        phoneTextField = new JTextField();
        contentPanel.add(phoneTextField, "4, 10, fill, default");
        phoneTextField.setColumns(10);

        JLabel lblLicense = new JLabel("License ID");
        contentPanel.add(lblLicense, "2, 12, right, default");
        licenseTextField = new JTextField();
        contentPanel.add(licenseTextField, "4, 12, fill, default");
        licenseTextField.setColumns(10);

        JLabel lblRewards = new JLabel("Rewards");
        contentPanel.add(lblRewards, "2, 14, right, default");
        rewardsTextField = new JTextField();
        contentPanel.add(rewardsTextField, "4, 14, fill, default");
        rewardsTextField.setColumns(10);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        okButton = new JButton("Save");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller(searchFrequentParkingLotUser);
                controller.saveFrequentParkingUser();
            }
        });
        okButton.setActionCommand("OK");        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public JTextField getPhoneTextField() {
        return phoneTextField;
    }

    public JTextField getLicenseTextField() {
        return licenseTextField;
    }

    public JTextField getRewardsTextField() {
        return rewardsTextField;
    }
}
