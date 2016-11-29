package cs200fall2016team9;
import java.io.*;
/**
 * @author Amber Gupta
 * Abstract class 'Visit' for use in storing and retriving Information about Member and Provider Visit files.
 */

public abstract class Visit {
	
	private String currentDateAndTime;
	private String date;
	private int providerId;
	private int memberId;
	private int serviceCode;
	private String comment;
	
	

	/**
	 * Abstract function of saveEntry.
	 * @throws IOException
	 */
	abstract void addEntry() throws IOException;

	
	/**
	 * Function returns listed currentDateAndTime.
	 * @return currentDateAndTime
	 */
			protected String getCurrentDateAndTime(){
			return currentDateAndTime;
		}
		
		/**
		 * Function returns listed Date.
		 * @return date
		 */
		protected String getDate(){
			return date;
		}
		
		
		/**
		 * Function returns listed Comment.
		 * @return comment
		 */
		protected String getComment(){
			return comment;
		}
		
		/**
		 * Function returns listed ProviderID.
		 * @return providerId
		 */
		protected int getProviderId(){
			return providerId;
		}
		
		/**
		 * Function returns listed MemberID.
		 * @return memberId
		 */
		protected int getMemberId(){
			return memberId;
		}
		
		/**
		 * Function returns listed ServiceCode.
		 * @return serviceCode
		 */
		protected int getServiceCode(){
			return serviceCode;
		}
		
		/**
		 * Function sets new Current Date And Time.
		 * @param newcurrentDateAndTime - new currentDateAndTime.
		 */
		protected void setCurrentDateAndTime(String newcurrentDateAndTime){
			currentDateAndTime= newcurrentDateAndTime;
		}
		
		/**
		 * Function sets new Date.
		 * @param newDate - new date.
		 */
		protected void setDate(String newDate){
			date=newDate;
		}
		
		/**
		 * Function sets new Comment.
		 * @param newComment - new comment.
		 */
		protected void setComment(String newComment){
			comment=newComment;
		}
		
		/**
		 * Function sets new ProviderID.
		 * @param newProviderId - new ProviderId.
		 */
		protected void setProviderId(int newProviderId){
			providerId=newProviderId;
		}
		
		/**
		 * Function sets new MemberID.
		 * @param newMemberId - new MemberId.
		 */
		protected void setMemberId(int newMemberId){
			memberId=newMemberId;
		}
		
		/**
		 * Function sets new Service Code.
		 * @param newServiceCode - new serviceCode.
		 */
		protected void setServiceCode(int newServiceCode){
			serviceCode =newServiceCode;
		}
	

	
	}

