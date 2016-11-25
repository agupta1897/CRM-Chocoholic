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
 *
 */

public class ProviderDirectory {
	private Vector<String> nameList = new Vector<String>();
	private Vector<Integer> feeList = new Vector<Integer>();
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
	
	public void removeService(String ServiceName, int ServiceCode, int ServiceFee){
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
	
	public void addService(String newServiceName, int newServiceCode, int newServiceFee){
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
				nameList.add(i,newServiceName);
				codeList.add(i,newServiceCode);
				feeList.add(i,newServiceFee);
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
	}
	
	void saveList() throws IOException{
		int i=0;
		File f = new File("src/files/provider files/"+"Provider Directory"+".txt");
		if(!f.exists())
			f.createNewFile();
		BufferedWriter fstream = null;
		fstream = new BufferedWriter(new FileWriter(f));
			for( i=0; i<codeList.size();i++){
				fstream.write(nameList.elementAt(i));
				  fstream.newLine();
				fstream.write(feeList.elementAt(i));
				  fstream.newLine();
				fstream.write(codeList.elementAt(i));
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
		File f = new File("src/files/provider files/"+"Provider Directory"+".txt");
		if(!f.exists())
		{
			return;
		}
		else
		{
			BufferedReader read = new BufferedReader(new FileReader(f));
			nameList.addElement(read.readLine());
			feeList.addElement(Integer.parseInt(read.readLine()));
			codeList.addElement(Integer.parseInt(read.readLine()));
			read.readLine();
			while((str=read.readLine())!=null){
			nameList.addElement(str);
			feeList.addElement(Integer.parseInt(read.readLine()));
			codeList.addElement(Integer.parseInt(read.readLine()));
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
	
	public int getServiceFee( int serviceCode){
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
			return 0;
	}
	
	
	
}
