package org.freesoftware.service;

import java.util.List;

import org.freesoftware.dao.TelNumbersDAO;
import org.freesoftware.model.TelNumbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelNumbersServiceImpl implements TelNumbersService {

	@Autowired
	private TelNumbersDAO telNumbersDAO;

	@Transactional
	@Override
	public void addTelNumbers(List<TelNumbers> telNumbers) {

		telNumbersDAO.addTelNumbers(telNumbers);
	}

	@Transactional
	@Override
	public List<TelNumbers> getTelNumbers(long personId) {
		return telNumbersDAO.getTelNumbers(personId);
	}

	@Transactional
	@Override
	public void addOneTelNumber(TelNumbers telNumber) {
		telNumbersDAO.addOneTelNumber(telNumber);
	}

	@Transactional
	@Override
	public void deleteOneTelNumber(TelNumbers telNumber) {
		telNumbersDAO.deleteOneTelNumber(telNumber);
	}

	@Transactional
	@Override
	public void deleteTelNumbers(long personId) {
		telNumbersDAO.deleteTelNumbers(personId);
	}
}
