package book.command;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import book.service.BookService;
import mvc.command.CommandHandler;
import room.model.Room_Info;
import room.service.RoomService;

public class GuestInfoInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		else
			return null;
	}
	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		String no = rq.getParameter("no");
		rq.setAttribute("option1", rq.getParameter("option1"));
		rq.setAttribute("option2", rq.getParameter("option2"));
		rq.setAttribute("option3", rq.getParameter("option3"));
		rq.setAttribute("optionText", rq.getParameter("optionText"));
		rq.setAttribute("activity1", rq.getParameter("activity1"));
		rq.setAttribute("activity2", rq.getParameter("activity2"));
		rq.setAttribute("activity3", rq.getParameter("activity3"));
		rq.setAttribute("activity3", rq.getParameter("activity3"));
		rq.setAttribute("no", no);
		return "WEB-INF/view/book/guestInfoInsert.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		BookService bookService = new BookService();
		RoomService roomService = new RoomService();
		Date date = new Date(System.currentTimeMillis());
		String options = rq.getParameter("option1") + "/" + rq.getParameter("option2") + "/"+rq.getParameter("option3");
		System.out.println("option :" + rq.getParameter("option"));
//		
//		Booking room = new Booking(Integer.parseInt(rq.getParameter("room_num")),Integer.parseInt(rq.getParameter("adult")),Integer.parseInt(rq.getParameter("child")));
//		System.out.println("option_total_cost : " +option_total_cost);
//		int basic_total_cost = bookService.getBasic_total_cost();
		int adult_cost=roomService.getAdultCostByRoom_Num(Integer.parseInt(rq.getParameter("room_num")));
		int child_cost=roomService.getChildCostByRoom_Num(Integer.parseInt(rq.getParameter("room_num")));
		int adult= Integer.parseInt(rq.getParameter("adult"));
		int child= Integer.parseInt(rq.getParameter("child"));
		int option_total_cost = bookService.getOption_A_TotalCost(Integer.parseInt(rq.getParameter("option1")),Integer.parseInt(rq.getParameter("option2")),Integer.parseInt(rq.getParameter("option3")));
		int total_cost = option_total_cost +(child_cost*child) + (adult_cost*adult);
//		total_cost = option_total_cost + roomService.getRoomCostByNo(rq.getParameter("no"));
		bookService.InsertBook(new Booking(Integer.parseInt(rq.getParameter("no")), Integer.parseInt(rq.getParameter("room_no")),
				rq.getParameter("name"), rq.getParameter("phone"), rq.getParameter("adult"), rq.getParameter("child"),
				rq.getParameter("start_date"), rq.getParameter("end_date"), options, total_cost,
				rq.getParameter("bank_name"), rq.getParameter("bank_branch_code"),
				rq.getParameter("bank_account_number"), date, date));

//				int no, int room_no, String name, String phone, String adult, String child, String start_date,
//				String end_date, StringBuilder options, int total_cost, String bank_name, String bank_branch_code,
//				String bank_account_number, Date created_at, Date updated_at
		System.out.println("option1 x 4,545 : " + rq.getParameter("option1"));
		System.out.println("option2 x 3,300 : " + rq.getParameter("option2"));
		System.out.println("option3 x 3,181 : " + rq.getParameter("option3"));
		System.out.println("optionText : " + rq.getParameter("optionText"));
		System.out.println("room_no : " + rq.getParameter("room_num"));
		System.out.println("name : " + rq.getParameter("name"));
		System.out.println("adult x 1000: " + rq.getParameter("adult"));
		System.out.println("child x 500: " + rq.getParameter("child"));
		System.out.println("start_date : " + rq.getParameter("start_date"));
		System.out.println("end_date : " + rq.getParameter("end_date"));
//		System.out.println("totalcost : " + rq.getParameter("totalcost"));
		System.out.println("bank_name : " + rq.getParameter("bank_name"));
		System.out.println("bank_branch_code : " + rq.getParameter("bank_branch_code"));
		System.out.println("bank_account_number : " + rq.getParameter("bank_account_number"));
		return "WEB-INF/view/book/guestInfoInsert.jsp";
	}

	private Date Datering(Object value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dating = null;
		try {
			String param = (String) value;
			dating = new Date(sdf.parse(param).getTime());
		} catch (Exception e) {
			System.out.println("error : Datering");
			System.out.println(e.getMessage());
		}
		return dating;
	}
}
