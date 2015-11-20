package com.dimitrisli.springMySQL.dao;

import java.util.List;

import com.dimitrisli.springMySQL.model.Book;

public abstract interface BookDao {
	public abstract void createBook(String Name,String ISBN,String Author);
	public abstract List<Book> selectBook(int id);
	public abstract List<Book> selectAll();
	public abstract void deleteBook(int id);
	public abstract void deleteAll();

}
