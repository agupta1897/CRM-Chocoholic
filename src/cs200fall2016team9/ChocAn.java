package cs200fall2016team9;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 

/**
 * 
 * This is the beginning of the program. It ask the user what role they want to be in
 * depending on their answer it will go to ProviderRole.java, ManagerRole.java, or 
 * OperatorRole.java. 
 * 
 * @author Jake Mizzell
 *
 */
public class ChocAn {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        roleChoose(frame);
    }//close main function

    public static void roleChoose(JFrame frame) {
        //determine where to go
        Object [] options = {"Provider", "Manager", "Operator"};
        int role = JOptionPane.showOptionDialog(frame, "What Role?", "ChocAn - Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //for Provider
        if (role == 0){
            //go to ProviderRole.java
            ProviderRole.providerTerminal(frame);
            //return to top of function
            roleChoose(frame);
        }
        //for Manager
        else if (role == 1) {
            //go to ManagerRole.java
            ManagerRole.managerTerminal(frame);
            //return to top of function
            roleChoose(frame);
        }
        //for Operator
        else if (role == 2) {
            //go to Operator.java
            OperatorRole.operatorTerminal(frame);
            //return to top of function
            roleChoose(frame);
        }
        //if the exit button is pressed the function stops
        else if (role == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in roleChoose()");
    }//close roleChoose function
    
}//close ChocAn Class