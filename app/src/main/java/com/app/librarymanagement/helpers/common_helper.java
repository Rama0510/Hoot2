package com.app.librarymanagement.helpers;

import com.app.librarymanagement.models.Author;
import com.app.librarymanagement.models.Book;
import com.app.librarymanagement.models.BookRequest;
import com.app.librarymanagement.models.MyShelfBook;
import com.app.librarymanagement.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class common_helper {
    public static boolean getAdminLogin(String email, String password){
        return email.equals("admin@gmail.com") && password.equals("admin123");
    }

    public static List<Book> getBooksData() {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,
                1,
                "The Great Gatsby",
                "The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. ",
                "Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.",
                "3.5",
                "01-01-2020",
                10,
                15)
        );
        list.add(new Book(2,
                2,"One Hundred Years of Solitude",
                "One Hundred Years of Solitude is a 1967 novel by Colombian author Gabriel García Márquez",
                "That tells the multi-generational story of the Buendía family, whose patriarch, José Arcadio Buendía, founded the fictitious town of Macondo. The novel is often cited as one of the supreme achievements in world literature.",
                "3.5",
                "25-11-2015",
                15,
                25)
        );
        return list;
    }

    public static List<Book> getAuthorBooks(int auth_id) {
        List<Book> list = getBooksData();
        List<Book> auth_list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(auth_id == list.get(i).getAuth_id())
                auth_list.add(list.get(i));
        }
        return auth_list;
    }

    public static Book getBookDetails(int id) {
        Book book = new Book();
        List<Book> list = getBooksData();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) book = list.get(i);
        }
        return book;
    }

    public static List<BookRequest> getRequestedBooksData(){
        List<BookRequest> list = new ArrayList<>();
        list.add(new BookRequest(1,
                1,
                1,
                "The Great Gatsby",
                "F. James",
                "05-03-2023",
                "approved")
        );
        list.add(new BookRequest(2,
                2,
                2,
                "One Hundred Years of Solitude",
                "Heera Khushi",
                "20-03-2023",
                "approved")
        );
        return list;
    }

    public static List<MyShelfBook> getMyShelfBooks(){
        List<MyShelfBook> list = new ArrayList<>();
        list.add(new MyShelfBook(1,
                1,
                1,
                "The Great Gatsby",
                "F. James",
                "05-03-2023",
                "20-03-2023",
                "approved")
        );
        list.add(new MyShelfBook(2,
                2,
                2,
                "One Hundred Years of Solitude",
                "Heera Khushi",
                "20-03-2023",
                "30-03-2023",
                "approved")
        );
        return list;
    }

    public static MyShelfBook getMyShelfDetails(int id){
        List<MyShelfBook> list = getMyShelfBooks();
        MyShelfBook myShelfBook = new MyShelfBook();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) myShelfBook = list.get(i);
        }
        return myShelfBook;
    }

    public static BookRequest getRequestedBookData(int id) {
        BookRequest book = new BookRequest();
        List<BookRequest> list = getRequestedBooksData();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) book = list.get(i);
        }
        return book;
    }

    public static List<BookRequest> getOverdueBooksData() {
        List<BookRequest> list = getRequestedBooksData();
        List<BookRequest> list_overdue = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String requestedDate = list.get(i).getRequestedDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date strDate = null;
            try {
                strDate = sdf.parse(requestedDate);
                Date due_date = addDay(strDate, 15);
                if (new Date().after(due_date)) {
                    //due true
                    list_overdue.add(list.get(i));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return list_overdue;
    }

    public static Date addDay(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, i);
        return cal.getTime();
    }

    public static List<Author> getAuthorsData() {
        List<Author> list = new ArrayList<>();
        list.add(new Author(1," F. Scott Fitzgerald",
                "3.5",
                45,"male")
        );
        list.add(new Author(2,"Gabriel García Márquez",
                "4.5",
                25,"female")
        );
        return list;
    }

    public static Author getAuthorsDetails(int id) {
        List<Author> list = getAuthorsData();
        Author author = new Author();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) author = list.get(i);
        }
        return author;
    }

    public static List<User> getUsersData() {
        List<User> list = new ArrayList<>();
        list.add(new User("1",
                "F. James",
                "6/asd jhaiushda",
                "0123456789",
                "james@gmail.com",
                25,
                "male")
        );
        list.add(new User("2",
                "Heera Khushi",
                "1/F12 asasa",
                "1576543210",
                "heera@gmail.com",
                35,
                "female")
        );
        return list;
    }

    public static User getUserDetails(String id) {
        User user = new User();
        List<User> list = getUsersData();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getId().equals(id))  user = list.get(i);
            }
        return user;
    }
}
