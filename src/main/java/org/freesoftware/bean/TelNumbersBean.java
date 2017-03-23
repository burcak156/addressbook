package org.freesoftware.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.freesoftware.model.Person;
import org.freesoftware.model.TelNumbers;
import org.freesoftware.service.TelNumbersService;

@ManagedBean(name = "telNumbersBean")
@SessionScoped
public class TelNumbersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TelNumbers telNumbers = new TelNumbers();
	private List<String> telNumbersList = new ArrayList<String>();
	private String telNumber;
	private Person person;


	@ManagedProperty(value = "#{telNumbersServiceImpl}")
	transient TelNumbersService telNumbersServiceImpl;

	public TelNumbersService getTelNumbersServiceImpl() {
		return telNumbersServiceImpl;
	}

	public void setTelNumbersServiceImpl(TelNumbersService telNumbersServiceImpl) {
		this.telNumbersServiceImpl = telNumbersServiceImpl;
	}

	public List<String> getTelNumbers() {
		return telNumbersList;
	}

	public void setTelNumbers(List<String> telNumbersList) {
		this.telNumbersList = telNumbersList;
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
