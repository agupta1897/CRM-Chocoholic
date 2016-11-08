package cs200fall2016team9;

import java.util.Scanner; 

public class ChocAn {
    public static void main(String[] args) {
        roleChoose();
    }

    private static void roleChoose() {
        System.out.println("Do you want Provider, Manager, or Operator Role?");
        Scanner scan = new Scanner(System.in);
        String role = scan.next();
        if ("Provider".equals(role)){
            System.out.println("You chose Provider");
        }
        else if ("Manager".equals(role)) {
            System.out.println("You chose Manager");
        }
        else if ("Operator".equals(role)) {
            System.out.println("You chose Operator");
        }
        else if ("Close".equals(role))
            return;
        else {
            System.out.println("Error: must enter 'Provider', 'Manager', or 'Operator'");
            roleChoose();
        }
        scan.close();
    }
}
