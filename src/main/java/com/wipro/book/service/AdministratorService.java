package com.wipro.book.service;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;

public class AdministratorService {

    public String addBook(BookBean bookbean){

        if(bookbean == null)
            return "INVALID";

        if(bookbean.getISBN() == null || bookbean.getISBN().trim().isEmpty())
            return "INVALID";

        if(bookbean.getBookName() == null || bookbean.getBookName().trim().isEmpty())
            return "INVALID";

        if(bookbean.getBookType()!='G' && bookbean.getBookType()!='T')
            return "INVALID";

        if(bookbean.getCost() <= 0)
            return "INVALID";

        if(bookbean.getAuthor() == null)
            return "INVALID";

        int result = new BookDAO().createBook(bookbean);

        if(result == 1)
            return "SUCCESS";

        return "FAILURE";
    }


    public BookBean viewBook(String ISBN) {

        if (ISBN == null || ISBN.trim().isEmpty())
            return null;

        return new BookDAO().fetchBook(ISBN);
    }
}
