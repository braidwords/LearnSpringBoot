package my.learning.project.service;

import my.learning.project.entity.User;

public interface ILibraryService {

    User issueBook(Integer userID, Integer bookID) throws Exception;

    User returnBook(Integer userID, Integer bookID) throws Exception;

    Boolean isBookAvailable(Integer bookID) ;
}
