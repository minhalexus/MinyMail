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
import java.awt.Desktop;
import java.io.*;
import java.util.Scanner;

public class Mail extends Account {

    private String TO, FROM, SUBJECT, BODY;
    
    public Mail(String email, String password, String to, String subject, String body) {
        super(email,password);
        TO = to;
        SUBJECT = subject;
        BODY = body;
    }
    
    public void createMail(){
        File dataFile = new File("temp.py");
        FileWriter out;
        BufferedWriter writeFile;
        Scanner input = new Scanner(System.in);
        try {
            out = new FileWriter(dataFile);
            writeFile = new BufferedWriter(out);
            
            writeFile.write("import smtplib"); writeFile.newLine();
            writeFile.write("conn = smtplib.SMTP('smtp.gmail.com', 587)"); writeFile.newLine();
            writeFile.write("type(conn)"); writeFile.newLine();
            writeFile.write("conn.ehlo()"); writeFile.newLine();
            writeFile.write("conn.starttls()"); writeFile.newLine();
            writeFile.write("conn.login(\'"+ super.emailAddress + "\'," + "\'" + super.emailPassword + "\')"); writeFile.newLine();
            writeFile.write("conn.sendmail(\'"+ super.emailAddress + "\',"
                                        + "\'"+ TO + "\'," 
                                        + "\'Subject: "+ SUBJECT + "\\n\\n "
                                        + BODY + "\')"); writeFile.newLine();
            writeFile.write("conn.quit()"); writeFile.newLine();
            
            writeFile.close();
            out.close();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    
    public void createTestMail(){
        File dataFile = new File("test.txt");
        FileWriter out;
        BufferedWriter writeFile;
        Scanner input = new Scanner(System.in);
        try {
            out = new FileWriter(dataFile);
            writeFile = new BufferedWriter(out);
            
            writeFile.write("import smtplib"); writeFile.newLine();
            writeFile.write("conn = smtplib.SMTP('smtp.gmail.com', 587)"); writeFile.newLine();
            writeFile.write("type(conn)"); writeFile.newLine();
            writeFile.write("conn.ehlo()"); writeFile.newLine();
            writeFile.write("conn.starttls()"); writeFile.newLine();
            writeFile.write("conn.login('wingezda@gmail.com', 'b4inailurU_')"); writeFile.newLine();
            writeFile.write("conn.sendmail('wingezda@gmail.com', 'wingezda@gmail.com' , 'Subject: So long...\\n\\n Dear minhal, this is a test from yourself.')"); writeFile.newLine();
            writeFile.write("conn.quit()"); writeFile.newLine();
            
            writeFile.close();
            out.close();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    
    public void sendMail(){
        try{
            File file = new File("temp.py");
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    
    public void deleteMail(){
            File file = new File("temp.py");
            file.delete();

    }
}
