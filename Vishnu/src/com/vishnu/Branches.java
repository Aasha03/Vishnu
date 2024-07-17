package com.vishnu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Branches {

	public void branchesDisplay(String email) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String displayBranches = "Select * from branches";

		Connection connection = JdbcConnection.establishDatabaseConnection();

		PreparedStatement branchPreparedStatement = connection.prepareStatement(displayBranches);

		ResultSet branchResultSet = branchPreparedStatement.executeQuery();
		System.out.println("-----------------");
		System.out.println("Branches");
		System.out.println("-----------------");

		while (branchResultSet.next()) {
			
			System.out.println(branchResultSet.getString("branch_id")+"."+branchResultSet.getString("branch_name"));
		}
		
		System.out.println("Select any one Branch using number:");
		int branchID = scanner.nextInt();
		
		Courses courses = new Courses();
		courses.displayCourses(email,branchID);
	}
}
