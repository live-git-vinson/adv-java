package com.cognixia.jump.fullstack.projects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab2Project {

	static File file = new File("CourseDB.dat");
	static List<Course> courseList = new ArrayList<Course>();
	static CourseListWrite courseListWrite;

	static CourseListRead courseListRead;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		courseListWrite = new CourseListWrite();
		courseListRead = new CourseListRead();

		GetInteger intScanner = new GetInteger();
		boolean contProcess = true;
		do {
			// ask the user what they want to do and call that function
			System.out.println("Please Choose an Option:");
			System.out.println("1: Add a Course");
			System.out.println("2: Update a course");
			System.out.println("3: Remove a course");
			System.out.println("4: Display course list");
			System.out.println("5: Initialize course list");
			System.out.println("6: Exit");

			int userInput = intScanner.getInt();

			switch (userInput) {

			case 1:
				System.out.println("Add a course");
				addToCourseList();
				break;
			case 2:
				System.out.println("Update a course");
				updateCourseList();
				break;
			case 3:
				System.out.println("Remove a course");
				removeFromCourseList();
				break;
			case 4:
				System.out.println("List all Courses");
				displayCourseList();
				break;
			case 5:
				System.out.println("Course List Initialized");
				initializeCourse();
				break;
			case 6:
				contProcess = false;
				break;
			default:
				System.out.println("Incorrect Option");
				break;
			}
		} while (contProcess);

		courseListWrite.close();

		courseListRead.close();

		intScanner.closeScanner();

	}

	public static void addToCourseList() throws ClassNotFoundException, IOException {
		// reads from file
		courseList = courseListRead.readCourses();

		// Take Info for a course
		String name = "Math";
		int iD = 101;
		String professorString = "Bill Powers";
		String startDate = "August 4, 2020";
		String daysOfTheWeek = "MTWThF";

		// add course to courseList
		Course newCourse = new Course(name, iD, professorString, startDate, daysOfTheWeek);
		courseList.add(newCourse);

		// Write courseList to file.
		courseListWrite.writeCourses(courseList);
		System.out.println("Course Added");
	}

	public static void removeFromCourseList() throws ClassNotFoundException, IOException {

		// reads from file
		courseList = courseListRead.readCourses();

		// Ask which Course to remove

		// get course id
		int removeCourseID = 102;
		// look for a course with that id and remove it

		boolean found = false;
		for (Course course : courseList) {
			System.out.println(removeCourseID + " " + course.ID);
			if (course.ID == removeCourseID) {
				found = true;
				System.out.println(found);
				courseList.remove(course);
			}
		}
		if (found) {
			// Write back to file
			courseListWrite.writeCourses(courseList);
			System.out.println("Course Removed");

		} else {
			System.out.println("No Course that matches description");

			System.out.println(found);
		}
	}

	public static void updateCourseList() throws ClassNotFoundException, IOException {
		// reads from file
		courseList = courseListRead.readCourses();

		// Ask which Course to update
		int courseID = 0;
		// get course id
		courseID = 101;
		// look for a course with that id and remove it
		for (Course course : courseList) {
			if (course.ID == courseID) {
				courseList.remove(course);
			}
		}

		// get new course info to add
		Course updatedCourse = new Course("Math101", 101, "Jeff Biggs", "August 4, 2020", "MTWThF");
		courseList.add(updatedCourse);

		// Write back to file
		courseListWrite.writeCourses(courseList);
		System.out.println("Course updated");
	}

	public static void displayCourseList() throws ClassNotFoundException, IOException {
		// reads from file
		courseList = courseListRead.readCourses();
		// Display using toString

		System.out.println(courseList.toString());
	}

	public static void initializeCourse() throws ClassNotFoundException, IOException {
		Course math = new Course("Math", 102, "Bob Nevers", "Today", "MWF");
		Course Science = new Course("Science", 103, "Bob Hill", "Today", "MWF");
		courseList.add(math);
		courseList.add(Science);
		courseListWrite.writeCourses(courseList);
	}
}
