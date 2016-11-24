package cs200fall2016team9;
import java.io.*;
/**
 * 
 * @author Amber Gupta
 *
 */

public abstract class Visit {
	
	private String currentDateAndTime;
	private String date;
	private int providerId;
	private int memberId;
	private int serviceCode;
	private String comment;

	abstract void addEntry() 

	public static void submitVisitInfo(int providerId, int memberId, String currentDateAndTime, String date, int serviceCode, String comment) {
		//abstract void saveVisit() throws IOException;
		
		
		protected String getCurrentDateAndTime(){
			return currentDateAndTime;
		}
		
		protected String getDate(){
			return date;
		}
		
		protected String getComment(){
			return comment;
		}
		
		protected int getProviderId(){
			return providerId;
		}
		protected int getMemberId(){
			return memberId;
		}
		
		protected int getServiceCode(){
			return serviceCode;
		}
		
		protected void setCurrentDateAndTime(String newcurrentDateAndTime){
			currentDateAndTime= newcurrentDateAndTime;
		}
		
		protected void setDate(String newDate){
			date=newDate;
		}
		
		protected void setComment(String newComment){
			comment=newComment;
		}
		
		protected void setProviderId(int newProviderId){
			providerId=newProviderId;
		}
		
		protected void setMemberId(int newMemberId){
			memberId=newMemberId;
		}
		
		protected void setServiceCode(int newServiceCode){
			serviceCode =newServiceCode;
		}
	}

	
	}
}
