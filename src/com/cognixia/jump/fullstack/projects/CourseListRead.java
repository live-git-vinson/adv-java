package com.cognixia.jump.fullstack.projects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class CourseListRead {

	@SuppressWarnings("unchecked")
	public static List<Course> readCourses(ObjectInputStream objectInputStream)
			throws ClassNotFoundException, IOException {
		return (List<Course>) objectInputStream.readObject();
	}
}
