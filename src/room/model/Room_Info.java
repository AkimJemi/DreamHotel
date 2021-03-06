package room.model;

import java.sql.Date;

public class Room_Info {
	private int no;
	private String room_num;
	private String room_title;
	private int max;
	private int adult_cost;
	private int child_cost;
	private String explanation;
	private String images;
	private String color_code;
	private String delete_flag;
	private Date created_at;
	private Date updated_at;
	

	public Room_Info() {
	}

	public Room_Info(int no, String room_num, String room_title, int max, int adult_cost, int child_cost, String explanation,
			String images, String color_code, String delete_flag, Date created_at, Date updated_at) {
		this.no = no;
		this.room_num = room_num;
		this.room_title = room_title;
		this.max = max;
		this.adult_cost = adult_cost;
		this.child_cost = child_cost;
		this.explanation = explanation;
		this.images = images;
		this.color_code = color_code;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	

	public Room_Info(String room_num, int adult_cost, int child_cost) {
		this.room_num = room_num;
		this.adult_cost = adult_cost;
		this.child_cost = child_cost;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRoom_num() {
		return room_num;
	}

	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}

	public String getRoom_title() {
		return room_title;
	}

	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getAdult_cost() {
		return adult_cost;
	}

	public void setAdult_cost(int adult_cost) {
		this.adult_cost = adult_cost;
	}

	public int getChild_cost() {
		return child_cost;
	}

	public void setChild_cost(int child_cost) {
		this.child_cost = child_cost;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getColor_code() {
		return color_code;
	}

	public void setColor_code(String color_code) {
		this.color_code = color_code;
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
