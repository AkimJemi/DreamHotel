package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;
import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try (FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerinstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerinstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);

	}

	private void process(HttpServletRequest req, HttpServletResponse resp) {
		String command = req.getRequestURI();
		if (command.indexOf(req.getContextPath()) == 0)
			command = command.substring(req.getContextPath().length());

		CommandHandler handler = commandHandlerMap.get(command);

		if (handler == null)
			handler = new NullHandler(command);

		String viewPage = null;

		RequestDispatcher dispatcher;
		try {
			if (handler.toString().toLowerCase().substring(0, 5).equals("admin"))
				if (req.getSession().getAttribute("loginedAdmin") == null
						&& !handler.toString().contains("AdminPageHandler")) {
					viewPage = Util.redirectMsgAndBack(req, "loginedAmin Null");
					dispatcher = req.getRequestDispatcher(viewPage);
					dispatcher.forward(req, resp);
				}
			viewPage = handler.process(req, resp);
		} catch (Exception e) {
			viewPage = Util.redirectMsgAndBack(req, e.getMessage());
		}
		try {
			if (viewPage == null)
				viewPage = Util.redirectMsgAndBack(req, "viewPage Null");

			dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			System.out.println("viewPage error : " + e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

}