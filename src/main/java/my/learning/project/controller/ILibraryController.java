package my.learning.project.controller;

import my.learning.project.schema.Users;

public interface ILibraryController {

    Users issueOrReturnBook(Integer userID, Integer bookID, Character action) throws Exception;

    String isBookAvailable(Integer bookID) throws Exception;
}
