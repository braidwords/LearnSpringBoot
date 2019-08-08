package my.learning.project.service;

import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Users getSpecificUser(int id) {
        return domainToSchemaUser(userRepository.getOne(id));
    }

    @Override
    public Users addUser(Users user) {
        return domainToSchemaUser(userRepository.save(schemaToDomainUser(user, bookRepository)));
    }

    @Override
    public Users updateUser(Users user) {
        return domainToSchemaUser(userRepository.save(schemaToDomainUser(user, bookRepository)));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
