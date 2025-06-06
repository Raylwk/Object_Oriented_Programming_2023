package controller;

import java.io.IOException;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;

import data.Category;
import data.Expense;
import data.FamilyMember;
import data.Project_DataStorage;
import data.User;

public class Project_Controller {
	private Category cat;
	public Project_DataStorage ds = new Project_DataStorage();
	
	public Category getCategory(){
		return cat;
	}
	
	public Category[] getCategories(){
		return this.ds.getAllCategories();
	}
	
	public User[] getUsers(){
		return this.ds.getAllUsers();
	}

	public void addUser(String username, String password, String name, String DOB, boolean isFamilyHead) {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setName(name);
		u.setDateofBirth(DOB);
		u.setIsFamilyHead(isFamilyHead);
		this.ds.storeUser(u);
	}
	
	public void addCategory(Object categoryImage, String categoryName){
		Category c = new Category();
		c.setCategoryName(categoryName);
		c.setCategoryImage(categoryImage);
		this.ds.storeCategory(c);
	}

	public boolean verifyUser(String username, String password) {
		String real = password;
		String cc="";
		User t= ds.getUser(username);
		if(t!=null){
		cc= t.getPassword().toString();
		if(real.equals(cc))
		return true;
		else
		return false;
		}
		else
		return false;
	}
	public boolean verifyFamilyHead(String username, String password){
		String real = password;
		String cc="";
		User t= ds.getUser(username);
		if(t!=null){
		cc= t.getPassword().toString();
		if(real.equals(cc)){
			boolean check = ds.checkFamilyHead(username);
			return check;
		}
		else
		return false;
		}
		else
		return false;
	}

	public void editCategory(int index, Category newCat) {
		this.ds.editCategory(index, newCat);
	}
	
	public void deleteCategory(int index){
		this.ds.deleteCategory(index);
	}

	public Object[] getImageArray() {
		return this.ds.getImages();
	}

	public void addFamilyMember(String name, float spending) {
		FamilyMember f = new FamilyMember();
		f.setName(name);
		f.setSpending(spending);
		
		this.ds.storeFamilyMember(f);
	}

	public FamilyMember[] getFamilyMembers() {
		return this.ds.getAllFamilyMembers();
	}

	public void editAllowance(int index, User op) {
		this.ds.editAllowance(index, op);
	}
	
	public Expense[] getExpense(){
		return this.ds.getAllExpense();
	}
	
	public void addExpense(String username, String desc,Float amount, String date, String cat, Object categoryImage, String mon){
		Expense e = new Expense();
		e.setUserId(username);
		e.setDescription(desc);
		e.setAmount(amount);
		e.setDate(date);
		e.setCategory(cat);
		e.setMonth(mon);
		e.setCategoryImage(categoryImage);
		this.ds.storeExpense(e);
	}
	
	public void deleteExpense(int index){
		this.ds.deleteExpense(index);
	}

	public void editExpense(int index, Expense newEx) {
		this.ds.editExpense(index, newEx);
	}
	
	public void editUser(int index, User newUser){
		this.ds.editUser(index,newUser);
	}
	
	public void saveData(){
		try {
			ds.saveUsers();
			ds.saveCategories();
			ds.saveExpenses();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readData(){
		ds.readUsers();
		ds.readCategories();
		ds.readExpenses();
	}
	
	public void disableButton(){
		ds.isButtonDisabled = 1;
	}

	public int getIsButtonDisabled() {
		return ds.isButtonDisabled;
	}
}
