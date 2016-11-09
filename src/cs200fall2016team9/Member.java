package cs200fall2016team9;

public class Member extends DatabaseEntry {
	
	private String memberStatus;
	
	Member(){
	}
	
	void setStatus(String newStatus){
		memberStatus=newStatus;
	}
	
	String getStatus(){
		return memberStatus;
	}
	
	void addNewMember(){
		System.out.println("Adding User...");
		//Need to look up file stream util for Java
	}
}
