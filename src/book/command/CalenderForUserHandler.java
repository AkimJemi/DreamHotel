package book.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.Booking;
import jdbc.Util;
import mvc.command.CommandHandler;
import util.Container;

public class CalenderForUserHandler implements CommandHandler {
	private ArrayList<Booking> bookList;
	private static String start_date, end_date;
	private static int room_no, room_num;

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("check") != null) {
			ArrayList<Integer> listDates = new ArrayList<Integer>();
			ArrayList<Integer> calDates = new ArrayList<Integer>();
			start_date = rq.getParameter("start_date");
			end_date = rq.getParameter("end_date");
			int start_dates = Integer.parseInt(start_date.substring(8, 10));
			int end_dates = Integer.parseInt(end_date.substring(8, 10));
			for (int j = 1; j <= end_dates - start_dates + 1; j++) {
				calDates.add(start_dates);
				start_dates++;
				j--;
			}
			for (int i = 0; i < bookList.size(); i++) {
				start_dates = Integer.parseInt(bookList.get(i).getStart_date().substring(6, 8));
				end_dates = Integer.parseInt(bookList.get(i).getEnd_date().substring(6, 8));
				for (int j = 1; j <= end_dates - start_dates; j++) {
					listDates.add(start_dates);
					j--;
					start_dates++;
				}
			}
			rq.setAttribute("msg", "fall");
			for (int z = 0; z < calDates.size(); z++)
				if (listDates.contains(calDates.get(z)))
					return "WEB-INF/view/room/calenderSuccess.jsp";

			rq.setAttribute("msg", "succeed");
			return "WEB-INF/view/room/calenderSuccess.jsp";
		}

		if (rq.getMethod().equalsIgnoreCase("POST"))
			return post(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("GET"))
			return get(rq, rp);
		else
			return Util.redirectMsgAndBack(rq, "getMethod Error");
	}

	private String post(HttpServletRequest rq, HttpServletResponse rp) {
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
		room_no = Integer.parseInt(rq.getParameter("no"));
		room_num = Integer.parseInt(rq.getParameter("room_num"));

		bookList = Container.bookService.bookList(new Booking(room_no, room_num)); // 2
		rq.setAttribute("room_title", rq.getParameter("room_title"));
		rq.setAttribute("no", room_no);
		rq.setAttribute("room_num", room_num);
		rq.setAttribute("books", bookList);
		return "WEB-INF/view/room/calenderForUser.jsp";
	}

}
