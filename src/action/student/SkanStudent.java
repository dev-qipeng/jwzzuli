package action.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Usermanager;
import entity.Student;

public class SkanStudent extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String sno;
	private String email;
	private String tel;
	private String mark;
	private String sex;
	private String department;
	private String jiguan;
	private String password;
	private String image;

	private HttpServletRequest request;
	private HttpSession session;
	private Student st;
	private Usermanager um;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String execute() throws Exception {
		session = getSession();
		String sno = (String) session.getAttribute("sno");
		um = new Usermanager();
		try {
			st = um.getStudent1(sno);
			session.setAttribute("student", st);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}

	public String forUpdate() throws Exception {
		session = getSession();
		String sno = (String) session.getAttribute("sno");
		um = new Usermanager();
		try {
			st = um.getStudent1(sno);
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

		session.setAttribute("a_studentObj_for_update", st);
		return SUCCESS;
	}

	private HttpSession getSession() {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;

	}
}
