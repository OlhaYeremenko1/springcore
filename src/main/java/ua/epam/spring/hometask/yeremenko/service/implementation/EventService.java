package ua.epam.spring.hometask.yeremenko.service.implementation;

import ua.epam.spring.hometask.yeremenko.dao.EventDAO;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.service.IEventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class EventService implements IEventService {

    public EventService() {
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return EventDAO.getEvents().stream().filter(a->a.getName().equals(name)).findFirst().get();
    }

    @Override
    public Event save(@Nonnull Event object) {
        EventDAO.getEvents().add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Event object) {
        EventDAO.getEvents().remove(object);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return EventDAO.getEvents();
    }

}
