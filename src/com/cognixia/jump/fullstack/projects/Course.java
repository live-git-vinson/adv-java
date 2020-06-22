package com.cognixia.jump.fullstack.projects;

import java.io.Serializable;

public class Course implements Serializable {
	public String name;
	public int ID;
	public String professorString;
	public String startDate;
	public String daysOfTheWeek;

	public Course(String name, int iD, String professorString, String startDate, String daysOfTheWeek) {
		super();
		this.name = name;
		this.ID = iD;
		this.professorString = professorString;
		this.startDate = startDate;
		this.daysOfTheWeek = daysOfTheWeek;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", ID=" + ID + ", professorString=" + professorString + ", startDate="
				+ startDate + ", daysOfTheWeek=" + daysOfTheWeek + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProfessorString() {
		return professorString;
	}

	public void setProfessorString(String professorString) {
		this.professorString = professorString;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDaysOfTheWeek() {
		return daysOfTheWeek;
	}

	public void setDaysOfTheWeek(String daysOfTheWeek) {
		this.daysOfTheWeek = daysOfTheWeek;
	}

}
