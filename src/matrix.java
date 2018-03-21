import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class matrix {
    private JPanel panel1;

    public static void main(String[] args) {
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();

        JFrame frame = new JFrame("matrix example");

        JPanel panel1 = new JPanel();
        int rows = 9, cols = 10;
        panel1.setLayout(new GridLayout(rows, cols));

        int counter_for_slots = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(i + ":" + j + "");
            }
            System.out.println();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label;
                if (i == 0 && j == 1) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/start.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createLineBorder(Color.black));
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createLineBorder(Color.black));
                } else if ((i == 2 && (j == 1 || j == 5)) || (i == 5 && (j == 1 || j == 5))) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/arrow_right.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createLoweredBevelBorder());
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createLoweredBevelBorder());
                } else if ((i == 3 && (j == 4 || j == 8)) || (i == 6 && (j == 4 || j == 8))) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/arrow_left.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createLoweredBevelBorder());
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createLoweredBevelBorder());
                } else if ((j == 3 && (i == 1 || i == 4)) || (j == 7 && (i == 1 || i == 4))) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/arrow_down.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createLoweredBevelBorder());
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createLoweredBevelBorder());
                } else if ((j == 2 && (i == 4 || i == 7)) || (j == 6 && (i == 4 || i == 7))) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/arrow_up.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createLoweredBevelBorder());
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createLoweredBevelBorder());
                } else if (((i != 0 && i != rows - 1) && j == 1) ||
                        (i == 1 && (j != 0 && j != cols - 1)) ||
                        (i == rows - 2 && (j != 0 && j != cols - 1)) ||
                        (j == cols - 2 && (i != 0 && i != rows - 1)) ||
                        (i == 4 && (j != 0 && j != cols - 1)) ||
                        (j == 4 && (i != 0 && i != rows - 1)) ||
                        (j == 5 && (i != 0 && i != rows - 1))) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/red_dot.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createRaisedBevelBorder());
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createRaisedBevelBorder());
                } else if (i != 0 && i != rows - 1 && j != 0 && j != cols - 1) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/vac_a.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    label = new JLabel("<html><font color='white'>Lot: " + Integer.toString(counter_for_slots) + "</font></html>");
                    counter_for_slots++;
                    label.setIcon(imageIcon);
                    label.setHorizontalTextPosition(JLabel.CENTER);
                    label.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
                } else if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/road.jpg").getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT));
                    label = new JLabel();
                    label.setIcon(imageIcon);
                    label.setBorder(BorderFactory.createLineBorder(Color.black));
                    panel1.add(label);
                    panel1.setBorder(BorderFactory.createLineBorder(Color.black));
                } else {
                    label = new JLabel();
                    label.setText(i + ":" + j);
                    panel1.add(label);
                }

//                label = new JLabel();
//                label.setText(i + ":" + j);
//                panel1.add(label);
            }
        }

        frame = new JFrame("test");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
