package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.EventDAO;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.service.IEventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class EventService implements IEventService {

    @Autowired
    private EventDAO eventDAO;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDAO.getEvents().stream().filter(a -> a.getEventName().equals(name)).findFirst().get();
    }

    @Override
    public Event save(@Nonnull Event object) {
        eventDAO.getEvents().add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventDAO.getEvents().remove(object);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventDAO.getEvents().stream().filter(a -> a.getId().equals(id)).findFirst().get();
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventDAO.getEvents();
    }

}
