package com.wipro.book.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;

@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String isbn = request.getParameter("isbn");
        BookDAO dao = new BookDAO();
        BookBean book = dao.fetchBook(isbn);
        out.println("<html><body>");
        if (book != null) {
            out.println("Book ISBN : " + book.getISBN() + "<br><br>");
            out.println("Book Title : " + book.getBookName() + "<br><br>");
            out.println("Book Type : " + book.getBookType() + "<br><br>");
            if (book.getAuthor() != null) {
                out.println("Author Name : " + book.getAuthor().getAuthorName() + "<br><br>");
                out.println("Author Contact : " + book.getAuthor().getContactNo() + "<br><br>");
            }
            out.println("Book Cost : " + book.getCost() + "<br><br>");
        } else {
            out.println("<h3>Book not Found</h3>");
        }
        out.println("</body></html>");
    }
	@Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
