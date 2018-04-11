import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

class plus extends JFrame {
    int radius = 10, i = 0, x, y, x1, y1, x2, y2;
    double dis;
    int[] a = new int[100];
    int[] b = new int[100];

    JPanel panel2 = new JPanel();
    JButton B1 = new JButton("Enter Nodes");
    JButton B2 = new JButton("Draw Edges");
    JButton B3 = new JButton("Start Node");
    JButton B4 = new JButton("End Node");
    JButton B5 = new JButton("Run");
    JButton B6 = new JButton("Clear");
    JButton button[] = new JButton[100];
    JInternalFrame jInternalFrame1 = new JInternalFrame();

    public plus() {
        setTitle("Shortest Path Finding");
        setSize(700, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = getContentPane();
        contentPane.add(jInternalFrame1, "Center");
        contentPane.add(panel2, "South");
        jInternalFrame1.setVisible(true);
        jInternalFrame1.setBackground(Color.white);
        panel2.add(B1);
        panel2.add(B2);
        panel2.add(B3);
        panel2.add(B4);
        panel2.add(B5);
        panel2.add(B6);
        B1.addActionListener(new B1Listener());
        B2.addActionListener(new B2Listener());
        /*B3.addActionListener(new B3Listener());
        B4.addActionListener(new B4Listener());
        B5.addActionListener(new B5Listener());*/
        B6.addActionListener(new B6Listener());
    }

    class drawedge {
        public void de() {
            jInternalFrame1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent event) {
                    jInternalFrame1MousePressed(event);
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent event) {
                    jInternalFrame1MouseReleased(event);
                }
            });
        }

        public void jInternalFrame1MousePressed(MouseEvent e) {
            for (int l = 0; l < i; l++) {
                if (e.getX() == a[l] && e.getY() == b[l]) {
                    x1 = a[l];
                    y1 = b[l];
                    break;
                }
            }
            x1 = e.getX();
            y1 = e.getY();
        }

        public void jInternalFrame1MouseReleased(MouseEvent e) {
            for (int m = 0; m < i; m++) {
                if (e.getX() == a[m] && e.getY() == b[m]) {
                    x2 = a[m];
                    y2 = b[m];
                    x2 = e.getX();
                    y2 = e.getY();
                    Graphics g = getGraphics();
                    g.drawLine(x1 - 10, y1 + 20, x2 - 10, y2 + 20);
                    dis = ((x2 - x1) * (x2 - x1) - (y2 - y1) * (y2 - y1)) / 10;
                    if (dis < 0) {
                        dis = dis * -1;
                    }
                    dis = Math.floor(Math.sqrt(dis));
                    g.drawString("" + dis, (x2 + x1) / 2, (y2 + y1) / 2);
                }
            }
        }
    }

    class drawnode {
        drawnode() {
            jInternalFrame1.setVisible(true);
            jInternalFrame1.getContentPane().setLayout(null);
        }

        public void dn() {
            jInternalFrame1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jInternalFrame1MouseClicked(evt);
                }
            });
        }

        private void jInternalFrame1MouseClicked(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            button[i] = new JButton();
            button[i].setBounds(x - 7, y - 30, 50, 30);
            jInternalFrame1.getContentPane().add(button[i]);
            button[i].setText(Integer.toString(i + 1));
            i++;
            a[i] = x - 7;
            b[i] = y - 30;
        }

    }

    class B1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            drawnode d1 = new drawnode();
            d1.dn();

        }
    }

    class B2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            drawedge d = new drawedge();
            d.de();
        }
    }

    /*class B3Listener implements ActionListener{
        public void actionPerformed(ActionEvent event) {

        }
    }*/
    class B6Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            jInternalFrame1.getContentPane().removeAll();
        }

    }

    public static void main(String args[]) {
        JFrame frame = new plus();
        frame.setLocation(150, 50);
        frame.show();
    }
}