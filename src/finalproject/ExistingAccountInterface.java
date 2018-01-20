/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.AccountManager.accounts;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Minhal
 */
public class ExistingAccountInterface implements ActionListener {

    JFrame frame;
    JLabel contentPane;
    JLabel prompt1, prompt2, prompt3, prompt4, prompt5, average;
    JLabel user, email;
    String userString, emailString, passString;

    JTextField grade3, grade4, grade5;
    JButton createButton, backButton;
    int accountNumber = 1;

    public ExistingAccountInterface(int r) {

        accountNumber = r;

        File textFile = new File("Account" + accountNumber + ".txt");
        FileReader in;
        BufferedReader readFile;
        String u, a, p;
        try {
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            userString = readFile.readLine();
            emailString = readFile.readLine();
            passString = readFile.readLine();
            readFile.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }

        /* Create and set up the frame */
        frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Create a content pane with a GridLayout */
        contentPane = new JLabel(new ImageIcon("background.jpg"));
        contentPane.setLayout(new GridLayout(0, 2, 3, 10));
        contentPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
        contentPane.setBackground(Color.yellow);
        /* Create and add a prompt and then a text field */
        prompt1 = new JLabel("User Name: ");
        prompt1.setFont(new Font("San-Serif", Font.BOLD, 20));
        prompt1.setForeground(Color.green);
        contentPane.add(prompt1);
        user = new JLabel(userString);
        user.setFont(new Font("San-Serif", Font.BOLD, 15));
        user.setBackground(Color.DARK_GRAY);
        user.setForeground(Color.cyan);
        user.setOpaque(false);
        contentPane.add(user);
        
        /* Create and add a second prompt and 
       then a text field */
        prompt2 = new JLabel("Email Address: ");
        prompt2.setFont(new Font("San-Serif", Font.BOLD, 20));
        prompt2.setForeground(Color.green);
        contentPane.add(prompt2);
        
        email = new JLabel(emailString);
        email.setFont(new Font("San-Serif", Font.BOLD, 15));
        email.setBackground(Color.DARK_GRAY);
        email.setForeground(Color.cyan);
        email.setOpaque(false);
        contentPane.add(email);

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
        prompt4 = new JLabel("Subject: ");
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

        prompt5 = new JLabel("Body: ");
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
            Mail m = new Mail(emailString, passString, grade3.getText(), grade4.getText(), grade5.getText());
            m.createMail();
            m.sendMail();
            //m.deleteMail();
        }
        else if(eventName.equals("Back")){
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
     * @param x
     */
    public static void runGUI(int x) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        ExistingAccountInterface myGrades = new ExistingAccountInterface(x);
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
