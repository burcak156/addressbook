package org.freesoftware.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.freesoftware.model.Person;
import org.freesoftware.model.TelNumbers;
import org.freesoftware.service.TelNumbersService;

@ManagedBean(name = "telNumbersBean")
@ViewScoped
public class TelNumbersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String telNumber;
	private Person person;

	private Map<String, String> availableItems = new LinkedHashMap<String, String>();
	private List<String> selectedItems;
	public List<String> telNumbersList = new ArrayList<String>();

	TelNumbers telNumbers;

	List<TelNumbers> tel = new ArrayList<TelNumbers>();
	List<TelNumbers> selected = new ArrayList<TelNumbers>();

	@ManagedProperty(value = "#{telNumbersServiceImpl}")
	transient TelNumbersService telNumbersServiceImpl;

	public TelNumbersService getTelNumbersServiceImpl() {
		return telNumbersServiceImpl;
	}

	public void setTelNumbersServiceImpl(TelNumbersService telNumbersServiceImpl) {
		this.telNumbersServiceImpl = telNumbersServiceImpl;
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

	public Map<String, String> getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(Map<String, String> availableItems) {
		this.availableItems = availableItems;
	}

	public List<String> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<String> selectedItems) {
		this.selectedItems = selectedItems;
	}

	/*
	 * The New Record Pages Methods
	 * 
	 * All Tel Numbers insert to DB from List.
	 */

	public void addTelNumbers(Person person) {

		for (int i = 0; i < telNumbersList.size(); i++) {
			telNumbers = new TelNumbers();
			telNumbers.setPerson(person);
			telNumbers.setTelNumber(telNumbersList.get(i));
			tel.add(telNumbers);

		}

		try {
			telNumbersServiceImpl.addTelNumbers(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Tel Numbers, InputText to List in newrecord.xtml.
	 */

	public void addNumberToList() {

		if (!telNumbersList.contains(telNumber) && telNumber.length() > 0) {
			telNumbersList.add(telNumber);
			availableItems.put(telNumber, telNumber);
		}

	}

	public void removeFromList() {

		if (!selectedItems.isEmpty()) {
			for (int i = 0; i < selectedItems.size();) {
				for (int j = 0; j < telNumbersList.size(); j++) {
					if (selectedItems.isEmpty())
						break;
					if (selectedItems.get(i).equals(telNumbersList.get(j))) {
						telNumbersList.remove(j);
						availableItems.remove(selectedItems.get(i));
						selectedItems.remove(i);
					}
				}
			}
		}
	}

	/*
	 * The Update Pages Tel Numbers Methods.
	 */

	public void addNumberToDB() {

		if (!telNumbersList.contains(telNumber) && telNumber.length() > 0) {
			telNumbers = new TelNumbers();

			telNumbersList.add(telNumber);
			availableItems.put(telNumber, telNumber);

			telNumbers.setTelNumber(telNumbersList.get(telNumbersList.size() - 1));
			telNumbers.setPerson(getPerson());

			telNumbersServiceImpl.addOneTelNumber(telNumbers);
		}
	}

	public void removeNumberFromDB() {
		if (!selectedItems.isEmpty()) {
			for (int i = 0; i < selectedItems.size();) {
				for (int j = 0; j < telNumbersList.size(); j++) {
					if (selectedItems.isEmpty())
						break;
					if (selectedItems.get(i).equals(telNumbersList.get(j))) {
						telNumbers = new TelNumbers();
						telNumbers.setTelNumber(telNumbersList.get(j));
						telNumbers.setPerson(getPerson());
						telNumbersServiceImpl.deleteOneTelNumber(telNumbers);
						telNumbersList.remove(j);
						availableItems.remove(selectedItems.get(i));
						selectedItems.remove(i);

					}
				}
			}
		}
	}

	public void loadNumbers(long personId) {
		availableItems.clear();
		selected = telNumbersServiceImpl.getTelNumbers(personId);
		for (int i = 0; i < selected.size(); i++) {
			availableItems.put((selected.get(i)).getTelNumber(), (selected.get(i)).getTelNumber());
			telNumbersList.add(selected.get(i).getTelNumber());
		}
	}
	
	public void deleteTelNumbers(long personId) {
		telNumbersServiceImpl.deleteTelNumbers(personId);
	}
}
