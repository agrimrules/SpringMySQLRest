package com.dimitrisli.springMySQL.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dimitrisli.springMySQL.model.Book;

public class BookRowMapper implements RowMapper<Book>{
public Book mapRow(ResultSet resultSet, int arg1) throws SQLException{
		Book book = new Book();
		book.setBookID(resultSet.getInt(1));
		book.setName(resultSet.getString(2));
		book.setISBN(resultSet.getString(3));
		book.setAuthor(resultSet.getString(4));
		return book;
}

}
