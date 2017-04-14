package action.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Usermanager;
import entity.Student;

public class UpdateStudent extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tel;// 修改的电话
	private String email;// 修改的邮箱

	private String oldPwd;// 修改的原始密码
	private String newPwd1;// 要修改的密码
	private String newPwd2;// 确认密码

	private HttpServletRequest request = null;

	private Usermanager um;

	private Student st;

	private HttpSession session = null;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd1() {
		return newPwd1;
	}

	public void setNewPwd1(String newPwd1) {
		this.newPwd1 = newPwd1;
	}

	public String getNewPwd2() {
		return newPwd2;
	}

	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}

	@Override
	public String execute() throws Exception {

		session = getSession();

		String sno = (String) session.getAttribute("sno");
		um = new Usermanager();
		try {
			st = um.getStudent(um.getStudent1(sno).getStId());
			st.setTel(getTel());
			st.setEmail(getEmail());
			um.updateStudent(st);
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

		return SUCCESS;
	}

	public String updatePwd() throws Exception {
		session = getSession();
		String sno = (String) session.getAttribute("sno");
		um = new Usermanager();
		st = um.getStudent(um.getStudent1(sno).getStId());
		try {
			if (!this.getOldPwd().equals(st.getPassword())) {
				System.out.println("密码输入不正确");
			} else if (!this.getNewPwd1().equals(this.getNewPwd2())) {
				System.out.println("两次密码输入不一致");
			} else {
				st.setPassword(this.getNewPwd1());
				um.updateStudent(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

		return SUCCESS;
	}

	private HttpSession getSession() {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;

	}
}
