package com.cognixia.jump.fullstack.projects.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.cognixia.jump.fullstack.projects.Course;

public class CourseListRead {

	static File file;
	static FileInputStream fileInputStream;
	static ObjectInputStream objectInputStream;

	public CourseListRead() throws IOException {
		file = new File("CourseDB.dat");
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
	}

	public List<Course> readCourses() throws ClassNotFoundException, IOException {
		System.out.println("reading object");
		System.out.println(objectInputStream.readObject().toString());
		List<Course> list = null;
		try {
			list = (List<Course>) objectInputStream.readObject();
		} catch (Exception e) {
			System.out.println("Error when reading courses");
		}
		return list;

	}

	public void close() throws IOException {
		fileInputStream.close();
		objectInputStream.close();
	}
}
