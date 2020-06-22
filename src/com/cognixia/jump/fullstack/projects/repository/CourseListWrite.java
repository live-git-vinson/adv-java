package com.cognixia.jump.fullstack.projects.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.cognixia.jump.fullstack.projects.Course;

public class CourseListWrite {

	static File file;
	static FileOutputStream fileOutputStream;
	static ObjectOutputStream objectOutputStream;

	public CourseListWrite() throws IOException {
		file = new File("CourseDB.dat");
		fileOutputStream = new FileOutputStream(file);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
	}

	public void writeCourses(List<Course> courseList) throws IOException {

		System.out.println("Written Object " + courseList.toString());

		objectOutputStream.writeObject(courseList);
	}

	public void close() throws IOException {
		fileOutputStream.close();
		objectOutputStream.close();
	}
}
