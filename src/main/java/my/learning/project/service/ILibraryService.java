package my.learning.project.service;

import my.learning.project.schema.Users;

public interface ILibraryService {

    Users issueBook(Integer userID, Integer bookID) throws Exception;

    Users returnBook(Integer userID, Integer bookID) throws Exception;

    String isBookAvailable(Integer bookID) throws Exception;
}
