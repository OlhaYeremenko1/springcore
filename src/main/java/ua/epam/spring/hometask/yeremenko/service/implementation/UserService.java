package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.UserDAO;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.service.IUserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
      User user= userDAO.getUsers().stream().filter(a -> a.getEmail().equals(email)).findAny().get();
        if(user!=null){
            return  user;
        }
        else{
            throw new IllegalArgumentException("The are no such user");
        }
    }

    @Override
    public User save(@Nonnull User object) {
        userDAO.getUsers().add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        userDAO.getUsers().remove(object);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userDAO.getUsers().stream().filter(a -> a.getId().equals(id)).findAny().get();
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDAO.getUsers();
    }

    /**
     * Gets booked tickets.
     *
     * @param object the object
     * @return the booked tickets
     */
    public Set<Ticket> getBookedTickets(@Nonnull User object) {
        return object.getTickets();
    }

    public boolean isLuckyCheck(@Nonnull User object){
        return object.isLucky();
    }

}
