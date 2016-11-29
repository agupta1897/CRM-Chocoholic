package cs200fall2016team9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
//import java.io.*;

/**
 * 
 * @author Amber Gupta
 * ProviderDirectory maintains an Alphabetically ordered nameList of services provided with the corresponding Fee and ServiceID.
 * 
 */

public class ProviderDirectory {
	private Vector<String> nameList = new Vector<String>();
	private Vector<Double> feeList = new Vector<Double>();
	private Vector<Integer> codeList= new Vector<Integer>();
	
	
	
	public void sendDirectory() throws IOException{
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		int i=0;
		File f;
		File a = new File("src/files/member files/allMembers.txt");
		if(a.exists()) 
			f = new File("src/files/Provider Directory Email Attachment.txt");
		else 
			f = new File("files/Provider Directory Email Attachment.txt");
		if(!f.exists())
			f.createNewFile();
		BufferedWriter fstream = null;
		fstream = new BufferedWriter(new FileWriter(f));
			for( i=0; i<codeList.size();i++){
				fstream.write(nameList.elementAt(i));
				  fstream.newLine();
				fstream.write(Integer.toString(codeList.elementAt(i)));
				  fstream.newLine();
				fstream.write(Double.toString(feeList.elementAt(i)));
                  fstream.newLine();
				  fstream.write("\n");
			}
			fstream.close();
		}
		
		
	
	
	/**
	 * 
	 * As the name suggests, this function removes a service from the providerDirectory list.
	 * @param ServiceCode- ServiceCode is used to find which service is needed to be deleted
	 */
	public void removeService(int ServiceCode){
		int i=0, a=0;
		try 
		{
			saveList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		for(i=0;i<codeList.size();i++){
			if(codeList.elementAt(i)==ServiceCode){
				a=1; 
				break;
			}
		}
			if(a==1){
			nameList.remove(i);
			feeList.remove(i);
			codeList.remove(i);
			}
		
		try 
		{
			saveList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
	}
	
	/**
	 * 
	 * As the name suggests, this function Adds a service from the providerDirectory list.
	 * @param newServiceName - Name of the service to be added in the ProviderDirectory List.
	 * @param newServiceCode - Code of the service to be added in the ProviderDirectory List.
	 * @param newServiceFee - Fee of the service to be added in the ProviderDirectory List.
	 */
	
	public void addService(String newServiceName, int newServiceCode, double newServiceFee){
		int i=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		if(nameList.isEmpty())
		{
			nameList.addElement(newServiceName);
			codeList.addElement(newServiceCode);
			feeList.addElement(newServiceFee);

		}
		else 
		if(nameList.elementAt(nameList.size()-1).compareTo(newServiceName)<=0){
			nameList.addElement(newServiceName);
			codeList.addElement(newServiceCode);
			feeList.addElement(newServiceFee);
		}
		else
		{
			i=0;
			while(nameList.elementAt(i).compareTo(newServiceName)<0){
				i++;
			}
				nameList.add(i,newServiceName);
				codeList.add(i,newServiceCode);
				feeList.add(i,newServiceFee);	
		}
		
		try 
		{
			saveList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
	}
	
	/**
	 * 
	 * As the name suggests, this function updates a service from the providerDirectory list.
	 * @param oldId- Service Code of the service to needs to be updated in the ProviderDirectory List.
	 * @param newName- NewName of the service to be updated in the ProviderDirectory List.
	 * @param fee- New Fee of the service to be updated in the ProviderDirectory List.
	 * @param id- New Id which replaces the oldId in the ProviderDIrectory List.
	 */
	public void updateService(int id, String newName, double fee, int oldId) {
		int i=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		if(oldId==id){
			for(i=0;i<codeList.size();i++){
				if(codeList.elementAt(i)==id)
				{
					feeList.set(i,fee);
					nameList.set(i, newName);
					
				}
			}
		}
		else
		{
			for(i=0;i<codeList.size();i++){
				if(codeList.elementAt(i)==oldId)
				{
					codeList.set(i, id);
					feeList.set(i,fee);
					nameList.set(i, newName);
					
				}
			}

		}
		try 
		{
			saveList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
        // TODO Auto-generated method stub
        
    }
	
	/**
	 * 
	 * This function uses the current set of Vectors (nameList, codeList, feeList) to save the ProviderDirectory List.
	 */
	
	void saveList() throws IOException{
		int i=0;
		File f;
		File a = new File("src/files/member files/allMembers.txt");
		if(a.exists()) 
			f = new File("src/files/Provider Directory.txt");
		else 
			f = new File("files/Provider Directory.txt");
		if(!f.exists())
			f.createNewFile();
		BufferedWriter fstream = null;
		fstream = new BufferedWriter(new FileWriter(f));
			for( i=0; i<codeList.size();i++){
				fstream.write(nameList.elementAt(i));
				  fstream.newLine();
				fstream.write(Integer.toString(codeList.elementAt(i)));
				  fstream.newLine();
				fstream.write(Double.toString(feeList.elementAt(i)));
                  fstream.newLine();
				  fstream.write("\n");
			}
			fstream.close();
		}
	
	/**
	 * This function uses the 'Provider Directory.txt' to set the Vectors (nameList, codeList, feeList) to use other operations on them.
	 */

	void openList() throws IOException{
		String str;
		nameList.clear();
		codeList.clear();
		feeList.clear();
		File f;
		File a = new File("src/files/member files/allMembers.txt");
		if(a.exists()) 
			f = new File("src/files/Provider Directory.txt");
		else 
			f = new File("files/Provider Directory.txt");
		if(!f.exists())
		{
			return;
		}
		else
		{
			BufferedReader read = new BufferedReader(new FileReader(f));
			nameList.addElement(read.readLine());
			codeList.addElement(Integer.parseInt(read.readLine()));
			feeList.addElement(Double.parseDouble(read.readLine()));
			read.readLine();
			while((str=read.readLine())!=null){
			nameList.addElement(str);
			codeList.addElement(Integer.parseInt(read.readLine()));
			feeList.addElement(Double.parseDouble(read.readLine()));
			read.readLine();
				}
			read.close();
			}
		}
	
	
	
	/*public String serviceLookUp( int serviceCode ){
		int i=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		for(i=0;i<codeList.size();i++){
			if(codeList.elementAt(i)==serviceCode){
				return nameList.elementAt(i); 
			}
		}
			return "INVALID";
	
	}
	*/
	
	/**
	 * This function uses serviceCode to look up and return the respective serviceFee.
	 * @param serviceCode- used as in input to get the serviceFee for.
	 * @return the fee of the service which corresponds to the respective serviceCode (if exists), else returns '\0'
	 */	
	
	public double getServiceFee( int serviceCode){
		int i=0, a=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		for(i=0;i<codeList.size();i++){
			if(codeList.elementAt(i)==serviceCode){
				a=1; 
				break;
			}
		}
			if(a==1){
				return feeList.elementAt(i); 
			}
			else
			return '\0';
	}
	
	
	/**
	 * This function uses serviceCode to look up and return the respective serviceName.
	 * @param serviceCode- used as in input to get the serviceName for.
	 * @return the name of the service which corresponds to the respective serviceCode (if exists), else returns INVALID
	 */	
	
	public String getServiceName (int serviceCode){
		int i=0, a=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		for(i=0;i<codeList.size();i++){
			if(codeList.elementAt(i)==serviceCode){
				a=1; 
				break;
			}
		}
			if(a==1){
			return nameList.elementAt(i); 
		}
		else
		return "INVALID";
	}

	/**
	 * This function checks if the serviceCode passed in the parameter is unique or not.
	 * @param serviceCode- serviceCode to be checked for.
	 * @return true if the serviceCode is not unique, else returns False
	 */	
	
    public Boolean searchCode( int serviceCode){
    	if(serviceCode > 999999)
    	    throw new NumberFormatException("Must be less than 6 digits");
    	int i=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		

		for(i=0;i<codeList.size();i++){
			if(codeList.elementAt(i)==serviceCode){
				return true;
			} 
		}
			return false;
        // TODO Auto-generated method stub	
    }
    
    /**
	 * This function checks if the serviceName passed in the parameter is unique or not.
	 * @param serviceName- serviceName to be checked for uniqueness.
	 * @return true if the serviceName is not unique, else returns False
	 */	
	
    
public Boolean searchName( String serviceName){
    	
    	int i=0;
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		

		for(i=0;i<nameList.size();i++){
			if(nameList.elementAt(i).equals(serviceName)){
				return true;
			} 
		}
		
			return false;
        // TODO Auto-generated method stub	
    }
	
	
	
}
