package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;

public class NullHandler implements CommandHandler {
	private static String command;

	public NullHandler(String command) {
		this.command = command;
	}

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)  {
//		rp.sendError(HttpServletResponse.SC_NOT_FOUND);
		return Util.redirectMsgAndBack(rq, "NullHandler, commandHandlerURI.properties : " + command);
	}
}
