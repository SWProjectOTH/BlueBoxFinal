package de.moegn.blueboxgames.gui;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.moegn.blueboxgames.service.GameService;
import de.moegn.blueboxgames.service.InitService;
import de.moegn.blueboxgames.service.SessionManager;
import de.moegn.blueboxgames.service.UserManagementService;

@WebServlet(urlPatterns = { "/Management" })
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 5410602560887815375L;

	private static final String gameElement = "<tr>" + "<th>{0}</th>" + "<th>{1}</th>" + "</tr>";

	@Inject
	private UserManagementService userManagementService;
	@Inject
	private GameService gameManagementService;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private InitService initService;

	private boolean loggedIn = false;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		initService.init();
		ServletOutputStream out = resp.getOutputStream();

		if (!sessionManager.isLogin()) {
			String s = new LoginUtil().getLogin(req, resp, sessionManager, userManagementService, req.getRequestURI());
			out.println(s);
			return;
		}

		out.println("<html>");
		out.println("<head/>");
		out.println("<body>");
		out.println("<h1>Spiele</h1>");

		out.println("<form method=\"post\">");

		if ("Log In".equals(req.getParameter("action"))) {
			String userName = req.getParameter("user_name");
			String password = req.getParameter("password");
			System.out.println(userName + " " + password);
			loggedIn = userManagementService.logIn(userName, password);

			sessionManager.setCurrentAccount(userManagementService.getAccount(userName));
		} else if (loggedIn) {

		} else {
			out.println("User Name:");
			out.println("<input type=\"text\" name=\"user_name\" value=\"");
			out.println("\"/><br/>");
			out.println("Password:");
			out.println("<input type=\"password\" name=\"password\" value=\"");
			out.println("\"/><br/>");
			out.println("<input type=\"submit\" value=\"Log In\" name=\"action\"/><br/>");
		}

		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}