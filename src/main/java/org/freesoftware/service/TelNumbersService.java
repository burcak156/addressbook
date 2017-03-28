package org.freesoftware.service;

import java.util.List;

import org.freesoftware.model.TelNumbers;

public interface TelNumbersService {

	public void addTelNumbers(List<TelNumbers> telNumbers);

	public List<TelNumbers> getTelNumbers(long personId);
}
