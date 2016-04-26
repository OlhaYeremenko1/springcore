package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ua.epam.spring.hometask.yeremenko.dao.UserDAO;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.epam.spring.hometask.yeremenko.domain"})
public class UserConfig {

//    @Autowired
//    private CustomLocalDateTimeEditor dateTimeEditor;
//
//    @Bean(name = "user")
//    public User getUser() {
//        return new User();
//    }
//
//    @Bean(name = "userFist")
//    public User getTestUserFirst() {
//        User user= new User();
//        user.setFirstName("FirstName1");
//        user.setLastName("LastName1");
//        user.setEmail("email1@email.com");
//        user.setBirthday(dateTimeEditor.parseText("2000-01-02"));
//        return user;
//    }
//
//    @Bean(name = "userSecond")
//    public User getTestUserSecond() {
//        User user= new User();
//        user.setFirstName("FirstName2");
//        user.setLastName("LastName2");
//        user.setEmail("email2@email.com");
//        user.setBirthday(dateTimeEditor.parseText("2000-01-01"));
//        return user;
//    }
//
//    @Bean(name = "userDao")
//    public UserDAO userDao() {
//    return new UserDAO();
//    }
//    @Bean(name = "usersList")
//    public List<User> usersList(){
//        return Arrays.asList(getTestUserFirst(),getTestUserSecond());
//    }

}
