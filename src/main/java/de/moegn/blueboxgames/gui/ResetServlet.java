package de.moegn.blueboxgames.gui;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.moegn.blueboxgames.service.ResetService;

@WebServlet(urlPatterns = { "/ResetAll" })
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 2230348351204192307L;

	@Inject
	private ResetService resetService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();

		out.println("<html>");
		out.println("<head/>");
		out.println("<body>");

		out.println("<form method=\"post\">");
		if ("reset".equals(req.getParameter("action"))) {
			resetService.resetAll();
			out.println("<h3>All DB values were reset/deleted</h3>");
		} else {
			out.println("<h3>Reset all values</h3>");
		}
		out.println("<input type=\"submit\" value=\"reset\" name=\"action\"/><br/>");

		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}