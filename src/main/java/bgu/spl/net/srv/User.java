package bgu.spl.net.srv;

import java.util.Vector;

public class User {

    private String name;
    private String password;
    private Vector<String> borrowedBooks;
    private boolean isActive;


    public User( String name, String password, Vector<String> borrowedBooks) {
        this.name = name;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
    }


    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getPassword() {
        return password;
    }

    public Vector<String> getBorrowedBooks() {
        return borrowedBooks;
    }



    public void setActive(boolean active) {
        isActive = active;
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
