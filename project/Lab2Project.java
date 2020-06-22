package com.cognixia.jump.fullstack.projects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Lab2Project {

	static File file = new File("CourseDB.dat");
	static List<Course> courseList = new ArrayList<Course>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
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
				addToCourseList(objectInputStream, objectOutputStream, fileOutputStream);
				break;
			case 2:
				System.out.println("Update a course");
				updateCourseList(objectInputStream, objectOutputStream);
				break;
			case 3:
				System.out.println("Remove a course");
				removeFromCourseList(objectInputStream, objectOutputStream);
				break;
			case 4:
				System.out.println("List all Courses");
				displayCourseList(objectInputStream);
				break;
			case 5:
				System.out.println("Course List Initialized");
				initializeCourse(objectOutputStream);
				break;
			case 6:
				contProcess = false;
				break;
			default:
				System.out.println("Incorrect Option");
				break;
			}
		} while (contProcess);

		fileInputStream.close();
		objectInputStream.close();

		fileOutputStream.close();
		objectOutputStream.close();

		intScanner.closeScanner();

	}

	public static void addToCourseList(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream,
			FileOutputStream fileOutputStream) throws ClassNotFoundException, IOException {
		// reads from file
		courseList = CourseListRead.readCourses(objectInputStream);

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
		CourseListWrite.writeCourses(objectOutputStream, courseList);
		System.out.println("Course Added");
	}

	public static void removeFromCourseList(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream)
			throws ClassNotFoundException, IOException {

		// reads from file
		courseList = CourseListRead.readCourses(objectInputStream);

		// Ask which Course to remove
		int courseID = 0;
		// get course id
		courseID = 101;
		// look for a course with that id and remove it
		for (Course course : courseList) {
			if (course.ID == courseID) {
				courseList.remove(course);
			}
		}

		// Write back to file
		CourseListWrite.writeCourses(objectOutputStream, courseList);
		System.out.println("Course Removed");
	}

	public static void updateCourseList(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream)
			throws ClassNotFoundException, IOException {
		// reads from file
		courseList = CourseListRead.readCourses(objectInputStream);

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
		CourseListWrite.writeCourses(objectOutputStream, courseList);
		System.out.println("Course updated");
	}

	public static void displayCourseList(ObjectInputStream objectInputStream)
			throws ClassNotFoundException, IOException {
		// reads from file
		courseList = CourseListRead.readCourses(objectInputStream);
		// Display using toString

		System.out.println(courseList.toString());
	}

	public static void initializeCourse(ObjectOutputStream objectOutputStream)
			throws ClassNotFoundException, IOException {
		Course math = new Course("Math", 102, "Bob Nevers", "Today", "MWF");
		Course Science = new Course("Science", 103, "Bob Hill", "Today", "MWF");
		courseList.add(math);
		courseList.add(Science);
		objectOutputStream.writeObject(courseList);
	}
}
