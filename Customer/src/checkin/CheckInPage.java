package checkin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckInPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInPage window = new CheckInPage();
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
	public CheckInPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(230, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PARK YOUR VEHICLE");
		lblNewLabel.setBounds(184, 0, 600, 27);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCheckIn = new JButton("CHECK IN");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
			}
		});
		btnCheckIn.setBounds(6, 70, 138, 29);
		btnCheckIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(btnCheckIn);
		
		JPanel panel = new JPanel();
		panel.setBounds(96, 138, -45, -2);
		frame.getContentPane().add(panel);
		
		//JPanel panel_1 = new JPanel();
		//Make global variable
		panel_1 = new JPanel();
		panel_1.setVisible(false);
		
		panel_1.setBounds(6, 111, 550, 361);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(167, 16, 297, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CREDIT/DEBIT CARD NO:");
		lblNewLabel_1.setBounds(6, 24, 161, 16);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 61, 297, 33);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCvw = new JLabel("CVV:");
		lblCvw.setBounds(66, 69, 61, 16);
		panel_1.add(lblCvw);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 115, 297, 33);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNameOnCard = new JLabel("NAME ON CARD:");
		lblNameOnCard.setBounds(6, 123, 155, 16);
		panel_1.add(lblNameOnCard);
		
		JLabel lblNewLabel_2 = new JLabel("It is valid card");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(167, 160, 198, 16);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 188, 130, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblVehicleNo = new JLabel("VEHICLE NO:");
		lblVehicleNo.setBounds(43, 193, 88, 16);
		panel_1.add(lblVehicleNo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 211, 130, 26);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblVehicleType = new JLabel("VEHICLE TYPE:");
		lblVehicleType.setBounds(41, 221, 114, 16);
		panel_1.add(lblVehicleType);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(122, 277, 69, 29);
		panel_1.add(btnOk);
	}

}
