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
import java.io.*;

public class AccountManager {

    static Account[] accounts = new Account[3];

    public static void updateAccounts(){
        for (int i = 0; i < 3; i++) {
            File textFile = new File("Account" + (i + 1) + ".txt");
            FileReader in;
            BufferedReader readFile;
            String u, a, p;
            try {
                in = new FileReader(textFile);
                readFile = new BufferedReader(in);
                u = readFile.readLine();
                a = readFile.readLine();
                p = readFile.readLine();
                accounts[i] = (new Account(u, a, p));
                readFile.close();
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist or could not be found.");
                System.err.println("FileNotFoundException: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem reading file.");
                System.err.println("IOException: " + e.getMessage());
            }
        }
    }
   
    public void printAccounts() {
        for (int i = 0; i < 3; i++) {
            System.out.println(accounts[i]);
        }
    }

}
