package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.Event;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class EventDAO {

    /**
     * The Events.
     */
    @Autowired
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

}
