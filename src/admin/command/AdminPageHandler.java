package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.Util;
import mvc.command.CommandHandler;

public class AdminPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getMethod().equalsIgnoreCase("get")) {
			return porocessForm(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(rq, rp);
		} else
			return Util.redirectMsgAndBack(rq, "URI失敗");
	}

	private String porocessForm(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getSession().getAttribute("loginedAdmin") != null)
			return "adminBookList.do";
		else
			return "WEB-INF/view/admin/adminLogin.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("adminCode").equals("admin")) {
			rq.getSession().setAttribute("loginedAdmin", rq.getParameter("adminCode"));
			return "adminBookList.do";
		} else
			return Util.redirectMsgAndBack(rq, "IDとパスワードを正確に入力してください。");
	}

}
