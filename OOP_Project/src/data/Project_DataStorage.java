package data;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Project_DataStorage {
	private Vector<User> userStorage = new Vector<User>();
	public Vector<Category> categoryStorage = new Vector<Category>();
	private Vector<FamilyMember> familyMemberStorage = new Vector<FamilyMember>();
	private Vector<Expense> exStorage = new Vector<Expense>();
	
	private ImageIcon bus = new ImageIcon("Project Icons/Bus.png");
	private ImageIcon cash = new ImageIcon("Project Icons/Cash.png");
	private ImageIcon clinic = new ImageIcon("Project Icons/Clinic.png");
	private ImageIcon hamburger = new ImageIcon("Project Icons/Hamburger.png");
	private ImageIcon movies = new ImageIcon("Project Icons/Movies.png");
	private ImageIcon popcorn = new ImageIcon("Project Icons/Popcorn.png");
	private ImageIcon glasses = new ImageIcon("Project Icons/3D Glasses.png");
	private ImageIcon tooth = new ImageIcon("Project Icons/Tooth.png");
	private ImageIcon bento = new ImageIcon("Project Icons/Bento.png");
	private ImageIcon bubbleTea = new ImageIcon("BProject Icons/ubble Tea.png");
	private ImageIcon tea = new ImageIcon("Project Icons/Tea.png");
	private ImageIcon train = new ImageIcon("Project Icons/Train.png");
	
	private String name, username, password, dateofbirth, allowance, isFamilyHead, read, cc, dd;
	public Object[] imageArr = {bus, cash, clinic, hamburger, movies, popcorn, tooth, bento, bubbleTea, tea, train, glasses};
	public int loop = 0;
	public int isButtonDisabled = 0;
	public Object[] getImages(){
		return imageArr;
	}
	
	public User[] getAllUsers() {
		User[] opArr= new User[this.userStorage.size()];
		this.userStorage.toArray(opArr);
		return opArr;
	}
	public void storeUser(User u) {
		this.userStorage.add(u);
	}
	public User getUser(String n) {
		for(int i=0; i<userStorage.size(); i++) {
			User temp = userStorage.get(i);
			if (temp.getUsername().equals(n)){
				return temp;
			}
		}
		return null;
	}
	public boolean checkFamilyHead(String n) {
		for(int i=0; i<userStorage.size(); i++) {
			User temp = userStorage.get(i);
			if (temp.getUsername().equals(n)){
				boolean check = temp.getIsFamilyHead();
				return check;
			}
		}
		return (Boolean) null;
	}
	
	public void storeCategory(Category c) {
		this.categoryStorage.add(c);
	}
	
	public Category[] getAllCategories(){
		Category[] opArr= new Category[this.categoryStorage.size()];
		this.categoryStorage.toArray(opArr);
		return opArr;
	}
	
	public void editCategory(int index, Category category){
		this.categoryStorage.set(index, category);
	}
	public void deleteCategory(int index) {
		this.categoryStorage.remove(index);
	}

	public void storeFamilyMember(FamilyMember f) {
		this.familyMemberStorage.add(f);
	}

	public FamilyMember[] getAllFamilyMembers() {
		FamilyMember[] opArr= new FamilyMember[this.familyMemberStorage.size()];
		this.familyMemberStorage.toArray(opArr);
		return opArr;
	}
	
	public void editAllowance(int index, User op) {
		this.userStorage.set(index, op);
	}
	
	public Expense[] getAllExpense(){
		Expense[] opArr = new Expense[this.exStorage.size()];
		this.exStorage.toArray(opArr);
		return opArr;
	}
	
	public void storeExpense(Expense e){
		this.exStorage.add(e);
	}
	public void deleteExpense(int index) {
		this.exStorage.remove(index);
	}
	public void editExpense(int index, Expense expense) {
		this.exStorage.set(index, expense);
	}
	public void editUser(int index, User user) {
		this.userStorage.set(index, user);
	}
	
	public void saveUsers() throws IOException {
		try {
			User[] allUsers = getAllUsers();
			BufferedWriter out = new BufferedWriter(new FileWriter("data/userdata.txt"));
			for(int q = 0; q<allUsers.length;q++){
				out.write(allUsers[q].getName()+";");
				out.newLine();
				out.write(allUsers[q].getUsername()+";");
				out.newLine();
				out.write(allUsers[q].getPassword()+";");
				out.newLine();
				out.write(allUsers[q].getDateofBirth()+";");
				out.newLine();
				out.write(String.valueOf(allUsers[q].getAllowance())+";");
				out.newLine();
				out.write(String.valueOf(allUsers[q].getIsFamilyHead())+";");
				out.newLine();
			}
			out.close();
		} 
		catch(IOException e){
			System.out.println("There was a problem:" + e);
		}    
	}	
	public void readUsers(){
		try{
			cc = "";
			int every6 = 0;
			int secondusers = 0;
			BufferedReader in = new BufferedReader(new FileReader("data/userdata.txt"));
			while((read = in.readLine()) != null){
				cc = cc+read;
				every6 = every6 +1;
			}
			int divide6 = every6/6;
			in.close();
			String[] dd = cc.split(";");
			for(int first=0; first< (divide6);first++){
					secondusers  = secondusers + 1;
					User op = new User();
					int index = 6 * first;
					op.setName(dd[index]);
					op.setUsername(dd[index+1]);
					op.setPassword(dd[index+2]);
					op.setDateofBirth(dd[index+3]);
					op.setAllowance(Float.valueOf(dd[index+4]));
					op.setIsFamilyHead(Boolean.valueOf(dd[index+5]));
					loop = loop + 1;
					storeUser(op);
			
			}
		}	
		catch(IOException e){
				System.out.println("There was a problem:" + e);   
		}
	}
	
	public void saveCategories() throws IOException {
		try {
			Category[] allCategories = getAllCategories();
			BufferedWriter out = new BufferedWriter(new FileWriter("data/categorydata.txt"));
			for(int q = 0; q<allCategories.length;q++){
				out.write(allCategories[q].getCategoryName()+";");
				out.newLine();
				out.write(allCategories[q].getCategoryImage()+";");
				out.newLine(); 
			}
			out.close();
		} 
		catch(IOException e){
			System.out.println("There was a problem:" + e);
		}    
	}	
	public void readCategories(){
		try{ 
			cc = "";
			int every2 = 0;
			int secondcategory = 0;
			BufferedReader in = new BufferedReader(new FileReader("data/categorydata.txt"));
			while((read = in.readLine()) != null){
				cc = cc+read;
				every2 = every2 +1;
			}
			int divide2 = every2/2;
			in.close();
			String[] dd = cc.split(";");
			for(int first=0; first<(divide2);first++){
					secondcategory  = secondcategory + 1;
					int index = 2 * first;
					Category op = new Category();
					op.setCategoryName(dd[index]);
					ImageIcon ob = new ImageIcon(dd[index+1]);
					op.setCategoryImage(ob);
					storeCategory(op);
			}
		}	
		catch(IOException e){
				System.out.println("There was a problem:" + e);   
		}
	}
	
	public void saveExpenses() throws IOException {
		try {
			Expense[] allExpenses= getAllExpense();
			BufferedWriter out = new BufferedWriter(new FileWriter("data/expensedata.txt"));
			for(int q = 0; q<allExpenses.length;q++){
				out.write(allExpenses[q].getUserId()+";");
				out.newLine();
				out.write(allExpenses[q].getDescription()+";");
				out.newLine();
				out.write(allExpenses[q].getAmount()+";");
				out.newLine();
				out.write(allExpenses[q].getDate()+";");
				out.newLine();
				out.write(allExpenses[q].getCategory()+";");
				out.newLine();
				out.write(allExpenses[q].getMonth()+";");
				out.newLine();
				out.write(allExpenses[q].getCategoryImage()+";");
				out.newLine();
			}
			out.close();
		} 
		catch(IOException e){
			System.out.println("There was a problem:" + e);
		}    
	}	
	public void readExpenses(){
		try{ 
			cc = "";
			int every7 = 0;
			int secondexpense = 0;
			BufferedReader in = new BufferedReader(new FileReader("data/expensedata.txt"));
			while((read = in.readLine()) != null){
				cc = cc+read;
				every7 = every7 +1;
			}
			int divide7 = every7/7;
			in.close();
			String[] dd = cc.split(";");
			for(int first=0; first< (divide7);first++){
					secondexpense  = secondexpense + 1;
					int index = 6 * first;
					Expense op = new Expense();
					op.setUserId(dd[index]);
					op.setDescription(dd[index+1]);
					op.setAmount(Float.valueOf(dd[index+2]));
					op.setDate(dd[index+3]);
					op.setCategory(dd[index+4]);
					op.setMonth(dd[index+5]);
					ImageIcon ob = new ImageIcon(dd[index+6]);
					op.setCategoryImage(ob);
					storeExpense(op);
			
			}
		}	
		catch(IOException e){
				System.out.println("There was a problem:" + e);   
		}
	}
}

