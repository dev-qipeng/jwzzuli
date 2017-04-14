package action.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.ScoreDao;
import entity.Classes;
import entity.Score;
import entity.Student;

/*
 * 成绩查询
 */
public class QueryScore extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer scoreId;
	private Integer score;
	private Student student;
	private Classes classes;

	private HttpServletRequest request;

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String sno = (String)session.getAttribute("sno");
		ScoreDao sd = new ScoreDao();
		List<Score> allScore = sd.getAllScore();

		if (allScore == null || allScore.size() == 0) {
			System.out.println("allScore为空");
			return INPUT;
		} else {
			List<Score> list = new ArrayList<Score>();
			for (int i = allScore.size() - 1; i >= 0; i--) {
				Score s = (Score) allScore.get(i);
				System.out
						.println("输出的student对象：" + s.getStudent() + "---输出getStudent()的SNo：" + s.getStudent().getSno());
				if (s.getStudent().getSno().equals(sno)) {
					list.add(s);
				} else {
					System.out.println("判断有错");
				}
			}
			session.setAttribute("usedScore", list);
			return SUCCESS;
		}
	}
}
