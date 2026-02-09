package com.wipro.book.servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.AuthorDAO;
import com.wipro.book.service.AdministratorService;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		if(operation.equals("AddBook")) {
			String result=addBook(request);
			if(result.equals("SUCCESS")){
				response.sendRedirect("Menu.html");
			}
			else if(result.equals("INVALID")){
				response.sendRedirect("invalid.html");
			}
			else if(result.equals("FAILURE")){
				response.sendRedirect("failure.html");
			}
		}
		else if(operation.equals("Search")){
			String ISBN=request.getParameter("ISBN");
			BookBean bookBean=viewBook(ISBN);
			if(bookBean==null) {
				response.sendRedirect("invalid.html");
			}
			else {
				HttpSession session=request.getSession();
				session.setAttribute("book",bookBean);	
				RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");
				rd.forward(request,response);
			}
		}
	}
	public String addBook(HttpServletRequest request) {
		String ISBN=request.getParameter("ISBN");
		String bookName=request.getParameter("bookName");
		String bookType=request.getParameter("bookType");
		String authorName=request.getParameter("authorName");
		String cost =request.getParameter("cost");
		BookBean bookBean=new BookBean();
		bookBean.setISBN(ISBN);
		bookBean.setBookName(bookName);
		bookBean.setBookType(bookType.charAt(0));
		bookBean.setCost(Float.parseFloat(cost));
		bookBean.setAuthor(new AuthorDAO().getAuthor(authorName));
        return new AdministratorService().addBook(bookBean);
        
	}

	public BookBean viewBook(String ISBN) {
	    return new AdministratorService().viewBook(ISBN);
	}
}
