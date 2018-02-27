import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class checkOut5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut5 window = new checkOut5();
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
	public checkOut5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Payment Successful!!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		label.setBounds(187, 61, 275, 61);
		frame.getContentPane().add(label);
		
		JLabel lblYourRewardPoints = new JLabel("Your reward points for this visit is added to your account!");
		lblYourRewardPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYourRewardPoints.setBounds(110, 157, 469, 47);
		frame.getContentPane().add(lblYourRewardPoints);
		
		JLabel lblThankYou = new JLabel("Thank you!!");
		lblThankYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThankYou.setBounds(233, 217, 195, 41);
		frame.getContentPane().add(lblThankYou);
		
		JButton button = new JButton("Print Receipt");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(188, 347, 225, 49);
		frame.getContentPane().add(button);
	}

}
