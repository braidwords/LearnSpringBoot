package my.learning.project.schema;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Users implements Serializable {

    private Integer id;

    private String name;

    private Integer noOfBooksAllowed;

    private String emailID;

    private Set<Integer> books = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Integer getNoOfBooksAllowed() {
        return noOfBooksAllowed;
    }

    public void setNoOfBooksAllowed(Integer noOfBooksAllowed) {
        this.noOfBooksAllowed = noOfBooksAllowed;
    }

    public Set<Integer> getBooks() {
        return books;
    }

    public void setBooks(Set<Integer> books) {
        this.books = books;
    }
}

