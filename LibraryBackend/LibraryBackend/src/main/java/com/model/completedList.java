package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class completedList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int BookId;
//	private User user;

	public completedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public completedList(int bookId) {
		super();
		BookId = bookId;
	}

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

}
