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
 * 
 * @author Amber Gupta
 *
 */

public class ProviderDirectory {
	private Vector<String> nameList = new Vector<String>();
	private Vector<Double> feeList = new Vector<Double>();
	private Vector<Integer> codeList= new Vector<Integer>();
	
	public void sendDirectory(){
		try 
		{
			openList();
		}
		catch (IOException x)
		{
			x.printStackTrace();
		}
		
		
	}
	
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
	
	void saveList() throws IOException{
		int i=0;
		File f = new File("src/files/Provider Directory.txt");
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

	void openList() throws IOException{
		String str;
		nameList.clear();
		codeList.clear();
		feeList.clear();
		File f = new File("src/files/Provider Directory.txt");
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
	
		
	
	
	
	public String serviceLookUp( int serviceCode ){
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
				return nameList.elementAt(i); 
			}
		}
			return "INVALID";
	
	}
	
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

    public Boolean searchCode( int serviceCode){
    	
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
			if(nameList.elementAt(i)==serviceName){
				return true;
			} 
		}
		
			return false;
        // TODO Auto-generated method stub	
    }
	
	
	
}
