package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Classes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer csId;
	private String cname;
	private String cmark;
	private String courTime;
	private String roomId;
	private String teaId;
	private Integer chooseMax;
	private Integer chooseCurNum;
	private Set<Score> score = new HashSet<Score>();

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmark() {
		return cmark;
	}

	public void setCmark(String cmark) {
		this.cmark = cmark;
	}

	public String getCourTime() {
		return courTime;
	}

	public void setCourTime(String courTime) {
		this.courTime = courTime;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public Integer getChooseMax() {
		return chooseMax;
	}

	public void setChooseMax(Integer chooseMax) {
		this.chooseMax = chooseMax;
	}

	public Integer getChooseCurNum() {
		return chooseCurNum;
	}

	public void setChooseCurNum(Integer chooseCurNum) {
		this.chooseCurNum = chooseCurNum;
	}

	

	public Set<Score> getScore() {
		return score;
	}

	public void setScore(Set<Score> score) {
		this.score = score;
	}

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(String cname, String cmark, String courTime, String roomId, String teaId, Integer chooseMax,
			Integer chooseCurNum) {
		super();
		this.cname = cname;
		this.cmark = cmark;
		this.courTime = courTime;
		this.roomId = roomId;
		this.teaId = teaId;
		this.chooseMax = chooseMax;
		this.chooseCurNum = chooseCurNum;
	}

}
