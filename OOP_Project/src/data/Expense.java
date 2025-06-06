package data;

public class Expense {
	public String userId;
	public String description;
	public Float amount;
	public String date;
	public String category;
	public Object categoryImage;
	public String month;
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setAmount(Float amount)
	{
		this.amount = amount;
	}
	
	public Float getAmount()
	{
		return amount;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setMonth(String month)
	{
		this.month = month;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public void setCategoryImage(Object image) { 
		 this.categoryImage = image; 
	}

	public Object getCategoryImage() {
		return categoryImage;
	}
}
