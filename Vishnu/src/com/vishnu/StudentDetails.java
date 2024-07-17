package com.vishnu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDetails {
	public void getStudentDetails(String email) throws SQLException {
		Connection connection = JdbcConnection.establishDatabaseConnection();

		String allDetails = "SELECT * FROM student_details sd  WHERE sd.email = ?";

		PreparedStatement allDetailsPreparedStatement = connection.prepareStatement(allDetails);

		allDetailsPreparedStatement.setString(1, email);

		ResultSet allDetailsResultSet = allDetailsPreparedStatement.executeQuery();
		while (allDetailsResultSet.next()) {
			System.out.println("==================");
			System.out.println("Your Profile:");
			System.out.println("==================");
			System.out.println("student_id:" + allDetailsResultSet.getString("student_id") + "\n" + "First_name:"
					+ allDetailsResultSet.getString("first_name") + "\n" + "Last_name:"
					+ allDetailsResultSet.getString("last_name") + "\n" + "Email:"
					+ allDetailsResultSet.getString("email") + "\n" + "BranchName:"
					+ allDetailsResultSet.getString("branch_name") + "\n" + "courseName:"
					+ allDetailsResultSet.getString("course_name"));
		}
	}
}
