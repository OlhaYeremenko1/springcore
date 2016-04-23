package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class UserDAO {


    @Autowired
    @Resource(name = "usersList")
    private List<User> usersList;

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        if (usersList == null)
            throw new InstantiationError("Users DAO has not been instantiated");
        return usersList;
    }
}
