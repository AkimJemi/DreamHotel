package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		rp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return Util.redirectMsgAndBack(rq, "NullHandler");
	}
}
