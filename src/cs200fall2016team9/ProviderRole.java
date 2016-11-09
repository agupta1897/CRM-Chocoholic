package cs200fall2016team9;

import java.util.Scanner;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * This is the ProviderRole Class. It is accessed from the ChocAn.java.
 * It simulates the Provider Terminal, the Provider is asked question
 * and depending on their answer it continues or returns to ChocAn.java
 * 
 * @author Jake Mizzell
 *
 */
public class ProviderRole {
    public static void providerTerminal() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your Provider number.");
        int terminalId = scan.nextInt();
        //makes sure the number is 9 digits
        while((terminalId <= 99999999) || (terminalId >= 1000000000)) {
            System.out.println("Must be a 9 digit number. Enter valid Provider number.");
            terminalId = scan.nextInt();
        }
        System.out.println("Swipe card or key in Member number.");
        int memberId = scan.nextInt();
        //makes sure the number is 9 digits
        while((memberId <= 99999999) || (memberId >= 1000000000)) {
            System.out.println("Must be a 9 digit number. Enter valid Member number.");
            memberId = scan.nextInt();
        }

        //String status = verifyMember(memberID);
        //System.out.println(status);

        billVisit(terminalId,scan);
    }//close providerTerminal function
    
    private static void billVisit (int providerId, Scanner scan) {
        System.out.println("Time to bill, re-swipe card or key in Member number.");
        int memberId = scan.nextInt();
        //makes sure the number is 9 digits
        while((memberId <= 99999999) || (memberId >= 1000000000)) {
            System.out.println("Must be a 9 digit number. Enter valid Member number.");
            memberId = scan.nextInt();
        }
        //verify the member and set "status"
        String status = verifyMember(memberId);
        //makes sure the status is validated and nothing else
        while(!"Validated".equals(status)) {
            System.out.println("Must have a valid status. Enter valid Member number.");
            memberId = scan.nextInt();
            status = verifyMember(memberId);
        }
        if ("Validated".equals(status))
            System.out.println(status);
        //gets the current date and time in the proper format and stores it as a String
        String currentDateAndTime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());       
        System.out.println("Enter date the service was provided. Format must be MM-DD-YYYY.");
        String date = scan.next();
        //makes sure the date is long enough
        while (date.length() != 10) {
            System.out.println("Error: Format must be MM-DD-YYYY");
            date = scan.next();
        }
        //makes sure the date is the proper format
        //makes sure the Month is less than 13 and Day is less than 32, doesn't check year. 
        while((date.charAt(0) < 48 || date.charAt(0) > 50) || (date.charAt(1) < 48 || date.charAt(1) > 50) 
            || date.charAt(2) != 45 || (date.charAt(3) < 48 || date.charAt(3) > 51) || (date.charAt(3) == 51 
            && date.charAt(4) > 49) || (date.charAt(4) < 48 || date.charAt(4) > 57) || date.charAt(5) != 45) {
            System.out.println("Error: Format must be MM-DD-YYYY");
            date = scan.next();
        }
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
        //makes sure the serviceCode is 6 digits
        while(serviceCode <= 99999 || serviceCode >= 1000000) {
            System.out.println("Must be a 6 digit number. Enter valid Service Code");
            serviceCode = scan.nextInt();
        }
        
        //ProviderDirectory pDir;
        //pDir = new ProviderDirectory();
        //String serviceName = pDir.serviceLookUp(serviceCode);
        //System.out.println("Is " + serviceName + " the correct service?");
        
        //ask if Provider wants to enter comments
        System.out.println("Comments?");
        ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) {
            System.out.println("Error: Must enter 'Yes' or 'No'.");
            ans = scan.next();
        }
        String comment;
        //get the entire line, use newline as delimiter
        Scanner scanLine = new Scanner(System.in);
        scanLine.useDelimiter("\n");
        //allow them to enter the comment if Yes
        if ("Yes".equals(ans)) {
            System.out.println("Enter comment: ");
            comment = scanLine.next();
        }
        //make the comment empty if they say "No"
        else 
            comment = "";
        submitVisitInfo();
        System.out.println("Do you want to stay in Provider Role?");
        ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) {
            System.out.println("Error: Must enter 'Yes' or 'No'.");
            ans = scan.next();
        }
        //if "Yes" restart the providerTerminal function at the top
        if ("Yes".equals(ans)) 
            billVisit(providerId,scan);
        //if "No" then return to ChocAn.java
        else
            System.out.println("Returning to the main menu.");
    }//close billVisit function
    
    private static void requestDirectory() {
       
        //ProviderDirectory pDir;
        //pDir = new ProviderDirectory();
        //pDir.sendDirectory();
        
        System.out.println("It has been sent!");
    }//close requestDirectory function

    private static String verifyMember(int id) {
        
        //MemberDatabase m;
        //m = new MemberDatabase();
        //String Status = m.lookUpMember(id);
        
        //temp to allow program to run without the database
        String status = "Validated";
        return status;
    }//close verifyMember function
    
    private static void submitVisitInfo() {
        
    }//close submitVisitInfo function
}//close ProviderRole Class
