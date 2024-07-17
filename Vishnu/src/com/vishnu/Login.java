package com.vishnu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	public void userlogin() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Login here:");
		System.out.println("Enter your Email:");
		String email = scanner.next();
		System.out.println("Enter your Password:");
		String password = scanner.next();

		Connection connection = JdbcConnection.establishDatabaseConnection();

		String customerQuery = "Select * from student_details where email = ? and password = ?";

		PreparedStatement customerPreparedStatement = connection.prepareStatement(customerQuery);

		customerPreparedStatement.setString(1, email);
		customerPreparedStatement.setString(2, password);

		ResultSet customerResultSet = customerPreparedStatement.executeQuery();

		int flag = 0;

		while (customerResultSet.next()) {
			flag = 1;
		}
		if (flag == 1) {
			Branches branches = new Branches();
			branches.branchesDisplay(email);
		}
		else {
			SignUp signUp = new SignUp();
			signUp.userSignup();
		}
	}
}
