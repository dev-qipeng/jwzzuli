package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Teacher;

public class TeacherDao {

	private Session session;
	private Transaction transaction;
	private Query query;

	// 保存教师
	public void saveTeacher(Teacher tc) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.save(tc);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
	}

	// 更新教师
	public void updateTeacher(Teacher tc) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.update(tc);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
	}

	// 删除教师
	public void deleteTeacher(int tid) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.delete(session.get(Teacher.class, tid));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
	}

	// 获取教师对象
	public Teacher getTeacher(int tid) {
		session = HibernateSessionFactory.getSession();
		Teacher teacher = (Teacher) session.get(Teacher.class, tid);
		HibernateSessionFactory.closeSession();
		return teacher;
	}

	// 获取所有教师信息
	@SuppressWarnings("unchecked")
	public List<Teacher> allTeacher(int pageNumber) {
		List<Teacher> allTeacher = new ArrayList<Teacher>();
		String hql = "from Teacher as tc";
		query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1) * 10);
		query.setMaxResults(10);
		allTeacher = query.list();
		HibernateSessionFactory.closeSession();
		return allTeacher;
	}

	// 判断教师登陆的账号密码是否正确
	public boolean tcLogin(Teacher tc) {
		if (tc.getTeaId() != null && tc.getTpassword() != null) {
			session = HibernateSessionFactory.getSession();
			try {
				Query query = (Query) session.createQuery("from Teacher as t where t.teaId = '" + tc.getTeaId()
						+ "' and t.tpassword = '" + tc.getTpassword() + "'");
				Teacher t = (Teacher) query.uniqueResult();
				if (t != null) {
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

	// 按教师号获取一个教师信息
	public Teacher getTeacher1(String m) {
		session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Teacher as t where teaId='" + m + "'");
		Teacher tc = (Teacher) query.uniqueResult();// 当确定返回的实例只有一个或者null时
													// 用uniqueResult()方法
		HibernateSessionFactory.closeSession();
		return tc;
	}

	// 获取教师总数
	public int getTeacherAmount() {
		int teacherAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Teacher as tc";
		query = session.createQuery(hql);
		long count = (Long) query.uniqueResult();
		teacherAmount = (int) count;
		HibernateSessionFactory.closeSession();
		return teacherAmount;
	}
}
