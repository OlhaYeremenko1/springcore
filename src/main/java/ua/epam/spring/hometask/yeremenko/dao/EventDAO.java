package ua.epam.spring.hometask.yeremenko.dao;

import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;

import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class EventDAO {

    /**
     * Gets events.
     *
     * @return the events
     */
    public static List<Event> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public static void setEvents(List<Event> events) {
        EventDAO.events = events;
    }

    private static List<Event> events;

}
