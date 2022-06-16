
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
		String title = "Credit Cards";
		int radio = -1;

		String card = "";
		try {
			radio = Integer.parseInt(request.getParameter("rd"));
		} catch (Exception e) {
			card = "Please choose a card";
		}

		switch(radio) {
			case 0: card = "You chose Master Card"; break;
			case 1: card = "You chose Discover Card"; break;
			case 2: card = "You chose Visa Card"; break;
			default: card = "Please choose a card";
		}
		out.println(
			"<html>\n" +
			"<head><title>" + title + "</title></head>" +
			"<h1 align=\"center\">" + title + "</h1>\n" +
			"<ul>\n" + card + "</ul>\n" + "</body></html>"
		);

	}

}
