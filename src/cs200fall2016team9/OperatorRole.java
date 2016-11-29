package cs200fall2016team9;

import java.io.IOException;

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
    
    /**
     * Function to come from ChocAn.java
     * @throws IOException for errors
     */
    public static void operatorTerminal() throws IOException {
    	//manage the database
        manageDatabase();
    }

    /**
     * Function to see what the Operator wants
     * @throws IOException for errors
     */
    private static void manageDatabase() throws IOException {
        JFrame frame = null;
        //Determine where to go
        Object [] options  = {"Manage a Member", "Manage a Provider", "Manage the Provider Directory", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Manage a Member" is chosen
        if (ans == 0)
        	manageMember("Member");
        //if "Manage a Provider" is chosen
        else if (ans == 1)
        	manageProvider("Provider");
        //if "Manage the Provider Directory" is chosen
        else if (ans == 2)
            manageDirectory("Service");
        //if "Return..." is chosen
        else if (ans == 3)
            return;
        //if exit is pressed
        else if (ans == -1)
        	System.exit(0);
        else 
            System.out.println("Something went wrong in manageDatabase()");
    }//close manageDatabse function

    /**
     * Function to see if add, remove, or update Member info
     * @param item will always be 'Member'
     * @throws IOException 
     */
    private static void manageMember(String item) throws IOException {
        JFrame frame = null;
        //determine where to go
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + "s info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item);
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
                temp = JOptionPane.showInputDialog(frame,"Must be a 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null) 
                    System.exit(0);
                //try to parse the string
                try { id = Integer.parseInt(temp);
                } catch (Exception e) {}
            }//close while
            updateMember(item,id);
        }
        //if "Back.." is chosen
        else if (ans == 3) 
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4)
            return;
        //if exit is pressed
        else if (ans == -1)
        	System.exit(0);
        else 
            System.out.println("Something went wrong in manageMember()");
    }//close manageMember function
    
    /**
     * Function to add a Member
     * @param item will always be 'Member'
     * @throws IOException 
     */
    private static void addMember(String item) throws IOException {
        JFrame frame = null;
        MemberDatabase mData = new MemberDatabase();
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
        
        //makes sure the number is 9 digits and isn't already somoneone's id
        while((id <= 99999999) || (id >= 1000000000) || DatabaseEntry.searchCode(item,id)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be a 9 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
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
            temp = JOptionPane.showInputDialog(frame,"Must be 5 digit number. Please enter vaild zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { zip = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while    
        //add entry
        mData.addEntry(name, id, address, city, state, zip);
        JOptionPane.showMessageDialog(frame, item + " added!\nName: " + name + "\nNumber: " + id + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state + "\nZip Code: " + zip, "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + "s info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in addMember()");
    }//close addMember function
    
    /**
     * Function to delete Members
     * @param item will always be 'Member"
     * @throws IOException 
     */
    private static void deleteMember(String item) throws IOException {
        JFrame frame = null;
        MemberDatabase mData = new MemberDatabase();
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
        //delete member
        mData.removeEntry(id);
        JOptionPane.showMessageDialog(frame, item + " " + id + " deleted!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + "s info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addMember(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Remove..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in deleteMember()");
    }//close deleteMember function
    
    /**
     * Function to update Members information
     * @param item will always be 'Member'
     * @param id the Members ID that you are updating
     * @throws IOException 
     */
    private static void updateMember(String item, int id) throws IOException {
        JFrame frame = null;
        Member m = new Member();
        MemberDatabase mData = new MemberDatabase();
        String temp, newName = "", newAddress = "", newCity = "", newState = "";
        int newZip = 0;
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
            //makes sure the number is 9
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
        //set newId equal to id so that it will be the same unless changed
        int newId = id;
        //look up info using id
        String name = m.returnName(id);
        String address = m.returnAddress(id);
        String city = m.returnCity(id);
        String state = m.returnState(id);
        int zip = m.returnZip(id);
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
			        //update name in database
			        mData.updateEntry(id, newName, address, city, state, zip, id);
			        
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
			        //makes sure the number is 9 digits and isn't already somoneone's id
			        while((newId <= 99999999) || (newId >= 1000000000) || DatabaseEntry.searchCode(item,newId)) { 
			            temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
			            //exits if "cancel" or "exit" is pressed
			            if (temp == null) 
			                System.exit(0);
			            //try to parse the string
			            try { newId = Integer.parseInt(temp);
			            } catch (Exception e) {}
			        }//close while
			        //update the ID in database
			        mData.updateEntry(newId, name, address, city, state, zip, id);
			        JOptionPane.showMessageDialog(frame, item + " ID updated from " + id + " to " + newId + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "Address"
        	    case 2:
			        //get new address
			        newAddress = JOptionPane.showInputDialog(frame, "Enter the new address: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (newAddress == null)
			            System.exit(0);
			        //update address in database
			        mData.updateEntry(id, name, newAddress, city, state, zip, id);
			        JOptionPane.showMessageDialog(frame, item + " address updated from " + address + " to " + newAddress + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if "City"
        	    case 3:
			        //get new city
			        newCity = JOptionPane.showInputDialog(frame, "Enter the new city: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
			        if (newCity == null)
			            System.exit(0);
			        //update city in database
			        mData.updateEntry(id, name, address, newCity, state, zip, id);
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
			        //update state in database
			        mData.updateEntry(id, name, address, city, newState, zip, id);
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
			            temp = JOptionPane.showInputDialog(frame,"Must be 5 digit number. Please enter vaild zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
			            //exits if "cancel" or "exit" is pressed
			            if (temp == null) 
			                System.exit(0);
			            //try to parse the string
			            try { newZip = Integer.parseInt(temp);
			            } catch (Exception e) {}
			        }//close while
			        //update zip in database
			        mData.updateEntry(id, name, address, city, state, newZip, id);
			        JOptionPane.showMessageDialog(frame, item + " zip updated from " + zip + " to " + newZip + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
			        break;
			    //if exit button is pressed
        	    default: 
			        System.exit(0);
        	}//end switch
        	//get the new values with newId;
            newName = m.returnName(newId);
            newAddress = m.returnAddress(newId);
            newCity = m.returnCity(newId);
            newState = m.returnState(newId);
            newZip = m.returnZip(newId);
        	Object [] options2 = {"Name: " + newName, "ID: " + newId, "Address: " + newAddress, "City: " + newCity, "State: " + newState, "Zip: " + newZip,"Done updating " + item};
        	ans = JOptionPane.showOptionDialog(frame, "What do you want to update next?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        }//end while
        
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addMember(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteMember(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateMember(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
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
    
    /**
     * Function to see if add, remove, or update Providers information
     * @param item will always be 'Provider'
     * @throws IOException 
     */
    private static void manageProvider(String item) throws IOException {
        JFrame frame = null;
        //determine where to go
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item);
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
            updateProvider(item,id);
        }
        //if "Back.." is chosen
        else if (ans == 3) 
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4)
            return;
        //if exit is pressed
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in manageProvider()");
    }//close manageProvider function
    
    /**
     * Function to add a Provider
     * @param item will always be 'Provider'
     * @throws IOException 
     */
    private static void addProvider(String item) throws IOException {
        JFrame frame = null;
        ProviderDatabase pData = new ProviderDatabase();
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
        //makes sure the number is 9 digits and doesn't belong to someone
        while((id <= 99999999) || (id >= 1000000000) || DatabaseEntry.searchCode(item,id)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be a 9 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
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
            temp = JOptionPane.showInputDialog(frame,"Must be a 5 digit number. Please enter vaild zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { zip = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        //add provider to database
        pData.addEntry(name, id, address, city, state, zip);        
        JOptionPane.showMessageDialog(frame, item + " added!\nName: " + name + "\nNumber: " + id + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state + "\nZip Code: " + zip, "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in addProvider()");
    }//close addProvider function
    
    /**
     * Function to delete Providers
     * @param item will always be 'Provider'
     * @throws IOException 
     */
    private static void deleteProvider(String item) throws IOException {
        JFrame frame = null;
        ProviderDatabase pData = new ProviderDatabase();
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
            temp = JOptionPane.showInputDialog(frame,"Must be a a 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        //delete provider from database
        pData.removeEntry(id);
        JOptionPane.showMessageDialog(frame, item + " " + id + " deleted!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addProvider(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item);
        //if "Update..." is chosen
        else if (ans == 2) 
            updateProvider(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Remove..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);    
        else 
            System.out.println("Something went wrong in deleteProvider()");
    }//close deleteProvider function
    
    /**
     * Function to update Providers information
     * @param item will always be 'Provider'
     * @param id the Providers ID you are updating
     * @throws IOException 
     */
    private static void updateProvider(String item, int id) throws IOException {
        JFrame frame = null;
        ProviderDatabase pData = new ProviderDatabase();
        Provider p = new Provider();
        String temp, newName = "", newAddress = "", newCity = "", newState = "";
        int newZip = 0;
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
                temp = JOptionPane.showInputDialog(frame,"Must be a 9 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null) 
                    System.exit(0);
                //try to parse the string
                try { id = Integer.parseInt(temp);
                } catch (Exception e) {}
            }//close while
        }
        //set newId equal to id so that it will be the same unless changed
        int newId = id;
        //look up info using id
        String name = p.returnName(id);
        String address = p.returnAddress(id);
        String city = p.returnCity(id);
        String state = p.returnState(id);
        int zip = p.returnZip(id);
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
                    //update name in database
                    pData.updateEntry(id, newName, address, city, state, zip, id);
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
                    //makes sure the number is 9 digits and isn't already somoneone's id
                    while((newId <= 99999999) || (newId >= 1000000000) || DatabaseEntry.searchCode(item,newId)) { 
                        temp = JOptionPane.showInputDialog(frame,"Must be 9 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                        //exits if "cancel" or "exit" is pressed
                        if (temp == null) 
                            System.exit(0);
                        //try to parse the string
                        try { newId = Integer.parseInt(temp);
                        } catch (Exception e) {}
                    }//close while
                    //update ID in database
                    pData.updateEntry(newId, name, address, city, state, zip, id);
                    JOptionPane.showMessageDialog(frame, item + " ID updated from " + id + " to " + newId + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "Address"
                case 2:
                    //get new address
                    newAddress = JOptionPane.showInputDialog(frame, "Enter the new address: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newAddress == null)
                        System.exit(0);
                    //update address in database
                    pData.updateEntry(id, name, newAddress, city, state, zip, id);
                    JOptionPane.showMessageDialog(frame, item + " address updated from " + address + " to " + newAddress + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "City"
                case 3:
                    //get new city
                    newCity = JOptionPane.showInputDialog(frame, "Enter the new city: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newCity == null)
                        System.exit(0);
                    //update city in database
                    pData.updateEntry(id, name, address, newCity, state, zip, id);
                    JOptionPane.showMessageDialog(frame, item + " city updated from " + city + " to " + newCity + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if "State"
                case 4:
                    //get new state
                    newState = JOptionPane.showInputDialog(frame, "Enter the new state: ", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
                    //exits if "cancel" or "exit" is pressed
                    if (newState == null)
                        System.exit(0);
                    //update state in database
                    pData.updateEntry(id, name, address, city, newState, zip, id);
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
                     //makes sure the number is 5 digits
                     while((newZip <= 9999) || (newZip >= 100000)) { 
                         temp = JOptionPane.showInputDialog(frame,"Must be a 5 digit number. Please enter vaild zip code.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                         //exits if "cancel" or "exit" is pressed
                         if (temp == null) 
                             System.exit(0);
                         //try to parse the string
                         try { newZip = Integer.parseInt(temp);
                         } catch (Exception e) {}
                     }//close while
                    //update zip in database
                    pData.updateEntry(id, name, address, city, state, newZip, id);
                    JOptionPane.showMessageDialog(frame, item + " zip code updated from " + zip + " to " + newZip + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if exit button is pressed
                default: 
                    System.exit(0);
            }//end switch
            //get the new values with newId;
            newName = p.returnName(newId);
            newAddress = p.returnAddress(newId);
            newCity = p.returnCity(newId);
            newState = p.returnState(newId);
            newZip = p.returnZip(newId);
            Object [] options2 = {"Name: " + newName, "ID: " + newId, "Address: " + newAddress, "City: " + newCity, "State: " + newState, "Zip: " + newZip,"Done updating " + item};
            ans = JOptionPane.showOptionDialog(frame, "What do you want to update next?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        }//end while      
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addProvider(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteProvider(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateProvider(item,id);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in updateProvider()");
    }//close UpdateProvider function
    
    /**
     * Function to see if you want to add, remove, or update a Service's info
     * @param item will always be 'Service'
     * @throws IOException 
     */
    private static void manageDirectory (String item) throws IOException {
        JFrame frame = null;
        //determine where to go
        Object [] options  = {"Add a " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do yo want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item);
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
                temp = JOptionPane.showInputDialog(frame,"Must be a 6 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null) 
                    System.exit(0);
                //try to parse the string
                try { id = Integer.parseInt(temp);
                } catch (Exception e) {}
            }//close while
            updateService(item,id);
        }
        //if "Back.." is chosen
        else if (ans == 3) 
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4)
            return;
        //if exit is pressed
        else if (ans == -1)
            System.exit(0);
        else 
            System.out.println("Something went wrong in manageDirectory()");
    }//close manageDirectory function
    
    /**
     * Function to add a service 
     * @param item will always be 'Service'
     * @throws IOException 
     */
    private static void addService(String item) throws IOException {
        JFrame frame = null;
        ProviderDirectory pDir = new ProviderDirectory();
        int id = 0;
        double fee = 0;
        //get name
        String name = JOptionPane.showInputDialog(frame, "Enter new " + item + " name:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (name == null)
            System.exit(0);
        while(pDir.searchName(name)) {
              //get new name
              name = JOptionPane.showInputDialog(frame, "The Service name can't be one that already exist. Enter a different name: ", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
              //exits if "cancel" or "exit" is pressed
              if (name == null)
                  System.exit(0);
          }//close while
        //get id
        String temp = JOptionPane.showInputDialog(frame, "Enter new " + item + " number:", "ChocAn - Operator", JOptionPane.QUESTION_MESSAGE);
        //exits if "cancel" or "exit" is pressed
        if (temp == null) 
            System.exit(0);
        //try to parse the string
        try { id = Integer.parseInt(temp);
        } catch (Exception e){}
        //makes sure the number is 6 digits and isn't a service id already
        while((id <= 99999) || (id >= 1000000) || pDir.searchCode(id)) { 
            temp = JOptionPane.showInputDialog(frame,"Must be a 6 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
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
        //add service to the Provider Directory
        pDir.addService(name,id,fee);
        JOptionPane.showMessageDialog(frame, item + " added!\nName: " + name + "\nNumber: " + id + "\nFee: " + fee, "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        //determine where to go
        Object [] options = {"Add another " + item, "Remove a " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Return..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);
        else 
            System.out.println("Something went wrong in addService()");
    }//close addService function
    
    /**
     * Function to delete a Service
     * @param item will always be 'Service'
     * @throws IOException 
     */
    private static void deleteService(String item) throws IOException {
        JFrame frame = null;
        ProviderDirectory pDir = new ProviderDirectory();
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
            temp = JOptionPane.showInputDialog(frame,"Must be a 6 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
            //exits if "cancel" or "exit" is pressed
            if (temp == null) 
                System.exit(0);
            //try to parse the string
            try { id = Integer.parseInt(temp);
            } catch (Exception e) {}
        }//close while
        //remove the service
        pDir.removeService(id);
        JOptionPane.showMessageDialog(frame, item + " " + id + " deleted!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
        Object [] options = {"Add a " + item, "Remove another " + item, "Update a " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        int ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add.." is chosen
        if (ans == 0)
            addService(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,0);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
        //if "Remove..." is chosen
        else if (ans == 4) 
            return;
        //if exit is pressed
        else if (ans == -1) 
            System.exit(0);    
        else 
            System.out.println("Something went wrong in deleteService()");
    }//close deleteService function
    
    /**
     * Function to update a Service's info
     * @param item will always be 'Service'
     * @param id the Service ID
     * @throws IOException 
     */
    private static void updateService(String item, int id) throws IOException {
        JFrame frame = null;
        ProviderDirectory pDir = new ProviderDirectory();
        String temp, newName = "";
        double newFee = 0;
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
                temp = JOptionPane.showInputDialog(frame,"Must be a 6 digit number. Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                //exits if "cancel" or "exit" is pressed
                if (temp == null) 
                    System.exit(0);
                //try to parse the string
                try { id = Integer.parseInt(temp);
                } catch (Exception e) {}
            }//close while
        }//close if
    	//set newId to id so that they will be the same unless changed
    	int newId = id;
    	//get the info
        String name = pDir.serviceLookUp(id);
        double fee = pDir.getServiceFee(id);
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
                    //makes sure the service name isn't already assigned
                    while(pDir.searchName(newName)) {
                      //get new name
                        newName = JOptionPane.showInputDialog(frame, "The Service name can't be one that already exist. Enter the new name: ", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                        //exits if "cancel" or "exit" is pressed
                        if (newName == null)
                            System.exit(0);
                    }//close while
                    //update name in database
                    pDir.updateService(id, newName, fee, id);
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
                    //makes sure the number is 6 digits and isn't already a service coe
                    while((newId <= 99999) || (newId >= 1000000) || pDir.searchCode(id)) { 
                        temp = JOptionPane.showInputDialog(frame,"Must be a 6 digit number and not already belong to a " + item + ". Please enter vaild " + item + " number.", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                        //exits if "cancel" or "exit" is pressed
                        if (temp == null) 
                            System.exit(0);
                        //try to parse the string
                        try { newId = Integer.parseInt(temp);
                        } catch (Exception e) {}
                    }//close while
                    //update id in database
                    pDir.updateService(newId, name, fee, id);
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
                    //make sure the fee is less than 999.99
                    while(newFee > 999.99) {
                        temp = JOptionPane.showInputDialog(frame, "Must be a number less than 999.99. Enter the new fee: ", "ChocAn - Operator", JOptionPane.ERROR_MESSAGE);
                        if (temp == null)
                            System.exit(0);
                        //try to parse the string
                        try { newFee = Double.parseDouble(temp);
                        } catch (Exception e){}
                    }//close while
                    //update fee in database
                    pDir.updateService(id, name, newFee, id);
                    JOptionPane.showMessageDialog(frame, item + " fee updated from " + fee + " to " + newFee + "!", "ChocAn - Operator", JOptionPane.INFORMATION_MESSAGE);
                    break;
                //if exit button is pressed
                default: 
                    System.exit(0);
            }//end switch
            //get the new values
            newName = pDir.serviceLookUp(newId);
            newFee = pDir.getServiceFee(newId);
            Object [] options2 = {"Name: " + newName, "ID: " + newId, "Fee: " + newFee, "Done updating " + item};
            ans = JOptionPane.showOptionDialog(frame, "What do you want to update next?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        }//end while      
        //determine where to go
        Object [] options = {"Add a " + item, "Remove a " + item, "Update another " + item + " info", "Back to Operator Menu", "Return to Main Menu"};
        ans = JOptionPane.showOptionDialog(frame, "What do you want to do?", "ChocAn - Operator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //if "Add..." is chosen
        if (ans == 0)
            addService(item);
        //if "Remove..." is chosen
        else if (ans == 1)
            deleteService(item);
        //if "Update..." is chosen
        else if (ans == 2)
            updateService(item,id);
        //if "Back..." is chosen
        else if (ans == 3)
            operatorTerminal();
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