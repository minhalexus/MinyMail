/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Minhal
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.BevelBorder;


public class CreateAccount implements ActionListener {

    JFrame frame;
    JLabel contentPane;
    JLabel prompt1, prompt2, prompt3, average;
    JTextField grade1, grade2;
    JPasswordField grade3;
    JButton createButton,backButton;
    int accountNumber = 1;

    public CreateAccount(int x) {
        accountNumber = x;
        /* Create and set up the frame */
        frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /* Create a content pane with a GridLayout */
        contentPane = new JLabel(new ImageIcon("background.jpg"));
        contentPane.setLayout(new GridLayout(0, 2, 3, 10));
        contentPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
        contentPane.setBackground(Color.yellow);
        /* Create and add a prompt and then a text field */
        prompt1 = new JLabel("Create Username: ");
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
        prompt2 = new JLabel("Email Address: ");
        prompt2.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt2.setBackground(Color.DARK_GRAY);
        prompt2.setForeground(Color.green);
        prompt2.setOpaque(false);
        contentPane.add(prompt2);
        
        grade2 = new JTextField(10);
        grade2.setBackground(Color.DARK_GRAY);
        grade2.setForeground(Color.cyan);
        //grade2.setOpaque(false);
        contentPane.add(grade2);
        
        /* Create and add a third prompt and then a text field */
        prompt3 = new JLabel("Email Password: ");
        prompt3.setFont(new Font("San-Serif", Font.PLAIN, 20));
        prompt3.setBackground(Color.DARK_GRAY);
        prompt3.setForeground(Color.green);
        prompt3.setOpaque(false);
        contentPane.add(prompt3);
        
        grade3 = new JPasswordField(10);
        grade3.setBackground(Color.DARK_GRAY);
        grade3.setForeground(Color.cyan);
        //grade3.setOpaque(false);
        contentPane.add(grade3);
        
        backButton = new JButton("Back");
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.cyan);
        backButton.setOpaque(false);
        backButton.setFont(new Font("San-Serif", Font.BOLD, 20));
        contentPane.add(backButton);
        
        createButton = new JButton("Create Account");
        createButton.setActionCommand("Create Account");
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
        if (eventName.equals("Create Account")) {
            File accountFile = new File("Account" + accountNumber + ".txt");
            FileWriter out;
            BufferedWriter writeFile;
            try {
                out = new FileWriter(accountFile);
                writeFile = new BufferedWriter(out);
                writeFile.write(grade1.getText());
                writeFile.newLine();
                writeFile.write(grade2.getText());
                writeFile.newLine();
                writeFile.write(grade3.getText());
                writeFile.close();
                System.out.println("Data written to file.");

            } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
                System.err.println("FileNotFoundException: "
                        + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem with input/output.");
                System.err.println("IOException: " + e.getMessage());
            }
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomePage.runGUI();
            }
        });
            frame.dispose();
        }else if(eventName.equals("Back")){
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
    public static void runGUI(int x) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        CreateAccount myGrades = new CreateAccount(x);
    }

//    public static void main(String[] args) {
//        /* Methods that create and show a HomePage should be 
//       run from an event-dispatching thread */
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                runGUI(1);
//            }
//        });
//    }
}
