package controller;

import model.PhoneBook;
import model.PhoneEntry;
import model.BookDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.io.*;
import java.util.logging.Logger;


public class PhoneServlet extends HttpServlet {
    private static PhoneBook _pbook = null;
    private static Logger log = Logger.getLogger(PhoneServlet.class.getName());
	private BookDAO bookDAO;


    public void init(ServletConfig config) throws ServletException {



		String jdbcURL = config.getInitParameter("jdbcURL");
		String jdbcUsername = config.getInitParameter("jdbcUsername");
		String jdbcPassword = config.getInitParameter("jdbcPassword");

		bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{


	String s= "";
	req.setAttribute("resultString", s);

	String action = req.getParameter("Action");
	if (action == null || action.length() == 0) {
		s= "No Action provided";
		req.setAttribute("resultString", s);
		req.getRequestDispatcher("/result.jsp").forward(req, res);
	    return;
	}

	try {
	    if (action != null) {
		if (action.equals("Add")) {
		    PhoneEntry pentry = new PhoneEntry(req.getParameter("phone"), req.getParameter("firstname"),
						       req.getParameter("lastname"));
			s= "Entry added to phonebook";
			req.setAttribute("resultString", s);
			bookDAO.insertBook(pentry);
			req.getRequestDispatcher("/result.jsp").forward(req, res);

		} else if (action.equals("List")) {
			List<PhoneEntry> listBook = bookDAO.listAllBooks();
			req.setAttribute("resultString", listBook);
			req.getRequestDispatcher("/result.jsp").forward(req, res);

		} else if (action.equals("Remove")) {
		    PhoneEntry pentry = new PhoneEntry(req.getParameter("phone"));
		    if (bookDAO.deleteBook(pentry) == false) {
				s= "No entry with phone number " + req.getParameter("phone");
				req.setAttribute("resultString", s);
				req.getRequestDispatcher("/result.jsp").forward(req, res);

		    } else {
		    	bookDAO.deleteBook(pentry);
				s="Removed entry with Phone number " + pentry.getPhone();
				req.setAttribute("resultString", s);
				req.getRequestDispatcher("/result.jsp").forward(req, res);

			}
		}
	    } else {		    	s="No valid Action provided in the parameters";
			req.setAttribute("resultString", s);
			req.getRequestDispatcher("/result.jsp").forward(req, res);
	    }
	}
	catch (Exception exc)
	    {
			s="Java exception satisfying request";
			req.setAttribute("resultString", s);
			req.getRequestDispatcher("/result.jsp").forward(req, res);
		exc.printStackTrace();
	    }
    }
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException	{
	res.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "GET not supported by this servlet");
    }
}
