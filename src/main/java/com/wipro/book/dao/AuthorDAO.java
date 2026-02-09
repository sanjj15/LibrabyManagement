package com.wipro.book.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.util.DBUtil;
import com.wipro.book.bean.AuthorBean;

public class AuthorDAO {
	public AuthorBean getAuthorByCode(int authorCode) {
		String sql = "SELECT * FROM Author_tbl WHERE Author_code = ?";
		try (Connection connection = DBUtil.getDBConnection();
	        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, authorCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	AuthorBean a = new AuthorBean();
            	a.setAuthorCode(rs.getInt(1));
                a.setAuthorName(rs.getString(2));
                a.setContactNo(rs.getLong(3));
                return a;
            }
            else {
            	return null;
            	}
            }catch (SQLException e) {
            	e.printStackTrace();
			}
		return null;
	}
	public AuthorBean getAuthor(String authorName) {
	    String sql = "SELECT * FROM Author_tbl WHERE Author_name = ?";
	    try (Connection connection = DBUtil.getDBConnection();
	         PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, authorName);  // 
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            AuthorBean a = new AuthorBean();
	            a.setAuthorCode(rs.getInt(1));
	            a.setAuthorName(rs.getString(2));
	            a.setContactNo(rs.getLong(3));
	            return a;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}

}
