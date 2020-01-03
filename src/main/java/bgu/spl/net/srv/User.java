package bgu.spl.net.srv;

import java.util.Vector;

public class User {

    private String name;
    private String password;
    private Vector<String> borrowedBooks;
    //TODO CHECK IF IS AVAILABLE FIELD IS NECESSETRY
   // private boolean isActive;


    public User( String name, String password, Vector<String> borrowedBooks) {
        this.name = name;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Vector<String> getBorrowedBooks() {
        return borrowedBooks;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBorrowedBooks(Vector<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
