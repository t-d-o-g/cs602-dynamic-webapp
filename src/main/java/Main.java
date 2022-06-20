
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
		String genderError = "";
		String nameError = "";

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		if (firstName.isEmpty() && lastName.isEmpty()) {
			nameError = "Please enter your first and last name.";
		} else if (firstName.isEmpty()) {
			nameError = "Please enter your first name.";
		} else if (lastName.isEmpty()) {
			nameError = "Please enter your last name.";
		}

		try {
			radio = Integer.parseInt(request.getParameter("rd"));
		} catch (Exception e) {
			genderError = "Please select a gender.";
		}

		switch (radio) {
			case 0:
				message = "Thank you Mr. " + firstName + " " + lastName + ".";
				break;
			case 1:
				message = "Thank you Ms. " + firstName + " " + lastName + ".";
				break;
			default:
				message = "Thank you " + firstName + " " + lastName + ".";
		}

		out.println("<!DOCTYPE html>");

		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>" + title + "</title>");
		out.println("<style>");
		out.println("html, body {background-color:#ffffcc; text-align:center;}"); 
		out.println(".header {background-color:yellow; border:3px solid green; width:50%; margin:20px auto; padding: 10px; font-family: cursive}"); 
		out.println(".err-msg {color:red; text-align:left; margin: 100px auto; font-size:20px; width:50%;}"); 
		out.println(".msg {margin:100px; font-size:30px; font-family:cursive; text-decoration:underline; text-decoration-color:green;}"); 
		out.println("</style>");
		out.println("</head>");

		out.println("<body>");

		out.println("<div class='header'>");
	  out.println("<h1>" + title + "</h1>");
		out.println("</div>");


		if (nameError.isEmpty() && genderError.isEmpty()) {
			out.println("<div class='msg'>");
			out.println("<ul>" + message + "</ul>");
			out.println("</div>");
		}

		out.println("<div class='err-msg'>");
		out.println("<ul>" + nameError + "</ul>");
		out.println("<ul>" + genderError + "</ul>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
	}
}