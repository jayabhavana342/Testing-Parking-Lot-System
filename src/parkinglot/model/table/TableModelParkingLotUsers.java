package parkinglot.model.table;

import parkinglot.model.FrequentParkingUser;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelParkingLotUsers extends AbstractTableModel {

    private static final int LAST_NAME_COL = 0;
    private static final int FIRST_NAME_COL = 1;
    private static final int EMAIL_COL = 2;
    private static final int ADDRESS_COL = 3;
    private static final int PHONE_COL = 4;
    private static final int LICENSE_ID_COL = 5;
    private static final int REWARDS_COL = 6;

    private String[] columnNames = {"Last Name", "First Name", "Email",
            "Address", "Phone No.", "License ID", "Rewards"};
    private List<FrequentParkingUser> frequentParkingUsers;

    public TableModelParkingLotUsers(List<FrequentParkingUser> frequentParkingUsers) {
        this.frequentParkingUsers = frequentParkingUsers;
    }

    @Override
    public int getRowCount() {
        return frequentParkingUsers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FrequentParkingUser tempfrequentParkingUser = frequentParkingUsers.get(rowIndex);

        switch (columnIndex) {
            case LAST_NAME_COL:
                return tempfrequentParkingUser.getLastName();
            case FIRST_NAME_COL:
                return tempfrequentParkingUser.getFirstName();
            case EMAIL_COL:
                return tempfrequentParkingUser.getEmail();
            case ADDRESS_COL:
                return tempfrequentParkingUser.getAddress();
            case PHONE_COL:
                return tempfrequentParkingUser.getPhone();
            case LICENSE_ID_COL:
                return tempfrequentParkingUser.getLicense_id();
            case REWARDS_COL:
                return tempfrequentParkingUser.getRewards();
            default:
                return tempfrequentParkingUser.getLastName();
        }
    }
}
