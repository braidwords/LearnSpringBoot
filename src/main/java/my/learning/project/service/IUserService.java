package my.learning.project.service;


import my.learning.project.exception.NotFoundException;
import my.learning.project.schema.Users;

import java.util.List;

public interface IUserService {

    /**
     * GET request to fetch all users
     * @return list of all user
     */
    List<Users> getAllUser();

    /**
     * GET request to fetch specific user
     * @param id ID of the user to be fetched
     * @return requested user
     */
    Users getSpecificUser(int id) throws NotFoundException;

    /**
     * POST request to add a new user
     * @param user Details of user to be added
     * @return Newly created user
     */
    Users addUser(Users user);

    /**
     * PUT request to update an existing user
     * @param user user to be updated
     * @return Updated user
     */
    Users updateUser(Users user);

    /**
     * Delete a specific user
     * @param id ID of the user to be deleted
     */
    void deleteUser(int id);


}
