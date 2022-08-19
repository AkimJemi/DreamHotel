package board.model;

import java.sql.Date;

public class Consultation {

	private int no;
	private int grno;
	private int grgrod;
	private int depth;
	private String title;
	private String contents;
	private String name;
	private String passwd;
	private String lock_flag;
	private String delete_flag;
	private Date created_at;
	private Date updated_at;

	
	
	public Consultation(Consultation consultation) {
		this.no = consultation.getNo();
		this.title = consultation.getTitle();
		this.contents = consultation.getContents();
		this.name = consultation.getName();
		this.passwd = consultation.getPasswd();
	}

	public Consultation(int no, int grno, int grgrod, String title, String contents, String name, String delete_flag,
			Date created_at, Date updated_at) {
		this.no = no;
		this.grno = grno;
		this.grgrod = grgrod;
		this.title = title;
		this.contents = contents;
		this.name = name;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Consultation(int no, String title, String contents, String name, String passwd) {
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.name = name;
		this.passwd = passwd;
	}

	public Consultation() {
	}

	public Consultation(int no, int grno, int grgrod, int depth, String title, String contents, String name,
			String passwd, String lock_flag, String delete_flag, Date created_at, Date updated_at) {
		this.no = no;
		this.grno = grno;
		this.grgrod = grgrod;
		this.depth = depth;
		this.title = title;
		this.contents = contents;
		this.name = name;
		this.passwd = passwd;
		this.lock_flag = lock_flag;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGrno() {
		return grno;
	}

	public void setGrno(int grno) {
		this.grno = grno;
	}

	public int getGrgrod() {
		return grgrod;
	}

	public void setGrgrod(int grgrod) {
		this.grgrod = grgrod;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getLock_flag() {
		return lock_flag;
	}

	public void setLock_flag(String lock_flag) {
		this.lock_flag = lock_flag;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

}
