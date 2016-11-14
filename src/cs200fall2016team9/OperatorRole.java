package cs200fall2016team9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    
    public static void operatorTerminal(JFrame frame) {
    	//manage the database
        manageDatabase(frame);
    }

    private static void manageDatabase(JFrame frame) {
        //Determine where to go
        Object [] options  = {"Manage a Member", "Manage a Provider", "Manage the Provider Directory", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Manage a Member" is chosen
        if (ans == 0)
        	manageMember("Member",frame);
        //if "Manage a Provider" is chosen
        else if (ans == 1)
        	manageProvider("Provider",frame);
        //if "Manage the Provider Directory" is chosen
        else if (ans == 2)
            manageDirectory("service",frame);
        //if "Return..." is chosen
        else if (ans == 3)
            return;
        else if (ans == -1)
        	System.exit(0);
        else 
            System.out.println("Something went wrong in manageDatabase()");
    }//close manageDatabse function

    private static void manageMember(String item,JFrame frame) {
        //determine where to go
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,frame);
        //if "Back.." is chosen
        else if (ans == 3) 
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4)
            return;
        //if exit is pressed
        else if (ans == -1)
        	System.exit(0);
        else 
            System.out.println("Something went wrong in manageMember()");
    }//close manageMember function
    
    private static void addMember(String item, JFrame frame) {
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " added!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in addMember()");
    }//close addMember function
    
    private static void deleteMember(String item, JFrame frame) {
        String temp;
        int id = 0;
        
        //get id
        temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " Number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " deleted!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Remove..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in deleteMember()");
    }//close deleteMember function
    
    private static void updateMember(String item, JFrame frame) {
        String temp;
        int id = 0;
        
        //get id
        temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " Number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " updated!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in updateMember()");
    }//close UpdateMember function
    
    private static void manageProvider(String item, JFrame frame) {
        //determine where to go
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,frame);
        //if "Back.." is chosen
        else if (ans == 3) 
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4)
            return;
        //if exit is pressed
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in manageProvider()");
    }//close manageProvider function
    
    private static void addProvider(String item, JFrame frame) {

        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " added!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in addProvider()");
    }//close addProvider function
    
    private static void deleteProvider(String item, JFrame frame) {
        String temp;
        int id = 0;
        
        //get id
        temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " Number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " deleted!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addProvider(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Remove..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);    
        else 
            System.out.println("Something went wrong in deleteProvider()");
    }//close deleteProvider function
    
    private static void updateProvider(String item, JFrame frame) {
        String temp;
        int id = 0;
        
        //get id
        temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " Number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((id <= 99999999) || (id >= 1000000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " updated!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in updateProvider()");
    }//close UpdateProvider function
    
    private static void manageDirectory (String item, JFrame frame) {
        //determine where to go
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,frame);
        //if "Back.." is chosen
        else if (ans == 3) 
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4)
            return;
        //if exit is pressed
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in manageDirectory()");
    }//close manageDirectory function
    
    private static void addService(String item, JFrame frame) {
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " added!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in addService()");
    }//close addService function
    
    private static void deleteService(String item, JFrame frame) {
        String temp;
        int id = 0;
        
        //get id
        temp = JOptionPane.showInputDialog(frame, "Please enter the " + item + " Number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 6 digits
        while((id <= 99999) || (id >= 1000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 6 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " deleted!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addService(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Remove..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);    
        else 
            System.out.println("Something went wrong in deleteService()");
    }//close deleteService function
    
    private static void updateService(String item, JFrame frame) {
        String temp;
        int id = 0;
        
        //get id
        temp = JOptionPane.showInputDialog(frame, "Please enter the " + item + " Number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 6 digits
        while((id <= 99999) || (id >= 1000000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 6 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " updated!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in updateService()");
    }//close UpdateService function
    
}//close OperatorRole class