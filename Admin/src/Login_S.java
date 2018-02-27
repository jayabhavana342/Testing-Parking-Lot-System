
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class Login_S {

    private JFrame frame;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login_S window = new Login_S();
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
    public Login_S() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Parking Lot System");
        lblNewLabel.setBounds(191, 13, 145, 22);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(56, 87, 69, 16);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(56, 142, 69, 16);
        frame.getContentPane().add(lblPassword);

        txtUsername = new JTextField();
        txtUsername.setBounds(206, 84, 186, 22);
        frame.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(206, 139, 186, 22);
        frame.getContentPane().add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String password =txtPassword.getText();
                String username =txtUsername.getText();
                if (password.contains("admin")&& username.contains("admin")) {
                    JOptionPane.showMessageDialog(frame,"You're sucessfully Loggedin");
                    //create object
                    RegistrationForm Reg =new RegistrationForm();
                    Reg.setVisible(true);

                }

                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login","Login Error", JOptionPane.ERROR_MESSAGE);
                    txtPassword.setText(null);
                    txtUsername.setText(null);
                }
            }
        });
        btnLogin.setBounds(101, 193, 97, 25);
        frame.getContentPane().add(btnLogin);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                txtUsername.setText(null);
                txtPassword.setText(null);
            }
        });
        btnReset.setBounds(296, 193, 97, 25);
        frame.getContentPane().add(btnReset);
    }
}

