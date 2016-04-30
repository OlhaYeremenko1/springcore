package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery;
import ua.epam.spring.hometask.yeremenko.service.implementation.BookingService;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery.SQlQueryConst.USERS_TABLE_NAME;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class UserDAO {

    @Autowired
    private JdbcTemplate getJdbcTemplate;

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    @Autowired
    private BookingService bookingService;

    private List<User> usersList;

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        String sql = SQlQuery.uiSqlBuilder().select("*").from(USERS_TABLE_NAME).build();
        return getJdbcTemplate.query(sql, getRowMapper());
    }

    public void addUser(String firstName, String lastName, String birthDate, String email, String tickets) {
        String sql = SQlQuery.uiSqlBuilder().insertIntoUsers().values("?,?,?,?,?,?").build();
        getJdbcTemplate.update(sql, firstName, lastName,birthDate,email, tickets,false);
    }
    public void addUser(String firstName, String lastName, String birthDate, String email) {
        String sql = SQlQuery.uiSqlBuilder().insertIntoUsers().values("?,?,?,?,?,?").build();
        getJdbcTemplate.update(sql, firstName, lastName,birthDate,email, "",false);
    }


    private RowMapper<User> getRowMapper() {
        return new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                String fname = resultSet.getString("FIRST_NAME");
                String lname = resultSet.getString("LAST_NAME");
                String email = resultSet.getString("EMAIL");
                String birthDate = resultSet.getString("BIRTH_DATE");
                String bookedTickets = resultSet.getString("BOOKED_TICKETS");
                Boolean isLucky = resultSet.getBoolean("IS_LUCKY");
                User user = new User();
                user.setFirstName(fname.trim());
                user.setLastName(lname.trim());
                user.setEmail(email);
                user.setBirthday(dateTimeEditor.parseText(birthDate));
                user.setLucky(isLucky);
                return user;
            }
        };
    }
}
