package ua.newhouses.club.dto;

import java.util.ArrayList;
import java.util.Date;



public class MemberDTO {

	private String name;
	private long id;
	private String sname;
	private String date;
	private String aboutme;
	private ArrayList<CarDTO> cars;
	private String email;
	private Date Registeredon;
	private String password;
	
	public MemberDTO() {
	}
	
	public String toString() {
		return "Name: " + name +" "+ "Sname: " + sname+" "+"Id: "+id+" "+"Date: "+date+" "+"AboutMe: "+aboutme;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
		
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname=sname;
		
	}
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date=date;
		
	}
	public String getAboutme() {
		return aboutme;
	}
	
	public void setAboutme(String aboutme) {
		this.aboutme=aboutme;
		
	}


	public ArrayList<CarDTO> getCars() {
		return cars;
	}


	public void setCars(ArrayList<CarDTO> cars) {
		this.cars = cars;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}


	public Date getRegisteredon() {
		return Registeredon;
	}


	public void setRegisteredon(Date registeredon) {
		Registeredon = registeredon;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	
}
