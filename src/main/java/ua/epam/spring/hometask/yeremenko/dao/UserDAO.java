package ua.epam.spring.hometask.yeremenko.dao;

import ua.epam.spring.hometask.yeremenko.domain.User;

import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class UserDAO {

    /**
     * Gets users.
     *
     * @return the users
     */
    public static List<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public static void setUsers(List<User> users) {
        UserDAO.users = users;
    }

    private static List<User> users;
}
