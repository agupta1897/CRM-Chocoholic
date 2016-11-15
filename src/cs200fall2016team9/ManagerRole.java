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
        //determine where to go
        Object [] options  = {"Get Member report/s", "Get Provider report/s", "Get Summary report", "Get EFT report", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Get Member Reports" is chosen
        if (ans == 0) {
            report = "Member";
            
        	//TODO MemberReport mR;
        	//mR = new MemberReport;
            
            //ask if they want all the member reports run
            ans = JOptionPane.showConfirmDialog(frame, "Do you want to run all Member reports?", "ChocAn - Manager", JOptionPane.YES_NO_OPTION);
       		//get all member reports if "Yes"
       		if (ans == 0) {

        		//TODO mR.memberReport(report);
            	
            	JOptionPane.showMessageDialog(frame, "Getting all Member reports!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            	//return to getReport function
            	getReport(frame);
       		}
       		//if "No" then go to getSingleReport function
       		else if (ans == 1)
       		    getSingleReport(report,frame);
       		//if exit is pressed
       		else if (ans == -1)
       		    System.exit(0);
       		else 
                System.out.println("Something went wrong in getReport()");
        }//close Member if statement
        //if "Get Provider Reports" is chosen
        else if (ans == 1) {
            report = "Provider";
            
        	//TODO ProviderReport pR;
        	//pR = new ProviderReport;
            
            //ask if they want all the provider reports run
            ans = JOptionPane.showConfirmDialog(frame, "Do you want to run all Provider reports?", "ChocAn - Manager", JOptionPane.YES_NO_OPTION);
       		//if "Yes" then run Provider reports
       		if (ans == 0) {

        		//TODO pR.providerReport(report);

       		 JOptionPane.showMessageDialog(frame, "Getting all Provider reports!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
       		 //return to getReport function
       		 getReport(frame);
       		}
       		//if "No" then go to getSingleReport function
       		else if (ans == 1)
       			getSingleReport(report,frame);
       		//if exit is pressed
       		else if (ans == -1)
       		    System.exit(0);
       		else 
                System.out.println("Something went wrong in getReport()");
       	}//close Provider if statement
        //if "Get Summary Reports" is chosen
        else if (ans == 2) {
            JOptionPane.showMessageDialog(frame, "Getting Summary Report!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            //return to getReport function
            getReport(frame);
        }//close Summary if statement
        else if (ans == 3) {
            JOptionPane.showMessageDialog(frame, "Getting EFT Report!", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            //return to get report function
            getReport(frame);
        }//close EFT if statement
        //to go back to ChocAn.java
        else if (ans == 4)
            return;
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in getReport()");
    }//close getReport function
    
    //used to get a single member/provider report
    private static void getSingleReport(String report, JFrame frame) {
        String temp;
        int id = 0;
        int ans;
        //for member reports
        if ("Member".equals(report)) {
            
            //get id number for the report you want
            temp = JOptionPane.showInputDialog(frame, "Please enter the " + report + " number.", "ChocAn - Manager", JOptionPane.QUESTION_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e){}
            //makes sure the number is 9 digits
            while((id <= 99999999) || (id >= 1000000000)) { 
                temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + report + " number.", "ChocAn - Manager", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null) 
                    System.exit(0);
                //try to parse the string
                try { id = Integer.parseInt(temp);
                } catch (Exception e) {}
            }//close while
            
            //TODO mR.memberReport(id);
            
            JOptionPane.showMessageDialog(frame, "Getting " + report + " report for " + report + " ID: " + id + ".", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            //determine where to go
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
            else 
                System.out.println("Something went wrong in getSingleReport()");
        }
        //for Provider Reports
        else if ("Provider".equals(report)){
            
            //get id for the provider report you want
            temp = JOptionPane.showInputDialog(frame, "Please enter the " + report + " number.", "ChocAn - Manager", JOptionPane.QUESTION_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e){}
            //makes sure the number is 9 digits
            while((id <= 99999999) || (id >= 1000000000)) { 
                temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + report + " number.", "ChocAn - Manager", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null) 
                    System.exit(0);
                //try to parse the string
                try { id = Integer.parseInt(temp);
                } catch (Exception e) {}
            }//close while
            
            //TODO mR.memberReport(id);
            
            JOptionPane.showMessageDialog(frame, "Getting " + report + " report for " + report + " ID: " + id + ".", "ChocAn - Manager", JOptionPane.INFORMATION_MESSAGE);
            //determine where to go
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
            else 
                System.out.println("Something went wrong in getSingleReport()");
        } //close else for Provider Reports
        else 
            System.out.println("Something went wrong in getSingleReport()");
    } //close getSingleReport function
    
} //close ManagerRole Class