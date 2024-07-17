package com.vishnu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
	public int userSignup() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------------------------------------");
		System.out.println("Hello!,Welcome to Vishnu Institute Of Technology");
		System.out.println("-----------------------------------------------------");
		System.out.println("Register here:");
		System.out.println("Enter your First Name:");
		String firstName = scanner.next();
		System.out.println("Enter your Last Name");
		String lastName = scanner.next();
		System.out.println("Enter your Email");
		String email = scanner.next();
		System.out.println("Enter your Password");
		String password = scanner.next();
		System.out.println("Enter your Confirm_Password");
		String confirm = scanner.next();

		System.out.println("Enter your Phone Number");
		String phoneNumber = scanner.next();

		Connection connection = JdbcConnection.establishDatabaseConnection();

		if (password.equals(confirm)) {
			String customerQuery = "Insert into student_details (first_name,last_name,email,password,phone_no) values (?,?,?,?,?)";

			PreparedStatement customerPreparedStatement = connection.prepareStatement(customerQuery);

			customerPreparedStatement.setString(1, firstName);
			customerPreparedStatement.setString(2, lastName);
			customerPreparedStatement.setString(3, email);
			customerPreparedStatement.setString(4, password);
			customerPreparedStatement.setString(5, phoneNumber);

			int rowsAffected = customerPreparedStatement.executeUpdate();

			return rowsAffected;
		} else {
			return 0;
		}

	}
}
