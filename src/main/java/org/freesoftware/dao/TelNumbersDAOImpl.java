package org.freesoftware.dao;

import java.util.List;

import org.freesoftware.model.TelNumbers;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Override
	public void addOneTelNumber(TelNumbers telNumber) {
		sessionFactory.getCurrentSession().saveOrUpdate(telNumber);
	}

	@Override
	public void deleteOneTelNumber(TelNumbers telNumber) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM TelNumbers " + "WHERE telnumber = :tel_number and person_personId = :personId";
		Query query = session.createQuery(hql);
		query.setParameter("tel_number", telNumber.getTelNumber());
		query.setParameter("personId", telNumber.getPerson().getPersonId());
		query.executeUpdate();
	}
}
