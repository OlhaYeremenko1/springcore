package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.EventRating;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.epam.spring.hometask.yeremenko.domain.Event","ua.epam.spring.hometask.yeremenko.dao.EventDAO"})
@Import(AuditoriumConfig.class)
public class EventConfig {
//    @Autowired
//    private CustomLocalDateTimeEditor dateTimeEditor;
//
//    @Autowired
//    private AuditoriumConfig auditoriumConfig;
//
//    @Bean(name = "eventFirst")
//    public Event getEventFirst() {
//        NavigableSet<LocalDateTime> airDatesEvent1 = new TreeSet<LocalDateTime>();
//        airDatesEvent1.add(dateTimeEditor.parseText("2000-01-01"));
//        airDatesEvent1.add(dateTimeEditor.parseText("2000-01-02"));
//        airDatesEvent1.add(dateTimeEditor.parseText("2000-01-03"));
//
//        NavigableMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();
//        auditoriums.put(dateTimeEditor.parseText("2000-01-01"),auditoriumConfig.getRedAuditorium());
//        auditoriums.put(dateTimeEditor.parseText("2000-01-02"),auditoriumConfig.getRedAuditorium());
//        auditoriums.put(dateTimeEditor.parseText("2000-01-03"),auditoriumConfig.getBlueAuditorium());
//
//        Event eventFirst = getEvent();
//        eventFirst.setName("Event1");
//        eventFirst.setAuditoriums(auditoriums);
//        eventFirst.setRating(EventRating.HIGH);
//        eventFirst.setAirDates(airDatesEvent1);
//        eventFirst.setBasePrice(120);
//        return eventFirst;
//    }
//
//    @Bean(name = "eventSecond")
//    public Event getEventSecond() {
//        NavigableSet<LocalDateTime> airDatesEvent2 = new TreeSet<LocalDateTime>();
//        airDatesEvent2.add(dateTimeEditor.parseText("2000-01-02"));
//        airDatesEvent2.add(dateTimeEditor.parseText("2000-01-03"));
//
//        NavigableMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();
//        auditoriums.put(dateTimeEditor.parseText("2000-01-02"),auditoriumConfig.getRedAuditorium());
//        auditoriums.put(dateTimeEditor.parseText("2000-01-02"),auditoriumConfig.getBlueAuditorium());
//        auditoriums.put(dateTimeEditor.parseText("2000-01-03"),auditoriumConfig.getBlueAuditorium());
//
//        Event eventFirst = getEvent();
//        eventFirst.setName("Event2");
//        eventFirst.setAuditoriums(auditoriums);
//        eventFirst.setRating(EventRating.LOW);
//        eventFirst.setAirDates(airDatesEvent2);
//        eventFirst.setBasePrice(50);
//        return eventFirst;
//    }
//
//    @Bean(name = "event")
//    @Scope("prototype")
//    public Event getEvent() {
//        return new Event();
//    }
}
