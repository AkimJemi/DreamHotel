package login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.Util;
import login.service.LoginService;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
	LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		if (rq.getParameter("name") != null && rq.getParameter("phone") != null)
			return processSubmit(rq, rp);

		if (rq.getMethod().equalsIgnoreCase("get")) {
			return porocessForm(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(rq, rp);
		} else
			return Util.redirectMsgAndBack(rq, "URI失敗");

	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		String name = rq.getParameter("name");
		String phone = rq.getParameter("phone");
		if (loginService.login(name, phone) == 1) {
			HttpSession session = rq.getSession();
			session.setAttribute("loginedUser", Boolean.TRUE);
			session.setAttribute("loginedName", name);
			session.setAttribute("loginedPhone", phone);
			return Util.redirectMsgAndReplace(rq, "ログイン成功", "/myPage.do");
		}
		return Util.redirectMsgAndBack(rq, "ログイン失敗");
	}

	private String porocessForm(HttpServletRequest rq, HttpServletResponse rp) {
		HttpSession session = rq.getSession();
		if (session.getAttribute("loginedName") != null && session.getAttribute("loginedPhone") != null)
			return "myPage.do";
		return "/WEB-INF/view/login.jsp";
	}

}
