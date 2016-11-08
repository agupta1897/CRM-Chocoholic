package cs200fall2016team9;

import java.util.Scanner;

public class ManagerRole {
    public static void managerTerminal() {
        System.out.println("What reports do you want?");
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        getReport(ans);
        scan.close();
    }

    private static void getReport(String ans) {
                
    }
    
    
}
