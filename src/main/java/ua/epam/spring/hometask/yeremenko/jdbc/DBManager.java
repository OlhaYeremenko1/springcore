package ua.epam.spring.hometask.yeremenko.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.*;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;
import ua.epam.spring.hometask.yeremenko.service.implementation.BookingService;
import ua.epam.spring.hometask.yeremenko.service.implementation.EventService;
import ua.epam.spring.hometask.yeremenko.service.implementation.UserService;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import static ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery.SQlQueryConst.*;


/**
 * Created by Olha_Yeremenko on 4/30/2016.
 */
@Component
public class DBManager {

    @Autowired
    private JdbcTemplate getJdbcTemplate;

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    public void init() {
        createAuditoriumsTable();
        createEventsTable();
        createUserTable();
        createTicketsTable();
    }

    private void createAuditoriumsTable() {
        String sql = SQlQuery.uiSqlBuilder().createTable(AUDITORIUMS_TABLE_NAME, AUDITORIUMS_TABLE_PARAMS).build();
        getJdbcTemplate.execute(sql);
        System.out.println("Auditoriums table created");
    }

    private void createEventsTable() {
        String sql = SQlQuery.uiSqlBuilder().createTable(EVENTS_TABLE_NAME, EVENTS_TABLE_PARAMS).build();
        getJdbcTemplate.execute(sql);
        System.out.println("Events table created");
    }

    private void createUserTable() {
        String sql = SQlQuery.uiSqlBuilder().createTable(USERS_TABLE_NAME, USERS_TABLE_PARAMS).build();
        getJdbcTemplate.execute(sql);
        System.out.println("Users table created");
    }

    private void createTicketsTable() {
        String sql = SQlQuery.uiSqlBuilder().createTable(TICKETS_TABLE_NAME, TICKETS_TABLE_PARAMS).build();
        getJdbcTemplate.execute(sql);
        System.out.println("Tickets table created");
    }


}
