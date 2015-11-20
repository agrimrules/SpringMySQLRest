package com.dimitrisli.springMySQL.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dimitrisli.springMySQL.model.Book;
public class BookDaoImpl {
	DataSource dataSource;
	 
	public void createBook(String Name,String ISBN,String Author)
	{
		JdbcTemplate createBook = new JdbcTemplate(dataSource);
		createBook.update("INSERT INTO agrimawsdb.Books (BookName, ISBN, Author) VALUES (?,?,?)",new Object[]{Name,ISBN,Author});
	}
	
	public List<Book> selectBook(int BookID){
		JdbcTemplate selectBook = new JdbcTemplate(dataSource);
		return selectBook.query("SELECT `BookID`, `BookName`, `ISBN`, `Author` FROM `agrimawsdb`.`Books` WHERE  `BookID`=?",new Object[]{BookID},new BookRowMapper());
	}
	
	public List<Book> selectAll() {
		JdbcTemplate selectBooks = new JdbcTemplate(dataSource);
		return selectBooks.query("SELECT `BookID`, `BookName`, `ISBN`, `Author` FROM `agrimawsdb`.`Books` ",
				new BookRowMapper());
	}
	
	public void deleteBook(int BookID){
		JdbcTemplate deleteBook= new JdbcTemplate(dataSource);
		deleteBook.update("Delete from agrimawsdb.Books where BookID=?",new Object[]{BookID});
	}
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

}
