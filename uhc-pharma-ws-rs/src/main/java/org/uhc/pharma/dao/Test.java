package org.uhc.pharma.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.uhc.pharma.controller.DrugsController;
import org.uhc.pharma.model.DrugsBean;
import org.uhc.pharma.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		//DrugsBean d1 = new DrugsBean("DOLO 650", "Paracetamol 650 mg", "Micro Labs");
		SessionFactory sf = HibernateUtil.getInstance().getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		DrugsBean d1 = new DrugsBean("DOLO 650", "Paracetamol 650 mg", "Micro Labs");
		session.save(d1);
		DrugsBean drug = session.get(DrugsBean.class, 1);
		System.out.println("Id : "+drug.getId());
		System.out.println("Name : "+drug.getName());
		//session.save(d1);
		session.getTransaction().commit();
		session.flush();
		session.close();sf.close();
		
		/*DrugsController controller = new DrugsController();
		controller.getDrugById(1);*/

	}

}
