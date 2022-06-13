package book.command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import book.model.Booking;
import book.service.BookService;
import jdbc.Util;
import mvc.command.CommandHandler;

public class CalenderForUserHandler implements CommandHandler {
	private ArrayList<Booking> bookList;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getParameter("check") != null) {
			String start_date = rq.getParameter("start_date");
			String end_date = rq.getParameter("end_date");
			String room_no = rq.getParameter("room_no");
			System.out.println("size : " +bookList.size());
			for (int i = 0; i < bookList.size(); i++) {
//				System.out.println(start_date);
//				System.out.println(end_date);
//				System.out.println(bookList.get(i).getStart_date());
//				System.out.println(bookList.get(i).getStart_date().length());
//				System.out.println(bookList.get(i).getStart_date().substring(6,8));
				
				int start_day = Integer.parseInt(bookList.get(i).getStart_date().substring(6,8));
				int end_day = Integer.parseInt(bookList.get(i).getEnd_date().substring(6,8));
				System.out.println(start_day);
				System.out.println(end_day);
				ArrayList<Integer> date = new ArrayList<Integer>();
				int[] allDate =new  int[30];
				for (int j = 1; j < end_day-start_day; j++) {
					date.add(start_day);
					start_day++;
				}
//				if(date.contains())
//					return null;
			}
			return "yes";
		}
		if (rq.getMethod().equalsIgnoreCase("POST")) {
			return post(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("GET"))
			return get(rq, rp);
		else
			return Util.redirectMsgAndBack(rq, "getMethod Error");
	}

	private String post(HttpServletRequest rq, HttpServletResponse rp)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = rq.getParameter("alldata").substring(1, rq.getParameter("alldata").length() - 1);
		Map<String, Object> map = mapper.readValue(json, Map.class);
		for (Entry<String, Object> entry : map.entrySet())
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());

		System.out.println(map.get("title"));
		System.out.println(map.get("allDay"));
		System.out.println(map.get("start"));
		System.out.println(map.get("end"));
		return null;
	}

	private String get(HttpServletRequest rq, HttpServletResponse rp) {
		BookService bookService = new BookService();
		bookList = new ArrayList<Booking>();

		int room_no = Integer.parseInt(rq.getParameter("no"));
		int room_num = Integer.parseInt(rq.getParameter("room_num"));

		bookList.add(new Booking(room_no, room_num));
		bookList = bookService.bookList(bookList); // 2
		rq.setAttribute("no", room_no);
		rq.setAttribute("room_num", room_num);
		rq.setAttribute("books", bookList);
		return "WEB-INF/view/room/calenderForUser.jsp";
	}

}
