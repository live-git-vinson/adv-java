package com.cognixia.jump.fullstack.projects.view;

import java.io.IOException;

import com.cognixia.jump.fullstack.projects.business.CourseActionsJDBC;
import com.cognixia.jump.fullstack.projects.business.GetInteger;

public class UserInterfaceJDBC {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		GetInteger intScanner = new GetInteger();

		CourseActionsJDBC courseActionsJDBC = new CourseActionsJDBC();

		boolean contProcess = true;
		do {
			// ask the user what they want to do and call that function
			System.out.println("Please Choose an Option:");
			System.out.println("1: Add a Course");
			System.out.println("2: Update a course");
			System.out.println("3: Remove a course");
			System.out.println("4: Display course list");
			System.out.println("5: Exit");

			int userInput = intScanner.getInt();

			switch (userInput) {

			case 1:
				System.out.println("Add a course");
				courseActionsJDBC.addToCourseList();
				break;
			case 2:
				System.out.println("Update a course");
				courseActionsJDBC.updateCourseList();
				break;
			case 3:
				System.out.println("Remove a course");
				courseActionsJDBC.removeFromCourseList();
				break;
			case 4:
				System.out.println("List all Courses");
				courseActionsJDBC.displayCourseList();
				break;
			case 5:
				contProcess = false;
				break;
			default:
				System.out.println("Incorrect Option");
				break;
			}
		} while (contProcess);

		intScanner.closeScanner();
	}

}
