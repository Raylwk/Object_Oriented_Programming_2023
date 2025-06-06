package data;

public class User {
	public String name;
	public String username;
	public String password;
	public String dateofbirth;
	public double allowance = 0.0;
	public boolean isFamilyHead;
	
	public String getUsername() {
	 	 return username; 
	}
	
	public void setUsername(String username) { 
		 this.username = username; 
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public boolean getIsFamilyHead(){
		return isFamilyHead;
	}
	public void setIsFamilyHead(boolean isFamilyHead){
		this.isFamilyHead = isFamilyHead;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setDateofBirth(String dateofbirth){
		this.dateofbirth = dateofbirth;
	}
	
	public String getDateofBirth(){
		return dateofbirth;
	}
	
	public void setAllowance(double allowance){
		this.allowance = allowance;
	}
	
	public double getAllowance(){
		return allowance;
	}
}
