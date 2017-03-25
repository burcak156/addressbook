package org.freesoftware.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.freesoftware.model.Person;
import org.freesoftware.service.PersonService;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "personBean")
@SessionScoped
public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String address;
	private String eMail;
	private Date birthday;
	private String departmentName;
	private String gender;
	private boolean skip;

	Person person = new Person();

	@ManagedProperty(value = "#{personServiceImpl}")
	transient PersonService personServiceImpl;

	@ManagedProperty(value = "#{telNumbersBean}")
	private TelNumbersBean telNumbersBean;

	public TelNumbersBean getTelNumbersBean() {
		return telNumbersBean;
	}

	public void setTelNumbersBean(TelNumbersBean telNumbersBean) {
		this.telNumbersBean = telNumbersBean;
	}

	public PersonService getPersonServiceImpl() {
		return personServiceImpl;
	}

	public void setPersonServiceImpl(PersonService personServiceImpl) {
		this.personServiceImpl = personServiceImpl;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	// @PostConstruct
	public void addPerson() {
		person.setName(getName());
		person.setSurname(getSurname());
		person.seteMail(geteMail());
		person.setDepartmentName(getDepartmentName());
		person.setGender(getGender());
		person.setBirthday(getBirthday());
		person.setAddress(getAddress());
		try {
			personServiceImpl.addPerson(person);
			telNumbersBean.addTelNumbers(person);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "item added to the master successfully",
					"success");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
