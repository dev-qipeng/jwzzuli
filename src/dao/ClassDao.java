package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import config.HibernateSessionFactory;
import entity.Classes;
import entity.Student;

public class ClassDao implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Session session;
	private Query query;
	
	
	public List<Classes> getAllClasses(){
		List<Classes> allClasses = new ArrayList<Classes>();
		String hql = "from Classes as cs";
		session = HibernateSessionFactory.getSession();
		query = session.createQuery(hql);
		allClasses = query.list();
		HibernateSessionFactory.closeSession();
		return allClasses;
	}
	public Classes getClasses(String csId){
		session = HibernateSessionFactory.getSession();
		String hql = "from Classes as cs where csId = '"+csId+"'";
		Query query = session.createQuery(hql);
		Classes cs = (Classes) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return cs;
	}
	
}
