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
        roleChoose();
    }

    private static void roleChoose() {
        System.out.println("Do you want Provider, Manager, or Operator Role?");
        Scanner scan = new Scanner(System.in);
        String role = scan.next();
        if ("Provider".equals(role)){
            System.out.println("You chose " + role);
            ProviderRole.providerTerminal();
            roleChoose();
        }
        else if ("Manager".equals(role)) {
            System.out.println("You chose " + role);
            ManagerRole.managerTerminal();
            roleChoose();
        }
        else if ("Operator".equals(role)) {
            System.out.println("You chose " + role);
            OperatorRole.operatorTerminal();
            roleChoose();
        }
        else if ("Close".equals(role)){
            scan.close();
            return;
        }
        else {
            System.out.println("Error: must enter 'Provider', 'Manager', or 'Operator'");
            roleChoose();
        }
        scan.close();
    }
}
