package cs200fall2016team9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    
    public static void managerTerminal(JFrame frame) {
        //go to getReport function, initially pass in empty string
    	getReport(frame);
    }

    private static void getReport(JFrame frame) {
        String report;
        Object [] options  = {"Get Member Report/s", "Get Provider report/s", "Get Summary report", "Get EFT Report", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Get Member Reports" is chosen
        if (ans == 0) {
            report = "Member";
            
        	//TODO MemberReport mR;
        	//mR = new MemberReport;
            
            ans = JOptionPane.showConfirmDialog(frame, "Do you want to run all Member reports?", "ChocAn - Manager", JOptionPane.YES_NO_OPTION);
       		//get all member reports if "Yes"
       		if (ans == 0) {

        		//TODO mR.memberReport(report);
            	
            	JOptionPane.showMessageDialog(frame, "Getting all Member reports!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            	getReport(frame);
       		}
       		//if "No" then go to getSingleReport
       		else if (ans == 1)
       		    getSingleReport(report,frame);
       		//if exit is pressed
       		else if (ans == -1)
       		    System.exit(0);
        }//close Member if statement
        //if "Get Provider Reports" is chosen
        else if (ans == 1) {
            report = "Provider";
            
        	//TODO ProviderReport pR;
        	//pR = new ProviderReport;

            ans = JOptionPane.showConfirmDialog(frame, "Do you want to run all Provider reports?", "ChocAn - Manager", JOptionPane.YES_NO_OPTION);
       		//if "Yes" then run Provider reports
       		if (ans == 0) {

        		//TODO pR.providerReport(report);

       		 JOptionPane.showMessageDialog(frame, "Getting all Provider reports!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
       		 getReport(frame);
       		}
       		//if "No" then go to getSingleReport function
       		else if (ans == 1)
       			getSingleReport(report,frame);
       		//if exit is pressed
       		else if (ans == -1)
       		    System.exit(0);
       	}//close Provider if statement
        //if "Get Summary Reports" is chosen
        else if (ans == 2) {
            JOptionPane.showMessageDialog(frame, "Getting Summary Report!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            getReport(frame);
        }//close Summary if statement
        else if (ans == 3) {
            JOptionPane.showMessageDialog(frame, "Getting EFT Report!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            getReport(frame);
        }//close EFT if statement
        //to go back to ChocAn.java
        else if (ans == 4)
            return;
        else if (ans == -1)
            System.exit(0);
    }//close getReport function
    
    //used to get a single member/provider report
    private static void getSingleReport(String report, JFrame frame) {
        int ans;
        if ("Member".equals(report)) {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please enter the " + report + " Number.", "ChocAn - Manager", JOptionPane.QUESTION_MESSAGE));
            //makes sure the id is 9 digits
            while((id <= 99999999) || (id >= 1000000000)) { id = Integer.parseInt(JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild Member number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE));}
            
            //TODO mR.memberReport(id);
            
            JOptionPane.showMessageDialog(frame, "Getting " + report + " report for " + report + " ID: " + id + ".", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            Object [] options = {"Yes", "No, but stay in Manager role", "No return to Main Menu"};
            ans = JOptionPane.showOptionDialog(frame, "Do you want more " + report + " reports?", "ChocAn - Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            //if "Yes" restart getSingleReport function
            if (ans == 0) {
                getSingleReport(report,frame);
            }
            //if "No, but..." is chosen
            else if (ans == 1)
                managerTerminal(frame);
            //if "No return..." is chosen
            else if (ans == 2)
                return;
            else if (ans == -1)
                System.exit(0);
        }
        //for Provider Reports
        else {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please enter the " + report + " Number.", "ChocAn - Manager", JOptionPane.QUESTION_MESSAGE));
            //makes sure the id is 9 digits
            while((id <= 99999999) || (id >= 1000000000)) { id = Integer.parseInt(JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild Provider number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE));}
            
            //TODO mR.memberReport(id);
            
            JOptionPane.showMessageDialog(frame, "Getting " + report + " report for " + report + " ID: " + id + ".", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            Object [] options = {"Yes", "No, but stay in Manager role", "No return to Main Menu"};
            ans = JOptionPane.showOptionDialog(frame, "Do you want more " + report + " reports?", "ChocAn - Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            //if "Yes" restart getSingleReport function
            if (ans == 0) {
                getSingleReport(report,frame);
            }
            //if "No, but..." is chosen
            else if (ans == 1)
                managerTerminal(frame);
            //if "No return..." is chosen
            else if (ans == 2)
                return;
            else if (ans == -1)
                System.exit(0);
        } //close else for Provider Reports
    } //close getSingleReport function
    
} //close ManagerRole Class