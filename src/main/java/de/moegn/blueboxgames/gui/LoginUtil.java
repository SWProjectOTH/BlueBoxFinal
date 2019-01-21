package de.moegn.blueboxgames.gui;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.moegn.blueboxgames.service.SessionManager;
import de.moegn.blueboxgames.service.UserManagementService;

public class LoginUtil {

	public String getLogin(HttpServletRequest req, HttpServletResponse resp, SessionManager sessionManager,
			UserManagementService manager, String redirectUrl) {
		StringBuilder joiner = new StringBuilder(2048);
		joiner.append("<html style=\"background-color:#2A3436;\">");
		joiner.append("<head>");
		joiner.append("<title>Login</title>");
		joiner.append("<link rel='stylesheet' type='text/css' href='/layout.css'>");
		joiner.append("</head>");
		joiner.append("<body>");

		// joiner.append("<div style=\"width:400px; margin: 0 auto;
		// background-color:#1A1D1F;\">");
		joiner.append("<div style=\"width:400px; margin: 0 auto; padding:8xp; background-color:yellow;\">");
		joiner.append("<h3 class='test'>Login</h3>");

		joiner.append("<form method=\"post\">");

		String userName = req.getParameter("user_name");
		String password = req.getParameter("password");
		if ("Log In".equals(req.getParameter("action")) && manager.logIn(userName, password)) {
			sessionManager.setCurrentAccount(manager.getAccount(userName));
			try {
				resp.sendRedirect(redirectUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			joiner.append("<div stlye=\"color:white;margin-left:8px;\">");
			joiner.append("<span style=\"width:50%; display: inline-block;\">User Name:</span>");
			joiner.append("<input style='width:50%' type=\"text\" name=\"user_name\" value=\"");
			joiner.append("\"/><br/>");
			joiner.append("</div>");

			joiner.append("<div stlye=\"color:white;margin-left:8px;\">");
			joiner.append("<span style=\"width:50%; display: inline-block;\">Password:</span>");
			joiner.append("<input style='width:50%' type=\"password\" name=\"password\" value=\"");
			joiner.append("\"/><br/>");
			joiner.append("</div>");

			joiner.append("<input type=\"submit\" value=\"Log In\" name=\"action\"/><br/>");
		}

		joiner.append("</div>");
		joiner.append("</body>");
		joiner.append("</html>");
		return joiner.toString();
	}
}