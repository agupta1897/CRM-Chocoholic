package cs200fall2016team9;

import java.util.Scanner;

/**
* This ManagerRole class is called from ChocAn.java when someone wants
* to be a manager. The manager can request reports. Depending on their
* answers they can get all of a certain type of a report or just one 
* member/provider using their ID number as signifier. 
*
* @author Jake Mizzell
* 
*/
public class ManagerRole {
    public static void managerTerminal() {
        //go to getReport function, initially pass in empty string
    	getReport("");
    }

    private static void getReport(String report) {
        String ans;
        System.out.println("What type of report do you want?");
        Scanner scan = new Scanner(System.in);
        report = scan.next();
        if ("Member".equals(report)) {

        	//MemberReport mR;
        	//mR = new MemberReport;

        	System.out.println("Do you want to run all " + " reports?");
        	ans = scan.next();
        	//makes sure "No" or "Yes" was entered
        	while (!"No".equals(ans) && !"Yes".equals(ans)) {
            	System.out.println("Error: Must enter 'Yes' or 'No'.");
            	ans = scan.next();
       		}
       		//get all member reports if "Yes"
       		if ("Yes".equals(ans)) {

        		//mR.memberReport(report);
            	
            	System.out.println("Getting all " + report + " reports!");
       		}
       		//if "No" then go to getSingleReport
       		else
       		    getSingleReport(report,scan);
       		System.out.println("Do you want a different type of report?");
       		ans = scan.next();
       		//makes sure "No" or "Yes" was entered
       		while (!"No".equals(ans) && !"Yes".equals(ans)) {
                System.out.println("Error: Must enter 'Yes' or 'No'.");
                ans = scan.next();
            }
            //if "Yes" then restart getReport function
       		if ("Yes".equals(ans))
       		    getReport("");
       		//if "No" then return to the ChocAn.java
       		else 
       		    System.out.println("Returning to the main menu");
        }//close Member if statement
        else if ("Provider".equals(report)) {

        	//ProviderReport pR;
        	//pR = new ProviderReport;

            System.out.println("Do you want to run all " + report + " reports?");
        	ans = scan.next();
        	//makes sure "No" or "Yes" was entered
        	while (!"No".equals(ans) && !"Yes".equals(ans)) {
            	System.out.println("Error: Must enter 'Yes' or 'No'.");
            	ans = scan.next();
       		}
       		//if "Yes" then run Provider reports
       		if ("Yes".equals(ans)) {

        		//pR.providerReport(report);

            	System.out.println("Getting all " + report + " reports!");
       		}
       		//if "No" then go to getSingleReport function
       		else
       			getSingleReport(report,scan);
       		System.out.println("Do you want a different type of report?");
            ans = scan.next();
            //makes sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) {
                System.out.println("Error: Must enter 'Yes' or 'No'.");
                ans = scan.next();
            }
            //if "Yes" restart getReport function
            if ("Yes".equals(ans))
                getReport("");
            //if "No" go back to ChocAn.java
            else 
                System.out.println("Returning to the main menu");
       	}//close Provider if statement
        else if ("Summary".equals(report)) {
            System.out.println("Getting " + report + " report");
            System.out.println("Do you want a different type of report?");
            ans = scan.next();
            //makes sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) {
                System.out.println("Error: Must enter 'Yes' or 'No'.");
                ans = scan.next();
            }
            //if "Yes" restart getReport function
            if ("Yes".equals(ans))
                getReport("");
            //if "No" go back to ChocAn.java
            else 
                System.out.println("Returning to the main menu");
        }//close Summary if statement
        else if ("EFT".equals(report)) {
            System.out.println("Getting " + report + " report");
            System.out.println("Do you want a different type of report?");
            ans = scan.next();
            //makes sure "No" or "Yes" was entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) {
                System.out.println("Error: Must enter 'Yes' or 'No'.");
                ans = scan.next();
            }
            //if "Yes" restart getReport function
            if ("Yes".equals(ans))
                getReport("");
            //if "No" go back to ChocAn.java
            else 
                System.out.println("Returning to the main menu");
        }//close EFT if statement
        else {
        	//print this if the input wasn't a key word and restart function
            System.out.println("You must enter 'Member', 'Provider', 'Summary' or 'EFT'.");
            getReport(report);
        }
    }//close getReport function
    
    //used to get a single member/provider report
    private static void getSingleReport(String report, Scanner scan) {
        String ans;
        if ("Member".equals(report)) {
            System.out.println("Please enter " + report + " number: ");
            int id = scan.nextInt();
            //makes sure the id is proper length
            while((id <= 99999999) || (id >= 1000000000)) {
                System.out.println("Must be a 9 digit number. Enter valid " + report + " number.");
                id = scan.nextInt();
            }
            
            //mR.memberReport(id);
            
            System.out.println("Getting " + report + " report for " + report + " ID: " + id + ".");
            System.out.println("Do you want more " + report + " reports?");
            ans = scan.next();
            //makes sure "No" or "Yes" is entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) {
                System.out.println("Error: Must enter 'Yes' or 'No'.");
                ans = scan.next();
            }
            //if "Yes" restart getSingleReport function
            if ("Yes".equals(ans)) {
                getSingleReport(report,scan);
            }
            //if "No" return to getReport function
        }
        //for Provider Reports
        else {
            System.out.println("Please enter " + report + " number: ");
            int id = scan.nextInt();
            //makes sure the id is proper length
            while((id <= 99999999) || (id >= 1000000000)) {
                System.out.println("Must be a 9 digit number. Enter valid " + report + " number.");
                id = scan.nextInt();
            }
            
            //pR.providerReport(id);

            System.out.println("Getting " + report + " report for " + report + " ID: " + id + ".");
            System.out.println("Do you want more " + report + " reports?");
            ans = scan.next();
            //makes sure "No" or "Yes" is entered
            while (!"No".equals(ans) && !"Yes".equals(ans)) {
                System.out.println("Error: Must enter 'Yes' or 'No'.");
                ans = scan.next();
            }
            //if "Yes" restart getSingleReport function
            if ("Yes".equals(ans)) {
                getSingleReport(report,scan);
            }
        } //close else for Provider Reports
    } //close getSingleReport function
} //close ManagerRole Class
