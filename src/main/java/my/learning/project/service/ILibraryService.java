package my.learning.project.service;

import my.learning.project.domain.User;

public interface ILibraryService {

    User issueBook(Integer userID, Integer bookID) throws Exception;

    User returnBook(Integer userID, Integer bookID) throws Exception;

    String isBookAvailable(Integer bookID) throws Exception;
}
