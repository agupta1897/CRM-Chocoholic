package cs200fall2016team9;

import java.util.Scanner; 

/**
 * 
 * This is the beginning of the program. It ask the user what role they want to be in
 * depending on their answer it will go to ProviderRole.java, ManagerRole.java, or 
 * OperatorRole.java. If the user wishes to close the program they must type "Close".
 * If they input something other than "Provider", "Manager", "Operator", or 
 * "Close" the program reminds them what must be inputed.
 * 
 * @author Jake Mizzell
 *
 */
public class ChocAn {
    
    public static void main(String[] args) {
        System.out.println("Welcome to ChocAn!");
        System.out.println("Operating notes: Always make the first letter capital. \nMost responses are one word. If asked a question without options enter 'Yes' or 'No'.\n");
        roleChoose();
    }//close main function

    private static void roleChoose() {
        System.out.println("Main Menu:");
        System.out.println("What Role? Options:");
        System.out.println("  'Provider' to go to Provider terminal");
        System.out.println("  'Manager' to go to Manager terminal");
        System.out.println("  'Operator' to go to Operator terminal");
        System.out.println("  'Close' to stop the program");
        Scanner scan = new Scanner(System.in);
        String role = scan.next();
        if ("Provider".equals(role)){
            //go to ProviderRole.java
            ProviderRole.providerTerminal();
            //return to top of func
            roleChoose();
        }
        else if ("Manager".equals(role)) {
            //go to ManagerRole.java
            ManagerRole.managerTerminal();
            //return to top of function
            roleChoose();
        }
        else if ("Operator".equals(role)) {
            //go to Operator.java
            OperatorRole.operatorTerminal();
            //return to top of function
            roleChoose();
        }
        //if "Close" is entered the function stops
        else if ("Close".equals(role)){
            scan.close();
            return;
        }
        else {
            //if one of the 4 options wasn't entered, print this
            System.out.println("Error: must enter 'Provider', 'Manager', or 'Operator'");
            //return to top of function
            roleChoose();
        }
        scan.close();
    }//close roleChoose function
    
}//close ChocAn Class