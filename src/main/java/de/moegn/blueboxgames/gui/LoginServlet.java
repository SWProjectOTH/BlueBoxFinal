package de.moegn.blueboxgames.gui;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.moegn.blueboxgames.service.SessionManager;

@WebServlet(urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {

	@Inject
	private SessionManager sessionManager;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}