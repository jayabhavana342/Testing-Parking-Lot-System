import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkOut3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut3 window = new checkOut3();
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
	public checkOut3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPaymentSuccessful = new JLabel("Payment Successful!!");
		lblPaymentSuccessful.setForeground(Color.BLUE);
		lblPaymentSuccessful.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentSuccessful.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblPaymentSuccessful.setBounds(149, 41, 275, 61);
		frame.getContentPane().add(lblPaymentSuccessful);
		
		JLabel lblIfYouAre = new JLabel("If you are a frequent parker, enter your rewards number below!");
		lblIfYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouAre.setBounds(99, 139, 399, 37);
		frame.getContentPane().add(lblIfYouAre);
		
		JLabel lblPhoneNo = new JLabel("Phone No: ");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNo.setBounds(135, 189, 107, 37);
		frame.getContentPane().add(lblPhoneNo);
		
		textField = new JTextField();
		textField.setBounds(259, 189, 219, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Rewards");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(210, 256, 141, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print Receipt");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(169, 380, 225, 49);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Rewards added successfully!");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(176, 323, 235, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(286, 340, 56, 16);
		frame.getContentPane().add(label);
	}

}
