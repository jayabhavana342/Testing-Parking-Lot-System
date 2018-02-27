import parkinglot.controller.Controller;
import parkinglot.view.AddFrequentParkingLotUser;
import parkinglot.view.SearchFrequentParkingLotUser;

import java.awt.*;

public class ParkingLotMain {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                SearchFrequentParkingLotUser frame = new SearchFrequentParkingLotUser();
//                AddFrequentParkingLotUser frame2 = new AddFrequentParkingLotUser(frame);
                Controller controller = new Controller(frame);
                controller.contol();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
