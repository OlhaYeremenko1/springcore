package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class EventDAO {

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    /**
     * The Events.
     */
    public List<Event> events;

    /**
     * Gets events.
     *
     * @return the events
     */
    public List<Event> getEvents() {
        if (events == null)
            throw new InstantiationError("Events DAO has not been instantiated");
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
