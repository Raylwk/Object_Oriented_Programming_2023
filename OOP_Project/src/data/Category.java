package data;

public class Category {

	private String categoryName;
	private Object categoryImage;
	public String getCategoryName(){
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) { 
		 this.categoryName = categoryName; 
	}
	
	public Object getCategoryImage(){
		return categoryImage;
	}
	
	public void setCategoryImage(Object image) { 
		 this.categoryImage = image; 
	}
}
