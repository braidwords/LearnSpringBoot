package my.learning.project.controller;

import my.learning.project.entity.User;

import java.util.List;

public interface IUserController {

    /**
     * GET request to fetch all users
     * @return list of all user
     */
    List<User> getAllUser();

    /**
     * GET request to fetch specific user
     * @param id ID of the user to be fetched
     * @return requested user
     */
    User getSpecificUser(int id);

    /**
     * POST request to add a new user
     * @param user Details of user to be added
     * @return Newly created user
     */
    User addUser(User user);

    /**
     * PUT request to update an existing user
     * @param user user to be updated
     * @return Updated user
     */
    User updateUser(User user);

    /**
     * Delete a specific user
     * @param id ID of the user to be deleted
     * @return Status message
     */
    String deleteUser(int id);


}
