package com.cognixia.jump.fullstack.projects.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseWriteJDBC {

	public static void writeCourse(String command) {

		// load the driver

		// create the connection
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_db", "root",
					"root");
			// create the statement
			Statement statement = connection.createStatement();

			// Fetch the results by executing the query
			statement.executeUpdate(command);
			System.out.println("Course update written.");

			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Prints all the courses
	public static void readCourseNames() {

		// load the driver

		// create the connection
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_db", "root",
					"root");

			// create the statement
			Statement statement = connection.createStatement();

			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from courses");

			// Iterate the resultSet
			while (resultSet.next()) {
				String courseNameString = resultSet.getString("course_name");
				String courseID = resultSet.getString("course_id");
				String professorName = resultSet.getString("professor_name");
				String startDate = resultSet.getString("start_date");
				String dayString = resultSet.getString("days_of_the_week");
				System.out.println(
						courseID + " " + courseNameString + " " + professorName + " " + startDate + " " + dayString);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
