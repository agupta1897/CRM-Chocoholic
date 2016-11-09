package cs200fall2016team9;

import java.util.Scanner;

public class ProviderRole {
    public static void providerTerminal() {
        System.out.println("Please enter your Provider number.");
        Scanner scan = new Scanner(System.in);
        int terminalId = scan.nextInt();
        System.out.println("Swipe card or key in Member number.");
        int memberID = scan.nextInt();
        
        //String status = verifyMember(memberID);
        //System.out.println(status);
        
        System.out.println("Time to bill, re-swipe card or key in Member number.");
        memberID = scan.nextInt();
        String status = verifyMember(memberID);
        //makes sure the member status is validated
        while(!"Validated".equals(status)) {
            System.out.println("Must have a valid status. Enter valid Member number.");
            memberID = scan.nextInt();
            status = verifyMember(memberID);
        }
        if ("Validated".equals(status)) {
            System.out.println(status);
        }
        System.out.println("Enter date the service was provided. Format must be MM-DD-YYYY.");
        String date = scan.next();
        System.out.println("Do you want the provider directory sent to you?");
        String ans = scan.next();
        //makes sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) {
            System.out.println("Error: Must enter 'Yes' or 'No'.");
            ans = scan.next();
        }
        //Send Provider Directory if "Yes" is entered
        if ("Yes".equals(ans))
            requestDirectory();
        System.out.println("Enter the service code:");
        int serviceCode = scan.nextInt();

        //ProviderDirectory pDir;
        //pDir = new ProviderDirectory();
        //String serviceName = pDir.serviceLookUp(serviceCode);
        //System.out.println("Is " + serviceName + " the correct service?");
        
        System.out.println("Comments?");
        ans = scan.next();
        while (!"No".equals(ans) && !"Yes".equals(ans)) {
            System.out.println("Error: Must enter 'Yes' or 'No'.");
            ans = scan.next();
        }
        String comment;
        Scanner scanLine = new Scanner(System.in);
        scanLine.useDelimiter("\n");
        if ("Yes".equals(ans)) {
            System.out.println("Enter comment: ");
            comment = scanLine.next();
        }
        else 
            comment = "";
        System.out.println("Do you want to stay in Provider Role?");
        while (!"No".equals(ans) && !"Yes".equals(ans)) {
            System.out.println("Error: Must enter 'Yes' or 'No'.");
            ans = scan.next();
        }
        if ("Yes".equals(ans)) 
            providerTerminal();
        else
            System.out.println("Returning to the main menu.");;
        submitVisitInfo();
    }
    
    private static void requestDirectory() {
       
        //ProviderDirectory pDir;
        //pDir = new ProviderDirectory();
        //pDir.sendDirectory();
        
        System.out.println("It has been sent!");
    }

    private static String verifyMember(int id) {
        
        //MemberDatabase m;
        //m = new MemberDatabase();
        //String Status = m.lookUpMember(id);
        
        String status = "Validated";
        return status;
    }
    
    private static void submitVisitInfo() {
        
    }
}
