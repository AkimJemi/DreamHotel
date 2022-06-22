package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.Util;
import mvc.command.CommandHandler;

public class AdminPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		
		
		
		if (rq.getSession().getAttribute("loginedAdmin") != null)
			return "adminBookList.do";
		if (rq.getParameter("adminCode").equals("admin")) {
			rq.getSession().setAttribute("loginedAdmin", rq.getParameter("adminCode"));
			return "adminBookList.do";
		} else 
			return "WEB-INF/view/admin/adminLogin.jsp";
	}	

}
