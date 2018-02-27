package parkinglot.controller;

import parkinglot.view.AddFrequentParkingLotUser;
import parkinglot.view.SearchFrequentParkingLotUser;
import parkinglot.model.dao.FrequentParkingUserDAO;
import parkinglot.model.table.TableModelParkingLotUsers;
import parkinglot.model.FrequentParkingUser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static com.sun.glass.ui.Cursor.setVisible;

public class Controller {

    private SearchFrequentParkingLotUser view;
    private AddFrequentParkingLotUser view2;

    private ActionListener actionListener;
    private ActionListener actionListenerbtnAddFrequentParker;
    private ActionListener actionListenerokButton;

    AddFrequentParkingLotUser dialog = new AddFrequentParkingLotUser(view);

    FrequentParkingUserDAO frequentParkingUserDAO = null;


    public Controller(SearchFrequentParkingLotUser view) {
        this.view = view;
    }


    public void contol() {
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                linkBtnAndLabel();
            }
        };
        view.getBtnSearch().addActionListener(actionListener);

        actionListenerbtnAddFrequentParker = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        };
        view.getBtnAddFrequentParkingUser().addActionListener(actionListenerbtnAddFrequentParker);

    }

    private void linkBtnAndLabel() {

        try {
            frequentParkingUserDAO = new FrequentParkingUserDAO();
        } catch (Exception exc) {
            System.out.println("test");
            JOptionPane.showMessageDialog(view.getPanel(), "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            String lastName = view.getLastNameTextField().getText();

            List<FrequentParkingUser> frequentParkers;

            if (lastName != null && lastName.trim().length() > 0) {
                assert frequentParkingUserDAO != null;
                frequentParkers = frequentParkingUserDAO.searchFrequentParkingUsers(lastName);
            } else {
                assert frequentParkingUserDAO != null;
                frequentParkers = frequentParkingUserDAO.getAllFrequentParkingUsers();
            }

            // create the model and update the "table"
            TableModelParkingLotUsers model = new TableModelParkingLotUsers(frequentParkers);

            view.getTable().setModel(model);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(view, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveFrequentParkingUser() {
        String firstName = view2.getFirstNameTextField().getText();
        String lastName = view2.getLastNameTextField().getText();
        String email = view2.getEmailTextField().getText();
        String address = view2.getAddressTextField().getText();
        int phone = convertStringToInt(view2.getPhoneTextField().getText());
        String license_id = view2.getLicenseTextField().getText();
        int rewards = convertStringToInt(view2.getRewardsTextField().getText());

        FrequentParkingUser tempfrequentParkingUser = new FrequentParkingUser(lastName,
                firstName, email, address, phone, license_id, rewards);

        try {
            // save to the database
            frequentParkingUserDAO.addFrequentParkingUser(tempfrequentParkingUser);

            // close dialog
            setVisible(false);
            dispose();

            // refresh gui list
            refreshFrequentParkingUsersView();

            // show success message
            JOptionPane.showMessageDialog(view,
                    "Employee added succesfully.",
                    "Employee Added",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(
                    view,
                    "Error saving employee: "
                            + exc.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void refreshFrequentParkingUsersView() {

        try {
            List<FrequentParkingUser> frequentParkingUsers = frequentParkingUserDAO.getAllFrequentParkingUsers();

            TableModelParkingLotUsers model = new TableModelParkingLotUsers(frequentParkingUsers);

            view.getTable().setModel(model);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(view, "Error: " + exc, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private int convertStringToInt(String string) {
        int result = 0;

        try {
            result = Integer.parseInt(string);
        } catch (Exception exc) {
            System.out.println("Invalid value. Defaulting to 0");
            result = 0;
        }

        return result;
    }
}
