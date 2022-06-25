package board.model;

import java.sql.Date;

import board.service.NoticeService;

public class Notice {

	public Notice(int no, String title, String contents) {
		this.no = no;
		this.title = title;
		this.contents = contents;
	}

	private int no;
	private String title;
	private String contents;
	private String delete_flag;
	private Date created_at;
	private Date updated_at;

	public Notice(int no, String title, String contents, String delete_flag, Date created_at, Date updated_at) {
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	

	public Notice(Notice notice) {
		this.no = notice.getNo();
		this.title = notice.getTitle();
		this.contents = notice.getContents();
		this.delete_flag = notice.getDelete_flag();
		this.created_at = notice.getCreated_at();
		this.updated_at = notice.getUpdated_at();
	}

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
