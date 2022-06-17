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
	private BookService bookService;
	private ArrayList<Booking> bookList;
	private static String start_date, end_date;
	private static int room_no, room_num;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getParameter("check") != null) {
			ArrayList<Integer> listDates = new ArrayList<Integer>();
			ArrayList<Integer> calDates = new ArrayList<Integer>();
			start_date = rq.getParameter("start_date");
			end_date = rq.getParameter("end_date");
			System.out.println("start : " + start_date);
			System.out.println("end : "+end_date);
			int start_date_day = Integer.parseInt(start_date.substring(8, 10));
			int end_date_day = Integer.parseInt(end_date.substring(8, 10));
			int start_dates = start_date_day;
			int end_dates = end_date_day;
			for (int j = 1; j <= end_dates - start_dates; j++) {
				calDates.add(start_dates);
				start_dates++;
				j--;
			}
			for (int i = 0; i < bookList.size(); i++) {
				start_dates = Integer.parseInt(bookList.get(i).getStart_date().substring(6, 8));
				end_dates = Integer.parseInt(bookList.get(i).getEnd_date().substring(6, 8));
				System.out.println("test2 s: " + start_dates);
				System.out.println("test2 e: " + end_dates);
				for (int j = 1; j <= end_dates - start_dates; j++) {
					listDates.add(start_dates);
					j--;
					start_dates++;
				}
			}
			rq.setAttribute("msg", "Ž¸”s");
			for (int z = 0; z < calDates.size(); z++) {
				if (listDates.contains(calDates.get(z)))
					return "WEB-INF/view/room/calenderSuccess.jsp";
			}
			rq.setAttribute("msg", "¬Œ÷");
			return "WEB-INF/view/room/calenderSuccess.jsp";
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
//		ObjectMapper mapper = new ObjectMapper();
//		String json = rq.getParameter("alldata").substring(1, rq.getParameter("alldata").length() - 1);
//		Map<String, Object> map = mapper.readValue(json, Map.class);
//		for (Entry<String, Object> entry : map.entrySet())
//			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());

//		Booking book = new Booking(room_no, room_num, (String) map.get("title"),
//				((String) map.get("start")).substring(0, 10), ((String) map.get("end")).substring(0, 10));

		String datesToJson = "{ \"start_date\": \"" + start_date + "\", \"end_date\":\"" + end_date + "\"}";
		rq.setAttribute("json", datesToJson);
		return "WEB-INF/view/room/getJson.jsp";
	}

	private String get(HttpServletRequest rq, HttpServletResponse rp) {
		bookService = new BookService();
		bookList = new ArrayList<Booking>();
		room_no = Integer.parseInt(rq.getParameter("no"));
		room_num = Integer.parseInt(rq.getParameter("room_num"));

		bookList.add(new Booking(room_no, room_num));
		bookList = bookService.bookList(bookList); // 2
		rq.setAttribute("room_title", rq.getParameter("room_title"));
		rq.setAttribute("no", room_no);
		rq.setAttribute("room_num", room_num);
		rq.setAttribute("books", bookList);
		return "WEB-INF/view/room/calenderForUser.jsp";
	}

}
