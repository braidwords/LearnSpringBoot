package my.learning.project.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Users implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "User ID")
    private Integer id;

    @ApiModelProperty(value = "User Name")
    private String name;

    @ApiModelProperty(value = "EmailID of the user")
    private String emailID;

    @ApiModelProperty(value = "Book allowed")
    private Integer noOfBooksAllowed;

    @ApiModelProperty(value = "Books issued by the user")
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

