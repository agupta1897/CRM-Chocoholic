package cs200fall2016team9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Calendar;
import java.io.IOException;
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
    
    /**
     * Decides what function to go to based on the Providers choice
     * @throws IOException 
     */
    public static void providerTerminal() throws IOException {
        JFrame frame = null;
        //determine where to go
        Object [] options  = {"Verify Member for vist", "Bill Member for visit", "Request Provider Directory", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Provider", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //for "Verify Member for Visit"
        if (ans == 0)
            startVisit();
        //for "Bill Member for visit"
        else if (ans == 1)
            billVisit(0);
        //for "Request Provider Directory"
        else if (ans == 2)
            requestDirectory();
        //for "Return to main Menu, to return to ChocAn.java
        else if (ans == 3)
            return;
        //if the exit button is pressed
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something wnt wrong in providerTerminal()");
    }//close providerTerminal function
    
    /**
     * If the Provider is wanting to verify the member before health care services are provided
     * @throws IOException 
     */
    private static void startVisit() throws IOException {
        JFrame frame = null;
        int terminalId = 0, memberId = 0;
        
        //get terminalId
        String temp = JOptionPane.showInputDialog(frame, "Please enter your Provider Number.", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { terminalId = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((terminalId <= 99999999) || (terminalId >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be a 9 digit number. Please enter valid Provider number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE);
          //makes sure "cancel" or the exit button wasn't pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { terminalId = Integer.parseInt(temp);
            } catch (Exception e){}
        }
        
        //get memberId
        temp = JOptionPane.showInputDialog(frame, "Please enter your Member Number.", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { memberId = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((memberId <= 99999999) || (memberId >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild Member number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { memberId = Integer.parseInt(temp);
            } catch (Exception e) {}
        }
        
        //get status
        String status = verifyMember(memberId);
        JOptionPane.showMessageDialog(frame, status, "ChocAn - Provider", JOptionPane.INFORMATION_MESSAGE);
        
        //determine where to go
        Object [] options = {"Yes", "No, but stay in Provider Role", "No, return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame,"Are you ready to Bill?", "ChocAn - Provider", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Yes" proceed to billVisit function
        if (ans == 0) 
            billVisit(terminalId);
        //if "No, but stay Provider"
        else if (ans == 1)
            providerTerminal();
        //if "No, return to main menu"
        else if (ans == 2) 
            return;
        //if the exit button is pressed
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in startVisit()");
    }//close startVisit function
    
    /**
     * Function to handle the provider inputing information about the visit
     * @param providerId the Provider ID
     * @throws IOException 
     */
    private static void billVisit (int providerId) throws IOException {
        JFrame frame = null;
        String temp, serviceName = "";
        int memberId = 0, serviceCode = 0;
        
        //TODO ProviderDirectory pDir = new ProviderDirectory();
        
        //if you didn't come from the startVisit function get providerId
        if (providerId == 0) {
            temp = JOptionPane.showInputDialog(frame, "Please enter your Provider Number.", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null)
                System.exit(0);
            //try to parse the string
            try { providerId = Integer.parseInt(temp);
            } catch (Exception e){}
            //make sure the number is 9 digits
            while((providerId <= 99999999) || (providerId >= 1000000000)) { 
                temp = JOptionPane.showInputDialog(frame,"Must be a 9 digit number. Please enter valid Provider number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null)
                    System.exit(0);
                //try to parse the string
                try { providerId = Integer.parseInt(temp);
                } catch (Exception e){}
            }//close while
        }//close if statement
        
        //get memberId
        temp = JOptionPane.showInputDialog(frame, "Please enter your Member Number.", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { memberId = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((memberId <= 99999999) || (memberId >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild Member number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { memberId = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //verify the member and set "status"
        String status = verifyMember(memberId);
        //makes sure the status is validated and nothing else
        while(!"Validated".equals(status)) {
            memberId = Integer.parseInt(JOptionPane.showInputDialog(frame,"Must have a 'Validated' status. Please enter vaild Member number.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE));
            status = verifyMember(memberId);
        }
        if ("Validated".equals(status))
            JOptionPane.showMessageDialog(frame, status, "ChocAn - Provider", JOptionPane.INFORMATION_MESSAGE);
        
        //gets the current date and time in the proper format and stores it as a String
        String currentDateAndTime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        String date = JOptionPane.showInputDialog(frame,"Enter date the service was provided. Format must be MM-DD-YYYY.", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (date == null) 
            System.exit(0);
        //makes sure date is long enough, Month is less than 13, Day is less than 32, and year is numbers 
        while(date.length() != 10 || (date.charAt(0) < 48 || date.charAt(0) > 50) || (date.charAt(1) < 48 || date.charAt(1) > 50) 
            || date.charAt(2) != 45 || (date.charAt(3) < 48 || date.charAt(3) > 51) || (date.charAt(3) == 51 
            && date.charAt(4) > 49) || (date.charAt(4) < 48 || date.charAt(4) > 57) || date.charAt(5) != 45 || 
            (date.charAt(6) < 48 || date.charAt(6) > 57) || (date.charAt(7) < 48 || date.charAt(7) > 57) || 
            (date.charAt(8) < 48 || date.charAt(8) > 57) || (date.charAt(9) < 48 || date.charAt(9) > 57)) {
            date = JOptionPane.showInputDialog(frame,"Error: Format must be MM-DD-YYYY","ChocAn - Provider",JOptionPane.ERROR_MESSAGE);
        }//close while
        
        //ask if they want the Provider Directory
        int ans = JOptionPane.showConfirmDialog(frame, "Do you want the Provider Directory sent to you?", "ChocAn - Provider", JOptionPane.YES_NO_OPTION);
        //Send Provider Directory if "Yes" is entered
        if (ans == 0) {
            
            //TODO pDir.sendDirectory();
            
            JOptionPane.showMessageDialog(frame, "It has been sent!", "ChocAn - Provider", JOptionPane.INFORMATION_MESSAGE);
        }
        //continue with the function if "No"
        //if the exit button is pressed quit the program
        else if (ans == -1)
            System.exit(0);
        //get service code
        temp = JOptionPane.showInputDialog(frame,"Enter the service code:", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null)
            System.exit(0);
        //try to parse the string
        try { serviceCode = Integer.parseInt(temp);
        } catch (Exception e) {}
        //if the serviceCode is 6 digits display the service name
        if (serviceCode > 99999 && serviceCode < 1000000) {
            //TODO look up service name
            serviceName = "Dentist";
            ans = JOptionPane.showConfirmDialog(frame, "Is " + serviceName + " the correct service?", "ChocAn - Provider", JOptionPane.YES_NO_OPTION);
            //if exit is pressed
            if (ans == -1) 
                System.exit(0);
            //if no
            while (ans == 1) {
                temp = JOptionPane.showInputDialog(frame,"Enter the service code: ", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null)
                    System.exit(0);
                //try to parse the string
                try { serviceCode = Integer.parseInt(temp);
                } catch (Exception e) {}
                //TODO get service name
                serviceName  = "Bob";
                //if it's the right length
                if (serviceCode > 99999 && serviceCode < 1000000) {
                    ans = JOptionPane.showConfirmDialog(frame, "Is " + serviceName + " the correct service?", "ChocAn - Provider", JOptionPane.YES_NO_OPTION);
                    //if exit is pressed
                    if (ans == -1) 
                        System.exit(0);
                }//close if
                //cause loop to end
                else 
                    ans = 0;
            }//close while
        }//close if
            
        //makes sure the serviceCode is 6 digits
        while(serviceCode <= 99999 || serviceCode >= 1000000) { 
            temp = JOptionPane.showInputDialog(frame,"Must be a 6 digit number. Enter valid service code", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null)
                System.exit(0);
            //try to parse the string
            try { serviceCode = Integer.parseInt(temp);
            } catch (Exception e) {}
            //if the serviceCode is 6 digits display the service name
            if (serviceCode > 99999 && serviceCode < 1000000) {
                //TODO look up service fee
                serviceName = "Charlie";
                ans = JOptionPane.showConfirmDialog(frame, "Is " + serviceName + " the correct service?", "ChocAn - Provider", JOptionPane.YES_NO_OPTION);
                //if exit is pressed
                if (ans == -1) 
                    System.exit(0);
                //if no
                while (ans == 1) {
                    temp = JOptionPane.showInputDialog(frame,"Enter the service code: ", "ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (temp == null)
                        System.exit(0);
                    //try to parse the string
                    try { serviceCode = Integer.parseInt(temp);
                    } catch (Exception e) {}
                    //TODO get service name
                    serviceName  = "Delta";
                    //if serviceCode is 6 digits
                    if (serviceCode > 99999 && serviceCode < 1000000) {
                        ans = JOptionPane.showConfirmDialog(frame, "Is " + serviceName + " the correct service?", "ChocAn - Provider", JOptionPane.YES_NO_OPTION);
                        //if exit is pressed
                        if (ans == -1) 
                            System.exit(0);
                    }
                    //cause loop to end
                    else 
                        ans = 0;
                }//close while
            }//close if
        }//close while
        
        // TODO String serviceName = pDir.serviceLookUp(serviceCode);
        //System.out.println("Is " + serviceName + " the correct service?");
        
        //ask if Provider wants to enter comments
        ans = JOptionPane.showConfirmDialog(frame, "Do you wish to enter comments?", "ChocAn - Provider", JOptionPane.YES_NO_OPTION);
        String comment = "";
        //allow them to enter the comment if Yes
        if (ans == 0) {
            comment = JOptionPane.showInputDialog(frame,"Enter comment","ChocAn - Provider", JOptionPane.QUESTION_MESSAGE);
            //if "exit" or "cancel" is pressed
            if (comment == null)
                System.exit(0);
            while (comment.length() > 25) {
                comment = JOptionPane.showInputDialog(frame,"Comment must be less than 25 characters.", "ChocAn - Provider", JOptionPane.ERROR_MESSAGE);
                //if "exit" or "cancel" is pressed
                if (comment == null)
                    System.exit(0);
            }
        } 
        //keep the comment empty if they say "No"
        else if (ans == 1)
            comment = "";
        //if the exit button is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in billVisit()");
        
        submitVisitInfo(providerId,memberId,currentDateAndTime,date,serviceCode,comment);
        
        //determine where to go
        Object [] options  = {"Yes", "No, but stay in Provider Role", "No, return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "Do you want to bill another visit?", "ChocAn - Provider", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Yes"
        if (ans == 0)
            billVisit(providerId);
        //if "No but stay Provider"
        else if (ans == 1)
            providerTerminal();
        //if "No, return to Main Menu"
        else if (ans == 2) 
            return;
        //if the exit button is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in billVisit()");
    }//close billVisit function
    
    /**
     * Function to send the Provider Directory if requested
     * @throws IOException 
     */
    private static void requestDirectory() throws IOException {
        JFrame frame = null;
        //TODO ProviderDirectory pDir = new ProviderDirectory();
        //pDir.sendDirectory();
        
        JOptionPane.showMessageDialog(frame, "It has been sent!", "ChocAn - Provider", JOptionPane.INFORMATION_MESSAGE);
        //return to providerTerminal function
        providerTerminal();
    }//close requestDirectory function
    
    /**
     * function to verify Member
     * @param id the Member ID you are looking up
     * @return the status of the member
     * @throws IOException 
     */
    private static String verifyMember(int id) throws IOException {
        Member m = new Member();
        return m.returnStatus(id);
    }//close verifyMember function
  
    /**
     * Function to add the info obtained in billVisit function to the database
     * @param providerId the Provider ID
     * @param memberId the Member ID
     * @param currentDateAndTime the Current Date and Time when the info was inputed
     * @param date the date the service was provided
     * @param serviceCode the 6 digit code for the service provided
     * @param comment comments that the Provider might have entered
     */
    private static void submitVisitInfo(int providerId, int memberId, String currentDateAndTime, String date, int serviceCode, String comment) {
        JFrame frame = null;
        VisitDatabase vData = new VisitDatabase();
        //ProviderDirectory pDir = new ProviderDirectory();
        //TODO get the fee
        
        double fee = 100;
        //print out the info that is written to the disk plus the Fee
        JOptionPane.showMessageDialog(frame, "Member billed!\nProvider ID: " + providerId + "\nMember ID: " + memberId + "\nCurrent Date and Time: " + 
                currentDateAndTime + "\nDate of service: " + date + "\nService code: " + serviceCode + "\nComment: " + comment + "\nFee: " + fee, "ChocAn - Provider", JOptionPane.INFORMATION_MESSAGE);
        vData.addVisitInfo(providerId, memberId, currentDateAndTime, date, serviceCode, comment);
        
    }//close submitVisitInfo function
    
}//close ProviderRole Class