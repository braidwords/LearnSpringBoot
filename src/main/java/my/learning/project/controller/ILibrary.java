package my.learning.project.controller;

import my.learning.project.entity.User;

public interface ILibrary {

    User issueBook(Integer userID, Integer bookID) throws Exception;

    User returnBook(Integer userID, Integer bookID) throws Exception;

    Boolean isBookAvailable(Integer bookID);
}
