package org.freesoftware.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telnumbers")
public class TelNumbers {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="telId")
	private long telId;
	@Column(name="telnumber")
	private String telNumber;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="person_personId", referencedColumnName="personId")
	private Person person;

	public long getTelId() {
		return telId;
	}

	public void setTelId(long telId) {
		this.telId = telId;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
