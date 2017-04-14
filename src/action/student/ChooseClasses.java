package action.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.ClassDao;
import dao.ScoreDao;
import dao.Usermanager;
import entity.Classes;
import entity.Score;
import entity.Student;

/**
 * 选课
 * 
 * @author DELL001
 *
 */
public class ChooseClasses extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String csId;

	private HttpServletRequest request;
	private HttpSession session;

	private Integer scoreId;

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	@Override
	public String execute() throws Exception {
		session = getSession();
		ClassDao cd = new ClassDao();
		try {
			List<Classes> allClasses = cd.getAllClasses();
			session.setAttribute("allClasses", allClasses);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}

	/*
	 * 选修课程--添加一条score记录
	 */
	public String xuanXiu() throws Exception {
		session = getSession();
		System.out.println("是否取到" + this.getCsId());
		List<Score> scoreList = getScore();

		if (scoreList != null) {
			for (Score score : scoreList) {
				if (score.getClasses().getCsId().toString().equals(this.getCsId())) {
					return INPUT;
				}
			}
		}
		try {
			ScoreDao sd = new ScoreDao();
			Usermanager u = new Usermanager();
			ClassDao cd = new ClassDao();

			// 获取学生和课程对象，为了添加成绩记录
			Student student = u.getStudent(u.getStudent1((String) session.getAttribute("sno")).getStId());
			Classes classes = cd.getClasses(csId);

			System.out.println("学号:" + student.getStId());
			System.out.println("课程:" + classes.getCsId());

			Score score = new Score();
			sd.saveScore(score, student, classes);// 执行添加成绩

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}

	/*
	 * 查看已选课程
	 */
	public String yiXuan() throws Exception {
		List<Score> score = getScore();
		if (score != null) {
			session.setAttribute("lookYiXuan", score);
			return SUCCESS;
		} else
			return INPUT;
	}

	/*
	 * 删除指定课程
	 */
	public String deleteCourse() throws Exception {

		System.out.println("ScoreId" + scoreId);
		ScoreDao sd = new ScoreDao();
		try {
			String msg = sd.deleteClasses(scoreId);
			if (msg.equals("y")) {
				System.out.println("删除成功");
				return SUCCESS;
			} else {
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}

	private HttpSession getSession() {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;

	}

	private List<Score> getScore() {
		session = getSession();
		String sno = (String) session.getAttribute("sno");
		ScoreDao sd = new ScoreDao();
		List<Score> allScore = sd.getAllScore();

		if (allScore == null || allScore.size() == 0) {
			System.out.println("allScore为空");
		} else {
			List<Score> list = new ArrayList<Score>();
			for (int i = allScore.size() - 1; i >= 0; i--) {
				Score s = (Score) allScore.get(i);
				if (s.getStudent().getSno().equals(sno)) {
					list.add(s);
				}
			}
			return list;
		}
		return null;
	}

}
