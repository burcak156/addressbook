package org.freesoftware.dao;

import java.util.List;

import org.freesoftware.model.TelNumbers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TelNumbersDAOImpl implements TelNumbersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTelNumbers(List<TelNumbers> telNumbers) {
		for (int i = 0; i < telNumbers.size(); i++) {
			sessionFactory.getCurrentSession().saveOrUpdate(telNumbers.get(i));
		}
	}
}
