package ua.epam.spring.hometask.yeremenko;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.dao.EventDAO;
import ua.epam.spring.hometask.yeremenko.dao.TicketDAO;
import ua.epam.spring.hometask.yeremenko.dao.UserDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;
import ua.epam.spring.hometask.yeremenko.service.implementation.BookingService;
import ua.epam.spring.hometask.yeremenko.service.implementation.EventService;
import ua.epam.spring.hometask.yeremenko.service.implementation.UserService;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.epam.spring.hometask.yeremenko"})
public class AppConfig {

    @Bean(name = "app")
    public App app() {
        return new App();
    }

    @Bean(name = "appRunner")
    public AppRunner appRunner() {
        return new AppRunner();
    }

    @Bean(name = "auditoriumService")
    public AuditoriumService auditoriumService() {
        return new AuditoriumService();
    }

    @Bean(name = "eventService")
    public EventService eventService() {
        return new EventService();
    }

    @Bean(name = "userService")
    public UserService userService() {
        return new UserService();
    }

    @Bean(name = "bookingService")
    public BookingService bookingService() {
        return new BookingService();
    }

    //dao
    @Bean(name = "userDao")
    public UserDAO userDao() {
        return new UserDAO();
    }

    @Bean(name = "auditoriumsDao")
    public AuditoriumDAO auditoriumsDao() {
        return new AuditoriumDAO();
    }

    @Bean(name = "eventDAO")
    public EventDAO eventDAO() {
        return new EventDAO();
    }

    @Bean(name = "ticketDAO")
    public TicketDAO ticketDAO() {
        return new TicketDAO();
    }

    ///domains

    @Bean(name = "user")
    @Scope("prototype")
    public User getUser() {
        return new User();
    }

    @Bean(name = "auditorium")
    @Scope("prototype")
    public Auditorium getAuditorium() {
        return new Auditorium();
    }

    @Bean(name = "event")
    @Scope("prototype")
    public Event getEvent() {
        return new Event();
    }

    @Bean(name = "ticket")
    public Ticket ticket() {
        return new Ticket();
    }

}

