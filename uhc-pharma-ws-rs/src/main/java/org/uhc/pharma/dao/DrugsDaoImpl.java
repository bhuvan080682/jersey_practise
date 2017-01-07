package org.uhc.pharma.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.uhc.pharma.model.DrugsBean;
import org.uhc.pharma.util.HibernateUtil;

public class DrugsDaoImpl implements DrugsDao {
	SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	@Override
	public List<DrugsBean> findAllDrugs() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from DrugsBean");
		List<DrugsBean> response = query.list();
		return response;
	}

	@Override
	public DrugsBean findDrug(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		DrugsBean drug = session.get(DrugsBean.class, id);
		return drug;
	}

	@Override
	public int save(DrugsBean drug) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int id =  (int) session.save(drug);
		session.getTransaction().commit();
		session.flush();
		session.close();
		return id;
	}

	@Override
	public void update(DrugsBean drug) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(drug);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DrugsBean> findDrugsByFiltering(String company, String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from DrugsBean where company = ? and name like ?");
		query.setString(0, company);
		query.setString(1, name);
		List<DrugsBean> drugs = query.list();
		return drugs;
	}

}
