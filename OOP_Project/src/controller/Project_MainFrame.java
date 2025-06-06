package controller;

import java.awt.CardLayout;

import javax.swing.JFrame;

import data.Category;
import data.FamilyMember;
import data.User;
import data.Expense;
import gui.Head_AddFamilyMember;
import gui.Head_CreateCategory;
import gui.Head_EditAllowance;
import gui.Head_EditCategory;
import gui.Head_InspectMember;
import gui.Head_ViewExpense;
import gui.Head_ViewOverallCategories;
import gui.Head_ViewOverallFamily;
import gui.Member_EditProfile;
import gui.Member_ExpenseEditScreen;
import gui.Member_ExpenseScreen;
import gui.Member_ProfileScreen;
import gui.Menu_LoginScreen;
import gui.Menu_RegisterScreen;

public class Project_MainFrame extends JFrame{
	private CardLayout card;
	private Project_Controller cont;
	private static Project_Controller staticCont;
	public Project_MainFrame() {
		this.setTitle("User Registration");
		this.setSize(1920, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cont=new Project_Controller();
		this.card = new CardLayout();
		this.setLayout(this.card);
		this.showLoginScreen();
		this.setVisible(true);
	}
	
	public Project_Controller getController(){
		return cont;
	}
	
	public void showLoginScreen(){
		Menu_LoginScreen p1 = new Menu_LoginScreen(this);
		this.add(p1, "Panel1");
		this.card.show(this.getContentPane(), "Panel1");
	}
	
	public void showCategoryScreen(){
		Head_ViewOverallCategories p2 = new Head_ViewOverallCategories(this);
		this.add(p2, "Panel2");
		this.card.show(this.getContentPane(), "Panel2");
	}
	
	public void showFamilyScreen(){
		Head_ViewOverallFamily p3 = new Head_ViewOverallFamily(this);
		this.add(p3,"Panel3");
		this.card.show(this.getContentPane(), "Panel3");
	}
	
	public void showEditCategoryScreen(int index, Category editCat){
		Head_EditCategory p4 = new Head_EditCategory(this, index, editCat);
		this.add(p4,"Panel4");
		this.card.show(this.getContentPane(), "Panel4");
	}
	
	public void showCreateCategoryScreen(){
		Head_CreateCategory p5 = new Head_CreateCategory(this);
		this.add(p5, "Panel5");
		this.card.show(this.getContentPane(), "Panel5");
	}
	
	public void showRegisterScreen(){
		Menu_RegisterScreen p6 = new Menu_RegisterScreen(this);
		this.add(p6, "Panel6");
		this.card.show(this.getContentPane(), "Panel6");
	}
	
	public void showAddFamilyMemberScreen(){
		Head_AddFamilyMember p8 = new Head_AddFamilyMember(this);
		this.add(p8, "Panel8");
		this.card.show(this.getContentPane(), "Panel8");
	}
	
	public void showEditAllowanceScreen(int index, User u) {
		Head_EditAllowance p9 = new Head_EditAllowance(this, index, u);
		this.add(p9, "Panel9");
		this.card.show(this.getContentPane(), "Panel9");
		
	}
	
	public void showExpenseScreen(String username){
		Member_ExpenseScreen p7 = new Member_ExpenseScreen(this, username);
		this.add(p7, "Panel7");
		this.card.show(this.getContentPane(), "Panel7");
	}
	
	public void showExpenseEditScreen(int index, Expense editEx, String username){
		Member_ExpenseEditScreen p8 = new Member_ExpenseEditScreen(this,index,editEx, username);
		this.add(p8, "Panel8");
		this.card.show(this.getContentPane(), "Panel8");
	}
	
	public void showProfileScreen(String username){
		Member_ProfileScreen p9 = new Member_ProfileScreen(this, username);
		this.add(p9, "Panel9");
		this.card.show(this.getContentPane(), "Panel9");
	}
	
	public void showProfileEditScreen(User user, int index, String username){
		Member_EditProfile p10 = new Member_EditProfile(this,index, user, username);
		this.add(p10, "Panel10");
		this.card.show(this.getContentPane(), "Panel10");
	}
	
	public void showInspectMemberScreen(int index, User n) {
		Head_InspectMember p11 = new Head_InspectMember(this, index, n);
		this.add(p11, "Panel11");
		this.card.show(this.getContentPane(), "Panel11");
	}
	
	public void showViewExpenseScreen(int index, User u) {
		Head_ViewExpense p12 = new Head_ViewExpense(this, index, u);
		this.add(p12, "Panel12");
		this.card.show(this.getContentPane(), "Panel12");
	}
	
	public static void main(String[] args){
		Project_MainFrame gui = new Project_MainFrame();
	}
}
