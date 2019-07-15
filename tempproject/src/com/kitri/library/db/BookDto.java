package com.kitri.library.db;

import java.sql.Date;

public class BookDto {

//	public static final String[] STR= {"도서번호","도서명", "저자","도서이미지","장르","출판사","도서위치","출간일"};
	
	String isbn = "";
	String name = "";
	String writer = "";
	String image_path = "";
	String genre = "";
	String publisher = "";
	String position = "";
	Date publish_date = null;
	
	

	public BookDto(String isbn, String name, String writer, 
			String image_path, String genre, String publisher,
			String position, Date publish_date) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.writer = writer;
		this.image_path = image_path;
		this.genre = genre;
		this.publisher = publisher;
		this.position = position;
		this.publish_date = publish_date;
	}



	public BookDto(String isbn, String name, String writer) {
		this.isbn = isbn;
		this.name = name;
		this.writer = writer;
	}

	

	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		
		this.publish_date = publish_date;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}



	@Override
	public String toString() {
		return "BookDto [isbn=" + isbn + ", name=" + name + ", writer=" + writer + ", image_path=" + image_path
				+ ", genre=" + genre + ", publisher=" + publisher + ", position=" + position + ", publish_date="
				+ publish_date + "]";
	}



	public String getPublish_dateStr() {
		return (publish_date!=null)?publish_date.toString():"값이 존재하지 않습니다.";
	}

}
