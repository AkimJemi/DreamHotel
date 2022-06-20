package book.model;

import java.sql.Date;

public class Booking {

	private int no;
	private int room_no;
	private String name;
	private String phone;
	private String adult;
	private String child;
	private String start_date;
	private String end_date;
	private StringBuilder options;
	private String option;
	private String option1;
	private String option2;
	private String option3;
	private String payment_flag;
	private int total_cost;
	private String cancel_flag;
	private String bank_name;
	private String bank_branch_code;
	private String bank_account_number;
	private Date created_at;
	private Date updated_at;
	private String delete_flag;

	public Booking() {
	}
//	no, room_no,name,phone, adult, child, start_date,end_date,option,
//	bank_name,bank_branch_code,bank_account_number,created_at, updated_at, cancel_flag
	
	

	public Booking(int no, int room_no, String name, String start_date, String end_date) {
		this.no = no;
		this.room_no = room_no;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
	}


	public Booking(int no, int room_no, String name, String phone, String adult, String child, String start_date,
			String end_date, String option1, String option2, String option3, String payment_flag, int total_cost,
			String bank_name, String bank_branch_code, String bank_account_number, Date created_at, Date updated_at,
			String cancel_flag) {
		this.no = no;
		this.room_no = room_no;
		this.name = name;
		this.phone = phone;
		this.adult = adult;
		this.child = child;
		this.start_date = start_date;
		this.end_date = end_date;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.payment_flag = payment_flag;
		this.total_cost = total_cost;
		this.bank_name = bank_name;
		this.bank_branch_code = bank_branch_code;
		this.bank_account_number = bank_account_number;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.cancel_flag = cancel_flag;
	}



	public Booking(int no, int room_no) {
		this.no = no;
		this.room_no = room_no;
	}

	public Booking(int no, int room_no, String name) {
		this.no = no;
		this.room_no = room_no;
		this.name = name;
	}

	public Booking(int no, int room_no, String adult, String child, String start_date, String end_date) {
		this.no = no;
		this.room_no = room_no;
		this.adult = adult;
		this.child = child;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Booking(int no, int room_no, String name, String phone, String adult, String child, String start_date,
			String end_date, StringBuilder options, String payment_flag, int total_cost, String cancel_flag,
			String bank_name, String bank_branch_code, String bank_account_number, String delete_flag, Date created_at,
			Date updated_at) {
		this.no = no;
		this.room_no = room_no;
		this.name = name;
		this.phone = phone;
		this.adult = adult;
		this.child = child;
		this.start_date = start_date;
		this.end_date = end_date;
		this.options = options;
		this.payment_flag = payment_flag;
		this.total_cost = total_cost;
		this.cancel_flag = cancel_flag;
		this.bank_name = bank_name;
		this.bank_branch_code = bank_branch_code;
		this.bank_account_number = bank_account_number;
		this.delete_flag = delete_flag;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Booking(int no, int room_no, String name, String phone, String adult, String child, String start_date,
			String end_date, String option, int total_cost, String bank_name, String bank_branch_code,
			String bank_account_number, Date created_at, Date updated_at) {
		this.no = no;
		this.room_no = room_no;
		this.name = name;
		this.phone = phone;
		this.adult = adult;
		this.child = child;
		this.start_date = start_date;
		this.end_date = end_date;
		this.option = option;
		this.total_cost = total_cost;
		this.bank_name = bank_name;
		this.bank_branch_code = bank_branch_code;
		this.bank_account_number = bank_account_number;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Booking(int no, int room_no, String name, String phone, String adult, String child, String start_date,
			String end_date, StringBuilder options, int total_cost, String bank_name, String bank_branch_code,
			String bank_account_number, Date created_at, Date updated_at) {
		this.no = no;
		this.room_no = room_no;
		this.name = name;
		this.phone = phone;
		this.adult = adult;
		this.child = child;
		this.start_date = start_date;
		this.end_date = end_date;
		this.options = options;
		this.total_cost = total_cost;
		this.bank_name = bank_name;
		this.bank_branch_code = bank_branch_code;
		this.bank_account_number = bank_account_number;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public StringBuilder getOptions() {
		return options;
	}

	public void setOptions(StringBuilder options) {
		this.options = options;
	}

	public String getPayment_flag() {
		return payment_flag;
	}

	public void setPayment_flag(String payment_flag) {
		this.payment_flag = payment_flag;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public String getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(String cancel_flag) {
		this.cancel_flag = cancel_flag;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_branch_code() {
		return bank_branch_code;
	}

	public void setBank_branch_code(String bank_branch_code) {
		this.bank_branch_code = bank_branch_code;
	}

	public String getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
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



	public String getOption1() {
		return option1;
	}



	public void setOption1(String option1) {
		this.option1 = option1;
	}



	public String getOption2() {
		return option2;
	}



	public void setOption2(String option2) {
		this.option2 = option2;
	}



	public String getOption3() {
		return option3;
	}



	public void setOption3(String option3) {
		this.option3 = option3;
	}

}
