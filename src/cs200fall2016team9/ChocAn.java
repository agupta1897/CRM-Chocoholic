package cs200fall2016team9;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 

/**
 * This is the beginning of the program. It ask the user what role they want to be in
 * depending on their answer it will go to ProviderRole.java, ManagerRole.java, or 
 * OperatorRole.java. 
 * 
 * @author Jake Mizzell
 *
 */
public class ChocAn {
    /**
     * The start of the program
     * @param args argument from the command line
     * @throws IOException for errors
     */
    public static void main(String[] args) throws IOException {
        roleChoose();
    }//close main function


    /**
     * Decides which Role to go in based off of the user selection
     * @throws IOException for errors
     */
    public static void roleChoose() throws IOException {
        JFrame frame = null;
        //determine where to go
        Object [] options = {"Provider", "Manager", "Operator"};
        int role = JOptionPane.showOptionDialog(frame, "What Role?", "ChocAn - Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //for Provider
        if (role == 0){
            //go to ProviderRole.java
            ProviderRole.providerTerminal();
            //return to top of function
            roleChoose();
        }
        //for Manager
        else if (role == 1) {
            //go to ManagerRole.java
            ManagerRole.managerTerminal();
            //return to top of function
            roleChoose();
        }
        //for Operator
        else if (role == 2) {
            //go to Operator.java
            OperatorRole.operatorTerminal();
            //return to top of function
            roleChoose();
        }
        //if the exit button is pressed the function stops
        else if (role == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in roleChoose()");
    }//close roleChoose function
    
}//close ChocAn Class