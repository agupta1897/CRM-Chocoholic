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
            manageDirectory("Service",frame);
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
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + "s info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2) {//get id
            int id = 0;
            String temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try {id = Integer.parseInt(temp);
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
            updateMember(item,id,frame);
        }
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
        int id = 0, zip = 0;
        //get name
        String name = JOptionPane.showInputDialog(frame, "Enter new " + item + " name:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (name == null)
            System.exit(0);
        //get id
        String temp = JOptionPane.showInputDialog(frame, "Enter new " + item + " number:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
        
        //get address
        String address = JOptionPane.showInputDialog(frame, "Enter new " + item + " address:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //make sure exit wasn't pressed
        if (address == null)
            System.exit(0);
        //get city
        String city = JOptionPane.showInputDialog(frame, "Enter new " + item + " city:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //make sure exit wasn't pressed
        if (city == null)
            System.exit(0);
        //get state
        String state = JOptionPane.showInputDialog(frame, "Enter new " + item + " State:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //make sure exit wasn't pressed
        if (state == null)
            System.exit(0);
        //make sure state is the right format
        while (state.length() != 2 || (state.charAt(0) < 65 || state.charAt(0) > 90) || (state.charAt(1) < 65 || state.charAt(1) > 90)){
            state = JOptionPane.showInputDialog(frame,"Error: Format must be 2 letter State abbreviation","ChocAn - Operator",JOptionPane.ERROR_MESSAGE);
            if (state == null)
                System.exit(0);
        }
        //get zip
        temp = JOptionPane.showInputDialog(frame, "Enter new " + item + " zip code:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { zip = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((zip <= 9999) || (zip >= 100000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 5 digit number. Please enter vaild " + item + " zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { zip = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        
        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " added!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + "s info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,0,frame);
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
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + "s info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,0,frame);
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
    
    private static void updateMember(String item, int id, JFrame frame) {
        String temp;
        //if you don't come from manageMember function the id will be 0
        if (id == 0) {
            //get id
            temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
        }
        
        //TODO look up info using id
        String newName = "", newAddress = "", newCity = "", newState = "";
        int newId = 0, newZip = 0;
        String name = "Bob";
        id = 123456789;
        String address = "12 fred St";
        String city = "Nor";
        String state = "AL";
        int zip = 35475;
        Object [] options1 = {"Name: " + name, "ID: " + id, "Address: " + address, "City: " + city, "State: " + state, "Zip: " + zip};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to update?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
        while (ans != 6) {
        	switch (ans) {
			    //if "Name"
        	    case 0:
			        //get new name
			        newName = JOptionPane.showInputDialog(frame, "Enter the new name: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (newName == null)
			            System.exit(0);
			        
			        //TODO update name in database
			        
			        JOptionPane.showMessageDialog(frame, item + " name updated from " + name + " to " + newName + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "ID"
        	    case 1:
			        //get new ID:
			        temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        //exits if "cancel" or "exit" is pressed
			        if (temp == null) 
			            System.exit(0);
			        //try to parse the string
			        try { newId = Integer.parseInt(temp);
			        } catch (Exception e){}
			        //makes sure the number is 9 digits
			        while((newId <= 99999999) || (newId >= 1000000000)) { 
			            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
			            //exits if "cancel" or "exit" is pressed
			            if (temp == null) 
			                System.exit(0);
			            //try to parse the string
			            try { newId = Integer.parseInt(temp);
			            } catch (Exception e) {}
			        }//close while
			        
			        //TODO Update ID in database
			        
			        JOptionPane.showMessageDialog(frame, item + " ID updated from " + id + " to " + newId + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "Address"
        	    case 2:
			        //get new address
			        newAddress = JOptionPane.showInputDialog(frame, "Enter the new address: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (newAddress == null)
			            System.exit(0);
			        //TODO update address in database
			        
			        JOptionPane.showMessageDialog(frame, item + " address updated from " + address + " to " + newAddress + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "City"
        	    case 3:
			        //get new city
			        newCity = JOptionPane.showInputDialog(frame, "Enter the new city: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (newCity == null)
			            System.exit(0);
			        //TODO update city in database
			        
			        JOptionPane.showMessageDialog(frame, item + " city updated from " + city + " to " + newCity + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "State"
        	    case 4:
			        //get new state
			        newState = JOptionPane.showInputDialog(frame, "Enter the new state: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (newState == null)
                        System.exit(0);
			      //make sure state is the right format
			        while (newState.length() != 2 || (newState.charAt(0) < 65 || newState.charAt(0) > 90) || (newState.charAt(1) < 65 || newState.charAt(1) > 90)){
			            newState = JOptionPane.showInputDialog(frame,"Error: Format must be 2 letter State abbreviation","ChocAn - Operator",JOptionPane.ERROR_MESSAGE);
			            if (newState == null)
	                        System.exit(0);
			        }
			        
			        //TODO update state in database
			        
			        JOptionPane.showMessageDialog(frame, item + " state updated from " + state + " to " + newState + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "Zip"
        	    case 5:
			      //get new zip
			       temp = JOptionPane.showInputDialog(frame, "Enter the new zip code: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (temp == null)
			            System.exit(0);
			        //try to parse the string
			        try { newZip = Integer.parseInt(temp);
			        } catch (Exception e){}
			        //makes sure the number is 9 digits
			        while((newZip <= 9999) || (newZip >= 100000)) { 
			            temp = JOptionPane.showInputDialog(frame,"Must be 5 digit number. Please enter vaild " + item + " zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
			            //exits if "cancel" or "exit" is pressed
			            if (temp == null) 
			                System.exit(0);
			            //try to parse the string
			            try { newZip = Integer.parseInt(temp);
			            } catch (Exception e) {}
			        }//close while
			        
			        //TODO update zip in database
			        
			        JOptionPane.showMessageDialog(frame, item + " zip updated from " + zip + " to " + newZip + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if exit button is pressed
        	    default: 
			        System.exit(0);
        	}//end switch
        	//get the new values;
/*            newName = "Bob";
            newId = 987654321;
            newAddress = "12 fred St";
            newCity = "Nor";
            newState = "AL";
            newZip = "35475";*/
        	Object [] options2 = {"Name: " + newName, "ID: " + newId, "Address: " + newAddress, "City: " + newCity, "State: " + newState, "Zip: " + newZip,"Done updating " + item};
        	ans = JOptionPane.showOptionDialog(frame, "What do you want to update next?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        }//end while
        
        //TODO
        
        //determine where to go
        System.out.println("options");
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,0,frame);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal(frame);
        //if "Return..." is chosen
        else if (ans == 4) {
            return;
        }
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
        else if (ans == 2) {
            int id = 0;
            String temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try {id = Integer.parseInt(temp);
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
            updateProvider(item,id,frame);
        }
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
        int id = 0, zip = 0;
        //get name
        String name = JOptionPane.showInputDialog(frame, "Enter new " + item + " name:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (name == null) 
            System.exit(0);
        //get id
        String temp = JOptionPane.showInputDialog(frame, "Enter new " + item + " number:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
        
        //get address
        String address = JOptionPane.showInputDialog(frame, "Enter new " + item + " address:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (address == null)
            System.exit(0);
        //get city
        String city = JOptionPane.showInputDialog(frame, "Enter new " + item + " City:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (city == null)
            System.exit(0);
        //get state
        String state = JOptionPane.showInputDialog(frame, "Enter new " + item + " State:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (state == null)
            System.exit(0);
        //get zip
        temp = JOptionPane.showInputDialog(frame, "Enter new " + item + " zip code:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { zip = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 9 digits
        while((zip <= 9999) || (zip >= 100000)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be 5 digit number. Please enter vaild " + item + " zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { zip = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while

        //TODO
        
        JOptionPane.showMessageDialog(frame, item + " added!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,0,frame);
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
        temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
            updateProvider(item,0,frame);
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
    
    private static void updateProvider(String item, int id, JFrame frame) {
        String temp;
        //if you don't come from manageMember function the id will be 0
        if (id == 0) {
            //get id
            temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
        }
        
        //TODO look up info using id
        String newName = "", newAddress = "", newCity = "", newState = "";
        int newId = 0, newZip = 0;
        String name = "Bob";
        id = 123456789;
        String address = "12 fred St";
        String city = "Nor";
        String state = "AL";
        int zip = 35475;
        Object [] options1 = {"Name: " + name, "ID: " + id, "Address: " + address, "City: " + city, "State: " + state, "Zip: " + zip};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to update?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
        while (ans != 6) {
            switch (ans) {
                //if "Name"
                case 0:
                    //get new name
                    newName = JOptionPane.showInputDialog(frame, "Enter the new name: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newName == null)
                        System.exit(0);
                    
                    //TODO update name in database
                    
                    JOptionPane.showMessageDialog(frame, item + " name updated from " + name + " to " + newName + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "ID"
                case 1:
                    //get new ID:
                    temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (temp == null) 
                        System.exit(0);
                    //try to parse the string
                    try { newId = Integer.parseInt(temp);
                    } catch (Exception e){}
                    //makes sure the number is 9 digits
                    while((newId <= 99999999) || (newId >= 1000000000)) { 
                        temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                        //exits if "cancel" or "exit" is pressed
                        if (temp == null) 
                            System.exit(0);
                        //try to parse the string
                        try { newId = Integer.parseInt(temp);
                        } catch (Exception e) {}
                    }//close while
                    
                    //TODO Update ID in database
                    
                    JOptionPane.showMessageDialog(frame, item + " ID updated from " + id + " to " + newId + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "Address"
                case 2:
                    //get new address
                    newAddress = JOptionPane.showInputDialog(frame, "Enter the new address: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newAddress == null)
                        System.exit(0);
                    //TODO update address in database
                    
                    JOptionPane.showMessageDialog(frame, item + " address updated from " + address + " to " + newAddress + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "City"
                case 3:
                    //get new city
                    newCity = JOptionPane.showInputDialog(frame, "Enter the new city: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newCity == null)
                        System.exit(0);
                    //TODO update city in database
                    
                    JOptionPane.showMessageDialog(frame, item + " city updated from " + city + " to " + newCity + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "State"
                case 4:
                    //get new state
                    newState = JOptionPane.showInputDialog(frame, "Enter the new state: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newState == null)
                        System.exit(0);
                    //TODO update state in database
                    
                    JOptionPane.showMessageDialog(frame, item + " state updated from " + state + " to " + newState + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "Zip"
                case 5:
                    //get new zip
                    temp = JOptionPane.showInputDialog(frame, "Enter the new zip code: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (temp == null)
                         System.exit(0);
                     //try to parse the string
                     try { newZip = Integer.parseInt(temp);
                     } catch (Exception e){}
                     //makes sure the number is 9 digits
                     while((newZip <= 9999) || (newZip >= 100000)) { 
                         temp = JOptionPane.showInputDialog(frame,"Must be 5 digit number. Please enter vaild " + item + " zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                         //exits if "cancel" or "exit" is pressed
                         if (temp == null) 
                             System.exit(0);
                         //try to parse the string
                         try { newZip = Integer.parseInt(temp);
                         } catch (Exception e) {}
                     }//close while
                    //TODO update zip in database
                    
                    JOptionPane.showMessageDialog(frame, item + " zip code updated from " + zip + " to " + newZip + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if exit button is pressed
                default: 
                    System.exit(0);
            }//end switch
            //get the new values;
/*            newName = "Bob";
            newId = 987654321;
            newAddress = "12 fred St";
            newCity = "Nor";
            newState = "AL";
            newZip = "35475";*/
            Object [] options2 = {"Name: " + newName, "ID: " + newId, "Address: " + newAddress, "City: " + newCity, "State: " + newState, "Zip: " + newZip,"Done updating " + item};
            ans = JOptionPane.showOptionDialog(frame, "What do you want to update next?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        }//end while
        
        //TODO
        
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,id,frame);
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
        else if (ans == 2) {
            String temp;
            int id = 0;
            
            //get id
            temp = JOptionPane.showInputDialog(frame, "Please enter the " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
            updateService(item,id,frame);
        }
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
        int id = 0;
        double fee = 0;
        //get name
        String name = JOptionPane.showInputDialog(frame, "Enter new " + item + " name:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (name == null)
            System.exit(0);
        //get id
        String temp = JOptionPane.showInputDialog(frame, "Enter new " + item + " number:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
        
        //get fee
        temp = JOptionPane.showInputDialog(frame, "Enter the new " + item + " fee:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null)
            System.exit(0);
        //try to parse the string
        try { fee = Double.parseDouble(temp);
        } catch (Exception e){}       
       
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
            updateService(item,0,frame);
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
        temp = JOptionPane.showInputDialog(frame, "Please enter the " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
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
            updateService(item,0,frame);
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
    
    private static void updateService(String item, int id, JFrame frame) {
        String temp;
        //if you don't come from manageMember function the id will be 0
    	if (id == 0) {
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
        }//close if

        String newName = "";
        int newId = 0;
        double newFee = 0;
        String name = "Nutrition";
        id = 123456;
        double fee = 1;
        Object [] options1 = {"Name: " + name, "ID: " + id, "Fee: " + fee};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to update?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
        while (ans != 3) {
            switch (ans) {
                //if "Name"
                case 0:
                    //get new name
                    newName = JOptionPane.showInputDialog(frame, "Enter the new name: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newName == null)
                        System.exit(0);
                    
                    //TODO update name in database
                    
                    JOptionPane.showMessageDialog(frame, item + " name updated from " + name + " to " + newName + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "ID"
                case 1:
                    //get new ID:
                    temp = JOptionPane.showInputDialog(frame, "Please enter " + item + " number.", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (temp == null) 
                        System.exit(0);
                    //try to parse the string
                    try { newId = Integer.parseInt(temp);
                    } catch (Exception e){}
                    //makes sure the number is 9 digits
                    while((newId <= 99999999) || (newId >= 1000000000)) { 
                        temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                        //exits if "cancel" or "exit" is pressed
                        if (temp == null) 
                            System.exit(0);
                        //try to parse the string
                        try { newId = Integer.parseInt(temp);
                        } catch (Exception e) {}
                    }//close while
                    
                    //TODO Update ID in database
                    
                    JOptionPane.showMessageDialog(frame, item + " ID updated from " + id + " to " + newId + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "fee"
                case 2:
                    //get new fee
                    temp = JOptionPane.showInputDialog(frame, "Enter the new fee: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (temp == null)
                        System.exit(0);
                    //try to parse the string
                    try { newFee = Double.parseDouble(temp);
                    } catch (Exception e){}
                    
                    //TODO update fee in database
                    
                    JOptionPane.showMessageDialog(frame, item + " fee updated from " + fee + " to " + newFee + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if exit button is pressed
                default: 
                    System.exit(0);
            }//end switch
            //get the new values;
//            newName = "Flex";
//            newId = 654321;
//            newFee = 2;
            Object [] options2 = {"Name: " + newName, "ID: " + newId, "Fee: " + newFee, "Done updating " + item};
            ans = JOptionPane.showOptionDialog(frame, "What do you want to update next?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        }//end while
        
        //TODO
        
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item,frame);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item,frame);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,id,frame);
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