package com.app.librarymanagement.models;

import androidx.annotation.NonNull;

public class MyShelfBook {
    private int id;
    private int book_id;
    private int user_id;
    private String bookName;
    private String userName;
    private String requestedDate;
    private String returnedDate;
    private String status;

    public MyShelfBook(){}
    public MyShelfBook(int id, int book_id, int user_id, String bookName, String userName,
                       String requestedDate, String returnedDate, String status) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.bookName = bookName;
        this.userName = userName;
        this.requestedDate = requestedDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
