package com.cognixia.jump.fullstack.projects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CourseListWrite {

	public static void writeCourses(ObjectOutputStream objectOutputStream, List<Course> courseList) throws IOException {
		System.out.println("Written Object " + courseList.toString());

		objectOutputStream.writeObject(courseList);
	}
}
