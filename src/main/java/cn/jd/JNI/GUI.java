package cn.jd.JNI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;
    private JTextField tfb;
    private JTextField tfa;
    private JTextField tfadd;
    private JTextField tfn;
    private JTextField tffactorial;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
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
    public GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton bntcompute = new JButton("compute");
        bntcompute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfadd.setText(""+JNATestDll.instanceDll.add(Integer.valueOf(tfb.getText()), Integer.valueOf(tfa.getText())));
                tffactorial.setText(""+JNATestDll.instanceDll.factorial(Integer.valueOf(tfn.getText())));
            }
        });
        bntcompute.setBounds(286, 180, 93, 23);
        frame.getContentPane().add(bntcompute);

        tfb = new JTextField();
        tfb.setText("3");
        tfb.setBounds(171, 111, 66, 21);
        frame.getContentPane().add(tfb);
        tfb.setColumns(10);

        tfa = new JTextField();
        tfa.setText("2");
        tfa.setBounds(74, 111, 66, 21);
        frame.getContentPane().add(tfa);
        tfa.setColumns(10);

        tfadd = new JTextField();
        tfadd.setEditable(false);
        tfadd.setBounds(286, 111, 66, 21);
        frame.getContentPane().add(tfadd);
        tfadd.setColumns(10);

        tfn = new JTextField();
        tfn.setText("10");
        tfn.setBounds(74, 142, 66, 21);
        frame.getContentPane().add(tfn);
        tfn.setColumns(10);

        tffactorial = new JTextField();
        tffactorial.setEditable(false);
        tffactorial.setBounds(286, 142, 66, 21);
        frame.getContentPane().add(tffactorial);
        tffactorial.setColumns(10);
    }
}
