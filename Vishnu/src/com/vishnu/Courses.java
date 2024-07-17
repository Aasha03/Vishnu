package com.vishnu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {

	public void displayCourses(String email, int branchID) throws SQLException {

		Connection connection = JdbcConnection.establishDatabaseConnection();

		String displayCourses = "Select * from courses c join branches b on b.branch_id = c.branch_id where b.branch_id = ?";

		PreparedStatement coursePreparedStatement = connection.prepareStatement(displayCourses);

		coursePreparedStatement.setInt(1, branchID);

		ResultSet courseResultSet = coursePreparedStatement.executeQuery();
		String courseName = null;
		System.out.println("-----------------");
		System.out.println("Courses:");
		System.out.println("-----------------");
		while (courseResultSet.next()) {
			System.out.println(courseResultSet.getString("course_id") + "." + courseResultSet.getString("course_name"));
		}
		System.out.println("Select any one course using number");
		Scanner scanner = new Scanner(System.in);
		int courseID = scanner.nextInt();

		String selectedBranch = "UPDATE student_details SET branch_name = (SELECT b.branch_name FROM branches b WHERE b.branch_id = ?), course_name = (SELECT c.course_name FROM courses c WHERE c.course_id = ? ) WHERE email = ?";

		PreparedStatement selectedPreparedStatement = connection.prepareStatement(selectedBranch);

		selectedPreparedStatement.setInt(1, branchID);
		selectedPreparedStatement.setInt(2, courseID);
		selectedPreparedStatement.setString(3, email);

		int rowsAffected = selectedPreparedStatement.executeUpdate();

		if (rowsAffected >= 1) {
			StudentDetails details = new StudentDetails();
			details.getStudentDetails(email);
		} else {
			System.out.println("failed update database");
		}
	}
}
