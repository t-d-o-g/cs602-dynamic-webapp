
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Main extends HttpServlet {
	static final long serialVersionUID = 1L;

	public Main() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Welcome to my shop";
		int radio = -1;
		String message = "";

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		try {
			radio = Integer.parseInt(request.getParameter("rd"));
		} catch (Exception e) {
			message = "Please select a gender";
		}

		if (firstName.isEmpty() && lastName.isEmpty()) {
			message = "Please enter your first and last name.";
		} else if (firstName.isEmpty()){
			message = "Please enter your first name.";
		} else if (lastName.isEmpty()){
			message = "Please enter your last name.";
		} else {
			switch(radio) {
				case 0: message = "Thank you Mr. " + firstName + " " + lastName + "."; break;
				case 1: message = "Thank you Ms. " + firstName + " " + lastName + "."; break;
				default: message = "Thank you " + firstName + " " + lastName + ".";
			}
		}

		out.println(
			"<html>\n" +
			"<head><title>" + title + "</title></head>" +
			"<h1 align=\"center\">" + title + "</h1>\n" +
			"<ul>\n" + message + "</ul>\n" + "</body></html>"
		);

	}

}
