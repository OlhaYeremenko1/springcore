package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.EventRating;
import ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

import static ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery.SQlQueryConst.EVENTS_TABLE_NAME;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class EventDAO {

    @Autowired
    private JdbcTemplate getJdbcTemplate;

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    @Autowired
    private AuditoriumService auditoriumService;

   /**
     * Gets events.
     *
     * @return the events
     */
    public List<Event> getEvents() {
        String sql = SQlQuery.uiSqlBuilder().select("*").from(EVENTS_TABLE_NAME).build();
        return getJdbcTemplate.query(sql, getRowMapper());
    }

    public List<Event> getEventByName(String name) {
        String sql = SQlQuery.uiSqlBuilder().select("*").from(EVENTS_TABLE_NAME).where("NAME="+name).build();
        return getJdbcTemplate.query(sql, getRowMapper());
    }

    public void addEvent(String eventName, double price, String rating, String dateTimeSet, String auditoriumMap) {
        String sql = SQlQuery.uiSqlBuilder().insertIntoEvents().values("?,?,?,?,?").build();
        getJdbcTemplate.update(sql, eventName, price, rating, dateTimeSet, auditoriumMap);
    }

    public void removeEvent(Event event) {
        String sql = SQlQuery.uiSqlBuilder().deleteFrom(EVENTS_TABLE_NAME).where("name=?").build();
        getJdbcTemplate.update(sql, event.getEventName());
    }

    private RowMapper<Event> getRowMapper() {
        return new RowMapper<Event>() {
            @Override
            public Event mapRow(ResultSet resultSet, int i) throws SQLException {
                String name = resultSet.getString("name");
                int ticketPrice = resultSet.getInt("ticket_price");
                String rating = resultSet.getString("rating");
                String dates = resultSet.getString("dates");
                String auditoriumTime = resultSet.getString("auditorium_time");

                Event event = new Event();
                event.setName(name);
                event.setAirDates(convertToDateSet(dates));
                event.setBasePrice(ticketPrice);
                event.setRating(EventRating.valueOf(rating));
                event.setAuditoriums(convertToMap(auditoriumTime));
                return event;
            }
        };
    }

    private TreeMap<LocalDateTime, Auditorium> convertToMap(String auditoriumTime) {
        TreeMap<LocalDateTime, Auditorium> map = new TreeMap<>();
        Arrays.asList(auditoriumTime.split(",")).forEach(at -> {
            map.put(dateTimeEditor.parseText(at.split("/")[0]),
                    auditoriumService.getByName(at.split("/")[1]));
        });
        return map;
    }

    private TreeSet<LocalDateTime> convertToDateSet(String dates) {
        TreeSet<LocalDateTime> dateSet = new TreeSet<>();
        Arrays.asList(dates.split(",")).forEach(d -> {
            dateSet.add(dateTimeEditor.parseText(d));
        });
        return dateSet;
    }
}
