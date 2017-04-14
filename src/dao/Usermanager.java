package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateSessionFactory;
import entity.Classes;
import entity.Student;

/**
 * 数据控制类
 * 
 * @author DELL001
 *
 */
public class Usermanager {

	private Session session;
	private Transaction transaction;
	private Query query;

	// 保存学生
	public void saveStudent(Student st) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.save(st);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
	}

	// 更新学生
	public void updateStudent(Student st) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.update(st);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
	}

	// 删除学生
	public void deleteStudent(String sno) {
		session = HibernateSessionFactory.getSession();
		try {
			transaction = session.beginTransaction();
			session.delete(sno);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();
	}

	// 获取学生对象
	public Student getStudent(int stId) {
		session = HibernateSessionFactory.getSession();
		Student student = session.get(Student.class, stId);
		HibernateSessionFactory.closeSession();
		return student;
	}

	// 获取全部学生信息
	@SuppressWarnings("unchecked")
	public List<Student> allStudent(int pageNumber) {
		List<Student> allStudent = new ArrayList<Student>();
		String hql = "from Student as st";
		session = HibernateSessionFactory.getSession();
		query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1) * 10);
		query.setMaxResults(10);
		allStudent = query.list();
		HibernateSessionFactory.closeSession();
		return allStudent;
	}

	// 获取全部课程信息
	@SuppressWarnings("unchecked")
	public List<Classes> allClasses(int pageNumber) {
		List<Classes> allClasses = new ArrayList<Classes>();
		String hql = "from Classes as cs";
		session = HibernateSessionFactory.getSession();
		query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1) * 10);
		query.setMaxResults(10);
		allClasses = query.list();
		HibernateSessionFactory.closeSession();
		return allClasses;
	}
	//按学号获取一个学生信息
	public Student getStudent1(String m){
		session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as s where sno='"+m+"'");
		Student st = (Student)query.uniqueResult();//当确定返回的实例只有一个或者null时 用uniqueResult()方法
		HibernateSessionFactory.closeSession();
		return st;
	}
	
	//判断学生登陆的账号密码是否正确
	public boolean stuLogin(Student stu) {
		if (stu.getSno()!=null&&stu.getPassword()!=null) {
			session = HibernateSessionFactory.getSession();
			try{
			Query query = (Query)session.createQuery("from Student as s where sno = '"+stu.getSno()+"' and password = '"+stu.getPassword()+"'");
			Student s = (Student) query.uniqueResult();
			if (s!=null) {
				HibernateSessionFactory.closeSession();
				return true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			HibernateSessionFactory.closeSession();
		}
		return false;
	}
	
	//按标识获取一个学生信息
	public Student getStudent2(int stId) {
		session = HibernateSessionFactory.getSession();
		Query query = (Query)session.createQuery("from Student as s where stId = '"+stId+"'");
		Student st = (Student) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return st;
	}
	
	//获取学生总数
	public int getStudentAmount(){
		int studentAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Student as st";
		query = session.createQuery(hql);
		long count = (Long)query.uniqueResult();
		studentAmount = (int)count;
		HibernateSessionFactory.closeSession();
		return studentAmount;
	}
	
}
