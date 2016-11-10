package cs200fall2016team9;

import java.util.Scanner;

/**
 * This OperatorRole class is called from ChocAn.java when someone wants
 * to be an Operator. As an Operator you can manage Members, Providers,
 * and the Provider Directory. when you manage them you have the option
 * to add, delete, and update them.
 * 
 * @author Jake Mizzell
 *
 */
public class OperatorRole {
    
    public static void operatorTerminal() {
    	//manage the databse, initially pass in empty string
        manageDatabase("");
    }

    private static void manageDatabase(String ans) {
        System.out.println("Operator Terminal:");
        System.out.println("What do you want to manage? Options:");
        System.out.println("  'Member' to manage a Member");
        System.out.println("  'Provider' to manage a Provider");
        System.out.println("  'Directory' to manage the Provider Directory");
        System.out.println("  'Return' to return to the Main Menu");
        Scanner scan = new Scanner(System.in);
        ans = scan.next();
        if ("Member".equals(ans)) {
        	manageMember(scan);
        }//close Member if 
        else if ("Provider".equals(ans)) {
        	manageProvider(scan);
        }//close Provider if
        else if ("Directory".equals(ans)) {
            manageDirectory(scan);
        }//close Directory if
        else if ("Return".equals(ans)) {
            return;
        }
        else {
        	System.out.println("Must enter 'Member' or 'Provider'");
        	manageDatabase(ans);
        }
    }//close manageDatabse function

    //private static void manageMember(int id, MemberDatabase mData, Scanner scan) {
    private static void manageMember(Scanner scan) {
    	String ans;

    	System.out.println("What do you want to do? Options: ");
        System.out.println("  'Add' to add a Member");
        System.out.println("  'Delete' to remove a Member");
        System.out.println("  'Update' to update a Members information");
        System.out.println("  'Back' to return to the Operator terminal");
        ans = scan.next();
        //if add is entered
        if ("Add".equals(ans))
            addMember(scan);
        //if delete is entered
        else if ("Delete".equals(ans))
            deleteMember(scan);
        //if "update" is entered
        else if ("Update".equals(ans))
            updateMember(scan);
        else if ("Back".equals(ans)) 
            operatorTerminal();
        //makes sure "add", "delete", or "update" is entered
        else {
        	System.out.println("You must enter 'Add', 'Delete', or 'Update'");
        	//if not restart function
        	manageMember(scan);
        }
    }//close manageMember function
    
