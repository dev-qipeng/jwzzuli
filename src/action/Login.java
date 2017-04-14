package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDao;
import dao.TeacherDao;
import dao.Usermanager;
import entity.Admin;
import entity.Student;
import entity.Teacher;

public class Login extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String sno;
	private Integer id;
	private String password;
	private Integer radiobutton;
	private HttpServletRequest request;

	Usermanager sm = new Usermanager();

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRadiobutton() {
		return radiobutton;
	}

	public void setRadiobutton(Integer radiobutton) {
		this.radiobutton = radiobutton;
	}

	@Override
	public String execute() throws Exception {
		if (radiobutton == 1) {
			Student s = new Student();
			s.setSno(getSno());
			s.setPassword(getPassword());
			if (sm.stuLogin(s)) {
				request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				Student sn = sm.getStudent1(sno);
				session.setAttribute("username", sn.getUsername());
				session.setAttribute("sno", this.sno);
				session.setAttribute("id", sn.getStId());
				return SUCCESS;
			}
			return INPUT;
		} else if (radiobutton == 2) {
			TeacherDao td = new TeacherDao();
			Teacher tc = new Teacher();
			tc.setTeaId(sno);
			tc.setTpassword(password);
			if (td.tcLogin(tc)) {
				request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				Teacher tec = td.getTeacher1(sno);
				session.setAttribute("tname", tec.getTname());
				session.setAttribute("tid", tec.getTid());
				return "tsuccess";
			}
			return INPUT;
		}else if (radiobutton == 3) {
			AdminDao ad = new AdminDao();
			Admin am = new Admin();
			am.setUsername(sno);
			am.setPassword(password);
			if (ad.adminLogin(am)) {
				request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				Admin adm = ad.getAdmin(sno);
				session.setAttribute("username", adm.getUsername());
				session.setAttribute("id", adm.getId());
				return "asuccess";
			}
			return INPUT;
		}else {
			return INPUT;
		}
	}

}
