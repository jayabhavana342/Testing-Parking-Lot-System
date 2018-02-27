import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkOut2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut2 window = new checkOut2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public checkOut2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVehicleNo = new JLabel("VEHICLE TYPE:");
		lblVehicleNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVehicleNo.setBounds(101, 139, 147, 37);
		frame.getContentPane().add(lblVehicleNo);
		
		textField = new JTextField();
		textField.setBounds(259, 79, 241, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("VEHICLE NO:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(101, 77, 118, 37);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 139, 241, 37);
		frame.getContentPane().add(textField_1);
		
		JLabel lblTimeOfEntry = new JLabel("TIME OF ENTRY:");
		lblTimeOfEntry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeOfEntry.setBounds(101, 202, 147, 37);
		frame.getContentPane().add(lblTimeOfEntry);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 202, 241, 37);
		frame.getContentPane().add(textField_2);
		
		JLabel lblTimeOfExit = new JLabel("TIME OF EXIT:");
		lblTimeOfExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeOfExit.setBounds(101, 265, 147, 37);
		frame.getContentPane().add(lblTimeOfExit);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(259, 265, 241, 37);
		frame.getContentPane().add(textField_3);
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm");
		textField_3.setText(dateFormat.format(cal.getTime()));
		
		JLabel lblYourTotalBill = new JLabel("YOUR TOTAL DUE IS ");
		lblYourTotalBill.setForeground(Color.RED);
		lblYourTotalBill.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourTotalBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourTotalBill.setBounds(79, 327, 379, 37);
		frame.getContentPane().add(lblYourTotalBill);
		
		JLabel lblNewLabel = new JLabel("PARKING DETAILS");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(125, 13, 362, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnPay = new JButton("PAY WITH CARD");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPay.setBounds(61, 377, 187, 42);
		frame.getContentPane().add(btnPay);
		
		JButton btnPayWithReward = new JButton("PAY WITH REWARD POINTS");
		btnPayWithReward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPayWithReward.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPayWithReward.setBounds(282, 377, 261, 42);
		frame.getContentPane().add(btnPayWithReward);
	}

}
