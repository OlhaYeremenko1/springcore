package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;
import ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;
import ua.epam.spring.hometask.yeremenko.service.implementation.BookingService;
import ua.epam.spring.hometask.yeremenko.service.implementation.EventService;
import ua.epam.spring.hometask.yeremenko.service.implementation.UserService;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery.SQlQueryConst.TICKETS_TABLE_NAME;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class TicketDAO {
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


    public void addTicket(String userEmail,String eventName,String date,int seat) {
        String sql = SQlQuery.uiSqlBuilder().insertIntoTickets().values("?,?,?,?").build();
        getJdbcTemplate.update(sql, "email1", "event1", "2010-01-01", 12);

    }

    public List<Ticket> getAllTickets() {
        String sql = SQlQuery.uiSqlBuilder().select("*").from(TICKETS_TABLE_NAME).build();
        return getJdbcTemplate.query(sql, getTicketRowMapper());
    }

    public List<Ticket> getBookedTicketForEvent(String eventName,String date) {
        String sql = SQlQuery.uiSqlBuilder().select("*").from(TICKETS_TABLE_NAME).where("event="+eventName+"").build();
        return getJdbcTemplate.query(sql, getTicketRowMapper());
    }

    private RowMapper<Ticket> getTicketRowMapper() {
        return new RowMapper<Ticket>() {
            @Override
            public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
                String event = resultSet.getString("event");
                Integer seat = resultSet.getInt("seat_num");
                String userEmail = resultSet.getString("user_email");
                String date = resultSet.getString("date");

                Ticket ticket = new Ticket(userService.getUserByEmail(userEmail), eventService.getByName(event), dateTimeEditor.parseText(date), seat);
                return ticket;
            }
        };
    }

}
