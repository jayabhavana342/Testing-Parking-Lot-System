import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class checkOut1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField DATE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut1 window = new checkOut1();
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
	public checkOut1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCheckOut = new JLabel("CHECK OUT");
		lblCheckOut.setBounds(0, 0, 756, 44);
		lblCheckOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckOut.setForeground(Color.ORANGE);
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 36));
		frame.getContentPane().add(lblCheckOut);
		
		JLabel lblCreditdebitCardNo = new JLabel("CREDIT/DEBIT CARD NO:");
		lblCreditdebitCardNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCreditdebitCardNo.setBounds(32, 184, 259, 52);
		frame.getContentPane().add(lblCreditdebitCardNo);
		
		textField = new JTextField();
		textField.setBounds(274, 261, 335, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setHorizontalAlignment(SwingConstants.CENTER);
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCvv.setBounds(32, 249, 259, 52);
		frame.getContentPane().add(lblCvv);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(274, 196, 335, 33);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNameOnCard = new JLabel("NAME ON CARD:");
		lblNameOnCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameOnCard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameOnCard.setBounds(32, 314, 259, 52);
		frame.getContentPane().add(lblNameOnCard);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(274, 326, 335, 33);
		frame.getContentPane().add(textField_2);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setBounds(244, 409, 154, 33);
		frame.getContentPane().add(btnSubmit);
		
		DATE = new JTextField();
		DATE.setFont(new Font("Tahoma", Font.BOLD, 16));
		DATE.setBounds(314, 101, 193, 33);
		frame.getContentPane().add(DATE);
		DATE.setColumns(10);
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm");
		DATE.setText(dateFormat.format(cal.getTime()));
		
		JLabel lblCurrentTime = new JLabel("CURRENT TIME: ");
		lblCurrentTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrentTime.setBounds(158, 101, 144, 33);
		frame.getContentPane().add(lblCurrentTime);
	}
}
