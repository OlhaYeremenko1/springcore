package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.EventDAO;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.EventRating;
import ua.epam.spring.hometask.yeremenko.service.IEventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class EventService  {

    @Autowired
    private EventDAO eventDAO;

    @Nullable
    public Event getByName(@Nonnull String name) {
        return eventDAO.getEventByName(name).get(0);
 }

    public Collection<Event> getAll() {
        return eventDAO.getEvents();
    }

    public void addEvent(String eventName, double price, EventRating rating, String dateTimeSet, String auditoriumMap)  {
        eventDAO.addEvent(eventName,price,rating.name(),dateTimeSet,auditoriumMap);
    }

    public void removeEvent(Event event){
        eventDAO.removeEvent(event);
    }


}
