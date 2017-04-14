package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import config.HibernateSessionFactory;
import entity.Classes;
import entity.Score;
import entity.Student;

public class ScoreDao extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Session session;
	private Query query;
	private Transaction transaction;
	
	
	@SuppressWarnings("unchecked")
	public List<Score> getAllScore(){
		List<Score> allScore = new ArrayList<Score>();
		String hql = "from Score as s";
		session = HibernateSessionFactory.getSession();
		query = session.createQuery(hql);
		allScore = query.list();
		HibernateSessionFactory.closeSession();
		return allScore;
	}
	
	
	
	// 保存分数
		public void saveScore(Score score, Student student, Classes classes) {
			session = HibernateSessionFactory.getSession();
			try {
				transaction = session.beginTransaction();
				score.setStudent(student);
				score.setClasses(classes);
				score.setScore(80);
				session.save(score);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			HibernateSessionFactory.closeSession();
		}
		// 删除选课
		public String deleteClasses(int scoreId) {
			System.out.println("ScoreId"+scoreId);
			session = HibernateSessionFactory.getSession();
			try {
				transaction = session.beginTransaction();
				query = session.createQuery("delete from Score where scoreId = '"+scoreId+"'");
				query.executeUpdate();
				transaction.commit();
				return "y";
			} catch (Exception e) {
				e.printStackTrace();
				return "n";
			}finally {
				HibernateSessionFactory.closeSession();
			}
		}
	
}
