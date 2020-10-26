package com.main;

import java.util.Scanner;

import com.dao.impl.UsersDAOImpl;
import com.model.User;

public class TestUsersDAO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UsersDAOImpl impl=new UsersDAOImpl();
		System.out.println("Choose one of the following options");
		System.out.println("1.SignUp(New User)  2.Login");
		int ch=sc.nextInt();
		switch(ch) {
		case 1: User u=new User();
				System.out.println("Enter User ID,FirstName,LastName,Username,Password,Email-Id,Contact no and Adress respectively");
				u.setUser_id(sc.nextInt());
				sc.nextLine();
				u.setFirst_name(sc.nextLine());
				u.setLast_name(sc.nextLine());
				u.setUsername(sc.nextLine());
				u.setPassword(sc.nextLine());
				u.setEmail_id(sc.nextLine());
				u.setContact(sc.nextLine());
				u.setAddress(sc.nextLine());
				int res=impl.Register(u);
				System.out.println("Rows updated :" + res);
				break;
				
		case 2:System.out.println("Enter the userID and password");
				sc.nextLine();
		       User u1=impl.login(sc.nextLine(), sc.nextLine());
		       if(u1.getUser_id()==0) {
		    	   System.out.println("No such user present!Enter the correct username and password");
		       }
		       else {
		       System.out.println(u1);
		       }
		       break;
		 
		 default:System.out.println("Enter the correct choice!");
				
		}

	}

}
