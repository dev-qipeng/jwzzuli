package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stId;
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
	private Integer maxClasses;
	private Set<Score> score = new HashSet<Score>();

	public Student() {
	}

	public Student(String username, String sno) {
		this.username = username;
		this.sno = sno;
	}

	public Student(int stId, String username, String sno, String email, String tel, String mark, String sex,
			String department, String jiguan, String password, String image, Integer maxClasses) {
		this.stId = stId;
		this.username = username;
		this.sno = sno;
		this.email = email;
		this.tel = tel;
		this.mark = mark;
		this.sex = sex;
		this.department = department;
		this.jiguan = jiguan;
		this.password = password;
		this.image = image;
		this.maxClasses = maxClasses;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

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

	public Integer getMaxClasses() {
		return maxClasses;
	}

	public void setMaxClasses(Integer maxClasses) {
		this.maxClasses = maxClasses;
	}

	public Set<Score> getScore() {
		return score;
	}

	public void setScore(Set<Score> score) {
		this.score = score;
	}

}
