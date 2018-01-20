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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.border.*;

public class HomePage implements ActionListener{

    JFrame frame,createAccount1,createAccount2;
    JLabel contentPane;
    JButton[] existingAccounts = new JButton[3];
    JButton[] newAccount = new JButton[3];
    JButton help;
    JButton directMail;
    JLabel label, space1;
    


    public HomePage() {
        
        AccountManager.updateAccounts();
        frame = new JFrame("MINYMAIL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JLabel(new ImageIcon("background.jpg"));
        contentPane.setLayout(new GridLayout(0, 2, 3, 10));
        contentPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
        contentPane.setBackground(Color.yellow);
        //contentPane.setBackground(Color.yellow);
        
        space1 = new JLabel("MINYMAIL");
        space1.setHorizontalAlignment(JLabel.CENTER);
        space1.setVerticalAlignment(JLabel.CENTER);
        space1.setFont(new Font("San-Serif", Font.ITALIC, 30));
        space1.setBackground(Color.DARK_GRAY);
        space1.setForeground(Color.green);
        space1.setOpaque(false);
        //label.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        contentPane.add(space1);
        
        label = new JLabel("Existing Accounts");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("San-Serif", Font.BOLD, 20));
        label.setForeground(Color.cyan);
        //label.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        contentPane.add(label);
        
        for (int i = 0; i < existingAccounts.length; i++) {
            newAccount[i] = new JButton("New Account " + (i + 1));
            newAccount[i].setFont(new Font("San-Serif", Font.BOLD, 20));
            newAccount[i].setAlignmentX(JButton.CENTER_ALIGNMENT);
            newAccount[i].setActionCommand((Integer.toString(i+1)));
            newAccount[i].addActionListener(this);
            //newAccount[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
            newAccount[i].setBackground(Color.DARK_GRAY);
            newAccount[i].setForeground(Color.cyan);
            newAccount[i].setOpaque(false);
            contentPane.add(newAccount[i]);
            
            existingAccounts[i] = new JButton(AccountManager.accounts[i].getUserName());
            existingAccounts[i].setAlignmentX(JButton.CENTER_ALIGNMENT);
            existingAccounts[i].setPreferredSize(new Dimension(100, 50));
            existingAccounts[i].setFont(new Font("San-Serif", Font.BOLD, 20));
            existingAccounts[i].setBackground(Color.BLACK);
            existingAccounts[i].setForeground(Color.CYAN);
            existingAccounts[i].setOpaque(false);
            
            existingAccounts[i].setActionCommand("Account" + (Integer.toString(i + 1)));
           
            existingAccounts[i].addActionListener(this);
            contentPane.add(existingAccounts[i]);
        }
        
        
        
        help = new JButton("Read Me");
        help.setFont(new Font("San-Serif", Font.BOLD, 20));
        help.setAlignmentX(JButton.CENTER_ALIGNMENT);
        help.setPreferredSize(new Dimension(100, 50));
        help.setActionCommand("Read Me");
        help.setBackground(Color.red);
        help.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
        help.addActionListener(this);
        contentPane.add(help);
        
        directMail = new JButton("Direct Mail");
        directMail.setFont(new Font("San-Serif", Font.BOLD, 20));
        directMail.setAlignmentX(JButton.CENTER_ALIGNMENT);
        directMail.setPreferredSize(new Dimension(100, 50));
        directMail.setActionCommand("Direct Mail");
        directMail.addActionListener(this);
        directMail.setBackground(Color.blue);
        directMail.setForeground(Color.green);
        directMail.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.green, Color.cyan));
        directMail.setOpaque(false);
        contentPane.add(directMail);
        
        /* Add content pane to frame */
        frame.setContentPane(contentPane);
        /* Size and then display the frame. */
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Handle button click action event pre: Action event is Hide or Show
     * post: Clicked button has different text, and label displays message
     * depending on when the button was clicked.
     */
    
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if (eventName.equals("Direct Mail")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DirectMailInterface.runGUI();
            }
        });
            frame.dispose();
        }
        else if (eventName.equals("Account1")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExistingAccountInterface.runGUI(1);
            }
        });
            frame.dispose();
        }
        else if (eventName.equals("Account2")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExistingAccountInterface.runGUI(2);
            }
        });
            frame.dispose();
        }
        else if (eventName.equals("Account3")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExistingAccountInterface.runGUI(3);
            }
        });
            frame.dispose();
        }
        else if(eventName.equals("1")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAccount.runGUI(1);
            }
        });
            frame.dispose();
            
        }
        else if(eventName.equals("2")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateAccount.runGUI(2);
            }
        });
            frame.dispose();
        }
        else if(eventName.equals("3")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateAccount.runGUI(3);
            }
        });
            frame.dispose();
        }
        else if(eventName.equals("Read Me")){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ReadMe.runGUI();
            }
        });
            frame.dispose();
        }
    }

    /**
     * Create and show the HomePage.
     */
    public static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        HomePage openingPage = new HomePage();
    }

    public static void main(String[] args) {
        /* Methods that create and show a HomePage should be 
       run from an event-dispatching thread */
        System.out.println(new File("Account1.txt").getAbsolutePath());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}
