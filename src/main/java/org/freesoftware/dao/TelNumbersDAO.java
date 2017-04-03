package org.freesoftware.dao;

import java.util.List;

import org.freesoftware.model.TelNumbers;

public interface TelNumbersDAO {
	
	public void addTelNumbers(List<TelNumbers> telNumbers);

	public List<TelNumbers> getTelNumbers(long personId);

	public void addOneTelNumber(TelNumbers telNumber);
	
	public void deleteOneTelNumber(TelNumbers telNumber);
	
	public void deleteTelNumbers(long personId);
}