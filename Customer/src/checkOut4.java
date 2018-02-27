import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class checkOut4 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut4 window = new checkOut4();
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
	public checkOut4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourRewards = new JLabel("Enter your rewards No: ");
		lblEnterYourRewards.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterYourRewards.setBounds(82, 87, 216, 36);
		frame.getContentPane().add(lblEnterYourRewards);
		
		textField = new JTextField();
		textField.setBounds(295, 89, 263, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("View Rewards");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(220, 151, 178, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblYo = new JLabel("You have $$ as reward!");
		lblYo.setForeground(Color.BLUE);
		lblYo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblYo.setBounds(206, 194, 284, 65);
		frame.getContentPane().add(lblYo);
		
		JButton btnUseReward = new JButton("Use Reward");
		btnUseReward.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUseReward.setBounds(142, 272, 156, 47);
		frame.getContentPane().add(btnUseReward);
		
		JLabel lblRemainingAmountWill = new JLabel("If you use rewards and your rewards amount is less than your bill, ");
		lblRemainingAmountWill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemainingAmountWill.setBounds(107, 316, 533, 41);
		frame.getContentPane().add(lblRemainingAmountWill);
		
		JButton btnPayBy = new JButton("Pay by Card");
		btnPayBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPayBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPayBy.setBounds(344, 272, 156, 47);
		frame.getContentPane().add(btnPayBy);
		
		JLabel lblNewLabel = new JLabel("the remaining amount will be charged from your card!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(142, 349, 395, 26);
		frame.getContentPane().add(lblNewLabel);
	}

}
