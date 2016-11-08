package cs200fall2016team9;

import java.util.Scanner;

public class OperatorRole {
    public static void operatorTerminal() {
        System.out.println("What do you want to manage?");
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        manageDatabase(ans);
        scan.close();
    }

    private static void manageDatabase(String ans) {
                
    }
}
