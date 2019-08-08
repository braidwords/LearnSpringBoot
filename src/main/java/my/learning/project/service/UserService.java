package my.learning.project.service;

import my.learning.project.exception.NotFoundException;
import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

import static my.learning.project.utils.UserUtils.*;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Users> getAllUser() {
        return domainToSchemaUserList(userRepository.findAll());
    }

    @Override
    public Users getSpecificUser(int userId) throws NotFoundException {
        try {
            return domainToSchemaUser(userRepository.getOne(userId));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("User with id : [" + userId + "] not found", e);
        }
    }

    @Override
    public Users addUser(Users user) {
        return domainToSchemaUser(userRepository.save(schemaToDomainUser(user, bookRepository, userRepository)));
    }

    @Override
    public Users updateUser(Users user) {
        return domainToSchemaUser(userRepository.save(schemaToDomainUser(user, bookRepository, userRepository)));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
