package ua.epam.spring.hometask.yeremenko.testdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.dao.EventDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.EventRating;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Olha_Yeremenko on 4/26/2016.
 */
@Component
public class EventsDataCreator implements IDataCreator {

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    @Autowired
    private AuditoriumDataCreator auditoriumDataCreator;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    public Event eventFirst;

    @Autowired
    public Event eventSecond;


    @Override
    public void populateData() {
        NavigableSet<LocalDateTime> airDatesEvent = new TreeSet<LocalDateTime>();
        airDatesEvent.add(dateTimeEditor.parseText("2000-01-01"));
        airDatesEvent.add(dateTimeEditor.parseText("2000-01-02"));
        airDatesEvent.add(dateTimeEditor.parseText("2000-01-03"));

        NavigableMap<LocalDateTime, Auditorium> auditoriumsForFirst = new TreeMap<>();
        auditoriumsForFirst.put(dateTimeEditor.parseText("2000-01-01"), auditoriumDataCreator.blueAuditorium);
        auditoriumsForFirst.put(dateTimeEditor.parseText("2000-01-02"), auditoriumDataCreator.redAuditorium);
        auditoriumsForFirst.put(dateTimeEditor.parseText("2000-01-03"), auditoriumDataCreator.blueAuditorium);

        NavigableMap<LocalDateTime, Auditorium> auditoriumsForSecond = new TreeMap<>();
        auditoriumsForSecond.put(dateTimeEditor.parseText("2000-01-01"), auditoriumDataCreator.blueAuditorium);
        auditoriumsForSecond.put(dateTimeEditor.parseText("2000-01-02"), auditoriumDataCreator.redAuditorium);
        auditoriumsForSecond.put(dateTimeEditor.parseText("2000-01-03"), auditoriumDataCreator.blueAuditorium);


        eventFirst.setName("Event1");
        eventFirst.setAuditoriums(auditoriumsForFirst);
        eventFirst.setRating(EventRating.HIGH);
        eventFirst.setAirDates(airDatesEvent);
        eventFirst.setBasePrice(120);

        eventSecond.setName("Event2");
        eventSecond.setAuditoriums(auditoriumsForSecond);
        eventSecond.setRating(EventRating.LOW);
        eventSecond.setAirDates(airDatesEvent);
        eventSecond.setBasePrice(30);

        eventDAO.setEvents(Arrays.asList(eventFirst, eventSecond));

    }
}