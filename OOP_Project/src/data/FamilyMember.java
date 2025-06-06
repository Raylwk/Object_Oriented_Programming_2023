package data;

public class FamilyMember {

	private String name;
	private float allowance = 0;
	private float spending = 0;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setAllowance(float allowance){
		this.allowance = allowance;
	}
	public float getAllowance(){
		return allowance;
	}
	
	public void setSpending(float spending){
		this.spending = spending;
	}
	public float getSpending(){
		return spending;
	}
}
