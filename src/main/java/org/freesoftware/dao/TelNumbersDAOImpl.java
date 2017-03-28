package org.freesoftware.dao;

import java.util.List;

import org.freesoftware.model.TelNumbers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TelNumbersDAOImpl implements TelNumbersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTelNumbers(List<TelNumbers> telNumbers) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Tel no size:" + telNumbers);
		for (int i = 0; i < telNumbers.size(); i++) {
			session.save(telNumbers.get(i));
			session.flush();
			session.clear();
		}
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<TelNumbers> getTelNumbers(long personId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TelNumbers.class);
		cr.add(Restrictions.eq("person.personId", personId));
		return cr.list();
	}

}
