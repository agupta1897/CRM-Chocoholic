package cs200fall2016team9;

import java.util.Scanner;

/**
 * 
 * @author Jake Mizzell
 *
 */
public class OperatorRole {
    public static void operatorTerminal() {
    	//manage the databse, initially pass in empty string
        manageDatabase("");
    }

    private static void manageDatabase(String user) {
        int id;
        System.out.println("What do you want to manage?");
        Scanner scan = new Scanner(System.in);
        user = scan.next();
        if ("Member".equals(user)) {

        	//MemberDatabase mData;
        	//mData = new MemberDatabase;

        	System.out.println("What is the " + user + " number?");
        	id = scan.nextInt();
        	manageMember(id,scan);
        }//close Member if 
        else if ("Provider".equals(user)) {

        	//ProviderDatabase pData;
        	//pData = new ProviderDatabase;

        	System.out.println("What is the " + user + " number?");
        	id = scan.nextInt();
        	manageProvider(id,scan);
        }//close provider if
        else {
        	System.out.println("Must enter 'Member' or 'Provider'");
        	manageDatabase(user);
        }
    }//close manageDatabse function

    //private static void manageMember(int id, MemberDatabase mData, Scanner scan) {
    private static void manageMember(int id, Scanner scan) {
    	String ans;
		System.out.println("What do you want to do?");
        ans = scan.next();
        //if add is entered
        if ("Add".equals(ans)) {

        	//mData.addEntry(id);

        }
        //if delete is entered
        else if ("Delete".equals(ans)) {

        	//mData.removeEntry(id);

        }
        //if "update" is entered
        else if ("Update".equals(ans)){

        	//mData.updateEntry(id);

        }
        //makes sure "add", "delete", or "update" is entered
        else {
        	System.out.println("You must enter 'Add', 'Delete', or 'Update'");
        	//if not restart function
        	manageMember(id,scan);
        }
    }//close manageMember function

    //private static void manageProvider(int id, ProviderDatabase pData, Scanner scan) {
    private static void manageProvider(int id, Scanner scan) {
    	String ans;
    	System.out.println("What do you want to do?");
        ans = scan.next();
         //if add is entered
        if ("Add".equals(ans)) {

        	//pData.addEntry(id);

        }
        //if delete is entered
        else if ("Delete".equals(ans)) {

        	//pData.removeEntry(id);

        }
        //if "update" is entered
        else if ("Update".equals(ans)){

        	//pData.updateEntry(id);

        }
        //makes sure "add", "delete", or "update" is entered
        else {
        	System.out.println("You must enter 'Add', 'Delete', or 'Update'");
        	//if not restart function
        	manageProvider(id,scan);
        }
    }//close manageProvider function
}//close OperatorRole class
