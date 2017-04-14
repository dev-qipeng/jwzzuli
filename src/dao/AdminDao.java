package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Admin;

public class AdminDao {
	private Session session;
	private Transaction transaction;
	// 判断管理员登陆的账号密码是否正确
	public boolean adminLogin(Admin ad) {
		if (ad.getUsername() != null && ad.getPassword() != null) {
			session = HibernateSessionFactory.getSession();
			System.out.println("session获取"+session==null);
			try {
				Query query = (Query) session.createQuery("from Admin as a where a.username = '" + ad.getUsername()
						+ "' and a.password = '" + ad.getPassword() + "'");
				Admin a = (Admin) query.uniqueResult();
				if (a != null) {
					HibernateSessionFactory.closeSession();
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateSessionFactory.closeSession();
		}
		return false;
	}

	//根据username获取管理员
	public Admin getAdmin(String m) {
		session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Admin as a where a.username='" + m + "'");
		Admin ad = (Admin) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return ad;
	}

	//保存管理员
	public void saveAdmin(Admin a) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
