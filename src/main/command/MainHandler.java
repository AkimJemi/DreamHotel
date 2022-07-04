package main.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class MainHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)  {
		return "/WEB-INF/view/main.jsp";
	}
}
