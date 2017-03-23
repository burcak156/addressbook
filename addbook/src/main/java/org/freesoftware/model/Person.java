package org.freesoftware.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@SecondaryTable(name = "persondetails", pkJoinColumns = @PrimaryKeyJoinColumn(name = "personId"))
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "personId")
	private long personId;
	@Column(name = "name", table = "person")
	private String name;
	@Column(name = "surname", table = "person")
	private String surname;
	@Column(name = "address", table = "person")
	private String address;
	@Column(name = "email", table = "person")
	private String eMail;

	//-- PersonDetails secondary table
	
	@Column(name="departmentname", table="persondetails")
	private String departmentName;
	@Column(name="birthday", table="persondetails")
	private Date birthday;
	@Column(name="gender", table="persondetails")
	private String gender;
	
	public Person() {

	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
