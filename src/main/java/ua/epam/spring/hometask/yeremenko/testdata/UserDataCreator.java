package ua.epam.spring.hometask.yeremenko.testdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.UserDAO;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.util.Arrays;

/**
 * Created by Olha_Yeremenko on 4/26/2016.
 */
@Component
public class UserDataCreator implements IDataCreator {

    @Autowired
    public User userFirst;

    @Autowired
    public User userSecond;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    @Override
    public void populateData() {
        userFirst.setFirstName("FirstName1");
        userFirst.setLastName("LastName1");
        userFirst.setEmail("email1@email.com");
        userFirst.setBirthday(dateTimeEditor.parseText("2000-01-01"));

        userSecond.setFirstName("FirstName2");
        userSecond.setLastName("LastName2");
        userSecond.setEmail("email2@email.com");
        userSecond.setBirthday(dateTimeEditor.parseText("2000-01-02"));

        userDAO.setUsersList(Arrays.asList(userFirst, userSecond));
    }
}
