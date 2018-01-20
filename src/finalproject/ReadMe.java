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
import java.awt.Event.*;
import java.awt.*;
import java.awt.event.*;

public class ReadMe implements ActionListener {

    JFrame frame;
    JPanel contentPane;
    JLabel label,label1, label2, label3, label4,label5,label6;
    JButton backButton;

    public ReadMe() {
        frame = new JFrame("Read Me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        label = new JLabel("Created By: Minhal Shanjer, Submitted to: Mr. Smith");
        label1 = new JLabel("This Program is an email account manager, incase you have multiple email addresses.");
        label2 = new JLabel("You can also use the Direct Mail button to send an email without a pre-existing account on this program.");
        label3 = new JLabel("So far, I have only tested this on gmail accounts. First time use might give you a GMAIL ALERT EMAIL.");
        label4 = new JLabel("Use this program at your own risk.");
        label5 = new JLabel("If you make a mistake in any of: the email address or rhe password, it will not send the email.");
        label6 = new JLabel("By using this program, you agree to not misuse this program, or use it for illegal purposes.");
        
        contentPane.add(label);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label4);
        contentPane.add(label5);
        contentPane.add(label6);
        
        
        backButton = new JButton("Back");
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);
        contentPane.add(backButton);

        frame.setContentPane(contentPane);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if(eventName.equals("Back")){
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
        ReadMe greeting = new ReadMe();
    }
}
