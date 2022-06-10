package book.model;

import java.sql.Date;

public class Options {
	private int no;
	private String item;
	private int cost;
	private String activity;
	private String delete_flag;
	private Date created_at;
	private Date updated_at;

	public Options() {
	}

	public Options(int no, String item, int cost, String activity, String delete_flag, Date created_at, Date updated_at) {
		this.no = no;
		this.item = item;
		this.cost = cost;
		this.activity = activity;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	

	public Options(int no, String item, int cost, Date created_at) {
		this.no = no;
		this.item = item;
		this.cost = cost;
		this.created_at = created_at;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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
