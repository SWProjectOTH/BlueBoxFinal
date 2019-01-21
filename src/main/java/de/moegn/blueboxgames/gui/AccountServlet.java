package de.moegn.blueboxgames.gui;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.moegn.blueboxgames.model.Account;
import de.moegn.blueboxgames.service.InitService;
import de.moegn.blueboxgames.service.UserManagementService;

@WebServlet(urlPatterns = { "/Account" })
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1400787460326837646L;

	@Inject
	private UserManagementService userManagementService;

	@Inject
	private InitService initService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		initService.init();

		ServletOutputStream out = resp.getOutputStream();

		Account student = new Account();

		out.println("<html>");
		out.println("<head/>");
		out.println("<body>");
		out.println("<h1>Studentenverwaltung</h1>");

		out.println("<form method=\"post\">");
		if ("laden".equals(req.getParameter("action"))) {
			String matrikelNr = req.getParameter("matrikelnr");
			student = userManagementService.getAccount(matrikelNr);
			out.println("Matrikelnummer: ");
			out.println(matrikelNr + "<br/>");
		}
		out.println("Name:");
		out.println("<input type=\"text\" name=\"student_name\" value=\"");
		if (student.getName() != null)
			out.println(student.getName());
		out.println("\"/><br/>");
		out.println("Studiengang:");
		out.println("<input type=\"text\" name=\"studiengang\" value=\"");
		out.println("\"/><br/>");

		if ("laden".equals(req.getParameter("action"))) {
			String matrikelnr = req.getParameter("matrikelnr");
			out.println("<input type=\"hidden\" name=\"matrikelnr\" value=\"" + matrikelnr + "\">");
			out.println("<input type=\"submit\" value=\"Aendern\" name=\"action\"/><br/>");
		} else {
			out.println("<input type=\"submit\" value=\"Immatrikulieren\" name=\"action\"/><br/>");

		}

		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}