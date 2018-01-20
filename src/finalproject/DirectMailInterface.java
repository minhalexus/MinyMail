/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Minhal
 */
public class DirectMailInterface implements ActionListener {

    JFrame frame;
    JLabel contentPane;
    JLabel prompt1, prompt2, prompt3, prompt4, prompt5, average;

    JTextField grade1, grade3, grade4, grade5;
    JPasswordField grade2;
    JButton createButton, backButton;

    public DirectMailInterface() {

        /* Create and set up the frame */
        frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Create a content pane with a GridLayout */
        contentPane = new JLabel(new ImageIcon("background.jpg"));
        contentPane.setLayout(new GridLayout(0, 2, 3, 10));
        contentPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
        contentPane.setBackground(Color.yellow);
        /* Create and add a prompt and then a text field */
        prompt1 = new JLabel("Email Address: ");
        prompt1.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt1.setBackground(Color.DARK_GRAY);
        prompt1.setForeground(Color.green);
        prompt1.setOpaque(false);
        contentPane.add(prompt1);
        grade1 = new JTextField(10);
        grade1.setBackground(Color.DARK_GRAY);
        grade1.setForeground(Color.cyan);
        //grade1.setOpaque(false);
        contentPane.add(grade1);
        /* Create and add a second prompt and 
       then a text field */
        prompt2 = new JLabel("Email Password: ");
        prompt2.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt2.setBackground(Color.DARK_GRAY);
        prompt2.setForeground(Color.green);
        prompt2.setOpaque(false);
        contentPane.add(prompt2);
        grade2 = new JPasswordField(10);
        grade2.setBackground(Color.DARK_GRAY);
        grade2.setForeground(Color.cyan);
        //grade2.setOpaque(false);
        contentPane.add(grade2);

        prompt3 = new JLabel("Mail To: ");
        prompt3.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt3.setBackground(Color.DARK_GRAY);
        prompt3.setForeground(Color.green);
        prompt3.setOpaque(false);
        contentPane.add(prompt3);
        grade3 = new JTextField(10);
        grade3.setBackground(Color.DARK_GRAY);
        grade3.setForeground(Color.cyan);
        //grade3.setOpaque(false);
        contentPane.add(grade3);

        /* Create and add a third prompt and then a text field */
        prompt4 = new JLabel("Enter Subject: ");
        prompt4.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt4.setBackground(Color.DARK_GRAY);
        prompt4.setForeground(Color.green);
        prompt4.setOpaque(false);
        contentPane.add(prompt4);
        grade4 = new JTextField(10);
        grade4.setBackground(Color.DARK_GRAY);
        grade4.setForeground(Color.cyan);
        //grade4.setOpaque(false);
        contentPane.add(grade4);

        prompt5 = new JLabel("Enter Body: ");
        prompt5.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt5.setBackground(Color.DARK_GRAY);
        prompt5.setForeground(Color.green);
        prompt5.setOpaque(false);
        contentPane.add(prompt5);
        grade5 = new JTextField(15);
        grade5.setBackground(Color.DARK_GRAY);
        grade5.setForeground(Color.cyan);
        //grade5.setOpaque(false);
        contentPane.add(grade5);

        backButton = new JButton("Back");
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.cyan);
        backButton.setOpaque(false);
        backButton.setFont(new Font("San-Serif", Font.BOLD, 20));
        contentPane.add(backButton);

        createButton = new JButton("Send Mail");
        createButton.setActionCommand("Send Mail");
        createButton.addActionListener(this);
        createButton.setBackground(Color.DARK_GRAY);
        createButton.setForeground(Color.cyan);
        createButton.setOpaque(false);
        createButton.setFont(new Font("San-Serif", Font.BOLD, 20));
        contentPane.add(createButton);

        /* Add content pane to frame */
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Handle button click action event pre: none post: The average of the
     * grades entered has been calculated and displayed.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if (eventName.equals("Send Mail")) {
            // Mail(String email, String password, String to, String subject, String body)
            Mail m = new Mail(grade1.getText(), grade2.getText(), grade3.getText(), grade4.getText(), grade5.getText());
            m.createMail();
            m.sendMail();
            //Thread.sleep(3000);
            //m.deleteMail();
        } else if (eventName.equals("Back")) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    HomePage.runGUI();
                }
            });
            frame.dispose();
        }
    }

    /**
     * Create and show the GUI.
     */
    public static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        DirectMailInterface myGrades = new DirectMailInterface();
    }

//    public static void main(String[] args) {
//        /* Methods that create and show a HomePage should be 
//       run from an event-dispatching thread */
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                runGUI();
//            }
//        });
//    }
}
