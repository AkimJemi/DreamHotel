package book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import util.Container;

public class BookOptionHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		return Container.bookService.bookOption(rq);
	}

}
