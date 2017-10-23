package com.naren.springmvc.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DataTable {
	
	private int id;
	@NotNull
	@Size(min=1,message="please enter your gender")
	private String gender;
	@NotNull()
	@Size(max=50,min=5,message="name too short min 5 characters")
	private String name;
	@NotNull
	@Size(min=1,message="enter your fave color")
	private String fave_color;
	
	
	public DataTable() {
		
	}

	public DataTable(String gender, String name, String fave_color) {
		this.gender = gender;
		this.name = name;
		this.fave_color = fave_color;
	}
	
	public DataTable(int id, String gender, String name, String fave_color) {
		this.id = id;
		this.gender = gender;
		this.name = name;
		this.fave_color = fave_color;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFave_color() {
		return fave_color;
	}
	public void setFave_color(String fave_color) {
		this.fave_color = fave_color;
	}
	@Override
	public String toString() {
		return "DataTable [id=" + id + ", gender=" + gender + ", name=" + name + ", fave_color=" + fave_color + "]";
	}
	
	

}
