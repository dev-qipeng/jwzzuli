package entity;

import java.io.Serializable;

public class Score implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer scoreId;
	private Integer score;
	private Student student;
	private Classes classes;

	public Score(Integer scoreId, Integer score, Student student, Classes classes) {
		super();
		this.scoreId = scoreId;
		this.score = score;
		this.student = student;
		this.classes = classes;
	}

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

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

}
