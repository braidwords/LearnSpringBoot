package my.learning.project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer noOfBooksAllowed;

    private String emailID;

    @OneToMany(mappedBy = "users")
    private Set<Book> books = new HashSet<>();

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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

