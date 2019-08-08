package my.learning.project.utils;

import my.learning.project.domain.Book;
import my.learning.project.domain.User;
import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Users;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    /*User (Domain) <-> User (Schema) */

    public static Users domainToSchemaUser(User user) {
        Users userSchema = new Users();
        userSchema.setId(user.getId());
        userSchema.setName(user.getName());
        userSchema.setEmailID(user.getEmailID());
        userSchema.setNoOfBooksAllowed(user.getNoOfBooksAllowed());
        for (Book book : user.getBooks()) {
            userSchema.getBooks().add(book.getId());
        }
        return userSchema;
    }

    public static List<Users> domainToSchemaUserList(List<User> users) {
        List<Users> usersList = new ArrayList<>();
        for (User user : users) {
            usersList.add(domainToSchemaUser(user));
        }
        return usersList;
    }

    public static User schemaToDomainUser(Users userSchema, BookRepository bookRepository, UserRepository userRepository) {
        User userDomain =  userSchema.getId() == null ? new User() : userRepository.getOne(userSchema.getId());
        userDomain.setId(userSchema.getId());
        userDomain.setName(userSchema.getName());
        userDomain.setEmailID(userSchema.getEmailID());
        userDomain.setNoOfBooksAllowed(userSchema.getNoOfBooksAllowed());
        for (Integer bookId : userSchema.getBooks()) {
            userDomain.getBooks().add(bookRepository.getOne(bookId));
        }
        return userDomain;
    }
}
