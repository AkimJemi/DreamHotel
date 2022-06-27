package login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;
import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {

		if (rq.getParameter("a") != null) {
			String a = rq.getParameter("a");
			if (a.equals("user")) {
				rq.getSession().setAttribute("loginedUser", null);
			} else if (a.equals("admin")) {
				rq.getSession().setAttribute("loginedAdmin", null);
			}else if (a.equals("all")) {
				rq.getSession().invalidate();
			}
		}

		return Util.redirectMsgAndReplace(rq, "logout succeed", "/main.do");
	}

}
