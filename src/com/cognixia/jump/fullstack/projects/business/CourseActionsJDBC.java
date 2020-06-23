package com.cognixia.jump.fullstack.projects.business;

import java.io.IOException;

import com.cognixia.jump.fullstack.projects.Course;
import com.cognixia.jump.fullstack.projects.repository.CourseWriteJDBC;

public class CourseActionsJDBC {

	public CourseActionsJDBC() {

	}

	public void addToCourseList() {

		// Take Info for a course
		String name = "Math";
		int iD = 101;
		String professorString = "Bill Powers";
		String startDate = "August 4 2020";
		String daysOfTheWeek = "MTWThF";

		// Call writeCourse passing it the command
		Course newCourse = new Course(name, iD, professorString, startDate, daysOfTheWeek);
		CourseWriteJDBC.writeCourse("insert into courses values(" + newCourse.ID + ", '" + newCourse.name + "', '"
				+ newCourse.professorString + "', '" + newCourse.startDate + "', '" + newCourse.daysOfTheWeek + "')");

		System.out.println("Course Added");
	}

	public void removeFromCourseList() throws ClassNotFoundException, IOException {

		// Ask which Course to remove

		// get course id
		int removeCourseID = 102;

		// call writeCourse and pass the command
		CourseWriteJDBC.writeCourse("delete from courses where course_id = " + removeCourseID);
		System.out.println("Course removed");
	}

	public void updateCourseList() throws ClassNotFoundException, IOException {

		// get course id
		int updateCourseID = 102;

		// Take Info for a course
		String professorString = "George Meloncholy";
		// look for a course with that id and remove it

		CourseWriteJDBC.writeCourse(
				"update courses set professor_name = '" + professorString + "' where course_id = " + updateCourseID);
	}

	public void displayCourseList() throws ClassNotFoundException, IOException {

		CourseWriteJDBC.readCourseNames();
	}

}
