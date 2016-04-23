package ua.epam.spring.hometask.yeremenko.service.implementation;

import ua.epam.spring.hometask.yeremenko.dao.UserDAO;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.service.IUserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class UserService implements IUserService{

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return  UserDAO.getUsers().stream().filter(a->a.getEmail().equals(email)).findAny().get();
    }

    @Override
    public User save(@Nonnull User object) {
        UserDAO.getUsers().add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        UserDAO.getUsers().remove(object);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return UserDAO.getUsers();
    }
}
