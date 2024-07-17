package com.vishnu;

import java.sql.SQLException;

public class Vishnu {
	public static void main(String[] args) throws SQLException {
		SignUp signUp = new SignUp();
		int rows = signUp.userSignup();
		if (rows >= 1) {
			System.out.println("-----------------------------------------------------");
			System.out.println("SignedUp Successfully");
			System.out.println("-----------------------------------------------------");
			Login login = new Login();
			login.userlogin();
		} else {
			System.out.println("Failed! check your password");
		}
	}
}