    private static void addMember(Scanner scan) {
        
        //TODO
        
        System.out.println("Member added!");
        System.out.println("Do you want to add another Member?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            addMember(scan);
        //if "No"
        else {
            System.out.println("Do you want to delete or update another Member?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageMember function
                manageMember(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                    //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else
    }//close addMember function
    
    private static void deleteMember(Scanner scan) {
        int id;
        System.out.println("What is the Member number?");
        id = scan.nextInt();
        //make sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { System.out.println("Must be a 9 digit number. Enter valid Member number."); id = scan.nextInt();}
        
        //TODO
        
        System.out.println("Member deleted!");
        System.out.println("Do you want to delete another Member?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            deleteMember(scan);
        //if "No"
        else {
            System.out.println("Do you want to add or update another Member?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageMember function
                manageMember(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                  //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else    
    }//close deleteMember function
    
    private static void updateMember(Scanner scan) {
        int id;
        System.out.println("What is the Member number?");
        id = scan.nextInt();
        //make sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { System.out.println("Must be a 9 digit number. Enter valid Member number."); id = scan.nextInt();}
        
        //TODO
        
        System.out.println("Member updated!");
        System.out.println("Do you want to update another Member?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            updateMember(scan);
        //if "No"
        else {
            System.out.println("Do you want to add or delete another Member?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageMember function
                manageMember(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                  //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else
    }//close UpdateMember function
    
    //private static void manageProvider(int id, ProviderDatabase pData, Scanner scan) {
    private static void manageProvider(Scanner scan) {
    	String ans;
    	System.out.println("What do you want to do? Options: ");
        System.out.println("  'Add' to add a Provider");
        System.out.println("  'Delete' to remove a Provider");
        System.out.println("  'Update' to update a Providers information");
        System.out.println("  'Back' to return to the Operator terminal");
        ans = scan.next();
         //if add is entered
        if ("Add".equals(ans))
            addProvider(scan);
        //if delete is entered
        else if ("Delete".equals(ans))
            deleteProvider(scan);
        //if "update" is entered
        else if ("Update".equals(ans))
            updateProvider(scan);
        else if ("Back".equals(ans)) 
            operatorTerminal();
        //makes sure "add", "delete", or "update" is entered
        else {
        	System.out.println("You must enter 'Add', 'Delete', or 'Update'");
        	//if not restart function
        	manageProvider(scan);
        }
    }//close manageProvider function
    
    private static void addProvider(Scanner scan) {
        
        //TODO
        
        System.out.println("Provider added!");
        System.out.println("Do you want to add another Member?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            addProvider(scan);
        //if "No"
        else {
            System.out.println("Do you want to delete or update another Provider?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageProvider function
                manageProvider(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                    //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else
    }//close addProvider function
    
    private static void deleteProvider(Scanner scan) {
        int id;
        System.out.println("What is the Provider number?");
        id = scan.nextInt();
        //make sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { System.out.println("Must be a 9 digit number. Enter valid Provider number."); id = scan.nextInt();}
        
        //TODO
        
        System.out.println("Provider deleted!");
        System.out.println("Do you want to delete another Provider?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            deleteProvider(scan);
        //if "No"
        else {
            System.out.println("Do you want to add or update another Provider?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageProvider function
                manageProvider(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                  //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else    
    }//close deleteProvider function
    
    private static void updateProvider(Scanner scan) {
        int id;
        System.out.println("What is the Provider number?");
        id = scan.nextInt();
        //make sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { System.out.println("Must be a 9 digit number. Enter valid Provider number."); id = scan.nextInt();}
        
        //TODO
        
        System.out.println("Provider updated!");
        System.out.println("Do you want to update another Provider?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            updateProvider(scan);
        //if "No"
        else {
            System.out.println("Do you want to add or delete another Provider?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageProvider function
                manageProvider(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                  //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else
    }//close UpdateProvider function
    
    private static void manageDirectory (Scanner scan) {
        String ans;
        System.out.println("What do you want to do? Options: ");
        System.out.println("  'Add' to add a service to the Directory");
        System.out.println("  'Delete' to delete a service from the Directory");
        System.out.println("  'Update' to update a servie in the Directory");
        System.out.println("  'Back' to return to the Operator terminal");
        ans = scan.next();
        //if "Add" is entered
        if ("Add".equals(ans))
            addService(scan);
        //if "delete" is entered
        else if ("Delete".equals(ans))
            deleteService(scan);
        //if "Update" is entered
        else if ("Update".equals(ans))
            updateService(scan);
        else if ("Back".equals(ans)) 
            operatorTerminal();
        //makes sure "add", "delete", or "update" is entered
        else {
            System.out.println("You must enter 'Add', 'Delete', or 'Update'");
            //if not restart function
            manageDirectory(scan);
        }
    }//close manageDirectory function
    private static void addService(Scanner scan) {
        
        //TODO
        
        System.out.println("Service added!");
        System.out.println("Do you want to add another Service?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            addService(scan);
        //if "No"
        else {
            System.out.println("Do you want to delete or update another Service?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageDirectory function
                manageDirectory(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                    //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else
    }//close addService function
    
    private static void deleteService(Scanner scan) {
        int id;
        System.out.println("What is the Service code?");
        id = scan.nextInt();
        //make sure the number is 6 digits
        while((id <= 99999) || (id >= 1000000)) { System.out.println("Must be a 6 digit number. Enter valid Service code."); id = scan.nextInt();}
        
        //TODO
        
        System.out.println("Service deleted!");
        System.out.println("Do you want to delete another Provider?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            deleteService(scan);
        //if "No"
        else {
            System.out.println("Do you want to add or update another Service?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageProvider function
                manageDirectory(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                  //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else    
    }//close deleteService function
    
    private static void updateService(Scanner scan) {
        int id;
        System.out.println("What is the Service code?");
        id = scan.nextInt();
        //make sure the number is 6 digits
        while((id <= 99999) || (id >= 1000000)) { System.out.println("Must be a 6 digit number. Enter valid Service code."); id = scan.nextInt();}
        
        //TODO
        
        System.out.println("Service updated!");
        System.out.println("Do you want to update another Service?");
        String ans = scan.next();
        //make sure "No" or "Yes" was entered
        while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
        if ("Yes".equals(ans))
            //return to top of function
            updateService(scan);
        //if "No"
        else {
            System.out.println("Do you want to add or delete another Service?");
            ans = scan.next();
            //make sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
            if ("Yes".equals(ans)) 
                //return to manageProvider function
                manageDirectory(scan);
            //if "No"
            else {
                System.out.println("Do you want to stay in Operator role?");
                ans = scan.next();
                //make sure "No" or "Yes" was entered
                while (!"No".equals(ans) && !"Yes".equals(ans)) { System.out.println("Error: Must enter 'Yes' or 'No'."); ans = scan.next();}
                if ("Yes".equals(ans))
                  //return to Operator Terminal
                    manageDatabase("");
                //if "No" return to ChocAn.java
            }//close else
        }//close else
    }//close UpdateService function
    
}//close OperatorRole class
