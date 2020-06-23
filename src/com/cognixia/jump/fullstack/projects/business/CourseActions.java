package com.cognixia.jump.fullstack.projects.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.fullstack.projects.Course;
import com.cognixia.jump.fullstack.projects.repository.CourseListRead;
import com.cognixia.jump.fullstack.projects.repository.CourseListWrite;

public class CourseActions {

	static File file = new File("CourseDB.dat");
	static List<Course> courseList = new ArrayList<Course>();
	static CourseListWrite courseListWrite;
	static CourseListRead courseListRead;

	public CourseActions() throws IOException {
		courseListWrite = new CourseListWrite();
		courseListRead = new CourseListRead();
	}

	public void close() throws IOException {
		courseListWrite.close();
		courseListRead.close();
	}

	public void addToCourseList() throws ClassNotFoundException, IOException {

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

	public void removeFromCourseList() throws ClassNotFoundException, IOException {

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

	public void updateCourseList() throws ClassNotFoundException, IOException {
		// reads from file
		courseList = courseListRead.readCourses();

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

		// get new course info to add
		Course updatedCourse = new Course("Math101", 101, "Jeff Biggs", "August 4, 2020", "MTWThF");
		courseList.add(updatedCourse);

		// Write back to file
		courseListWrite.writeCourses(courseList);
		System.out.println("Course updated");
	}

	public void displayCourseList() throws ClassNotFoundException, IOException {
		// reads from file
		courseList = courseListRead.readCourses();
		// Display using toString

		System.out.println(courseList.toString());
	}

	public void initializeCourse() throws ClassNotFoundException, IOException {
		Course math = new Course("Math", 102, "Bob Nevers", "Today", "MWF");
		Course Science = new Course("Science", 103, "Bob Hill", "Today", "MWF");
		courseList.add(math);
		courseList.add(Science);
		courseListWrite.writeCourses(courseList);
	}
}
