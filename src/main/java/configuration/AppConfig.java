package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ua.epam.spring.hometask.yeremenko.App;
import ua.epam.spring.hometask.yeremenko.AppRunner;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;
import ua.epam.spring.hometask.yeremenko.service.implementation.BookingService;
import ua.epam.spring.hometask.yeremenko.service.implementation.EventService;
import ua.epam.spring.hometask.yeremenko.service.implementation.UserService;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.epam.spring.hometask.yeremenko"})
public class AppConfig {
//
//    @Bean(name = "app")
//    public App app() {
//        App app=  new App();
//        app.setAppRunner(appRunner());
//        return app;
//    }
//
//    @Bean(name = "appRunner")
//    public AppRunner appRunner() {
//        return new AppRunner();
//    }
//
//    @Bean(name = "auditoriumService")
//    public AuditoriumService auditoriumService() {
//        return new AuditoriumService();
//    }
//
//    @Bean(name = "eventService")
//    public EventService eventService() {
//        return new EventService();
//    }
//
//    @Bean(name = "userService")
//    public UserService userService() {
//        return new UserService();
//    }
//
//    @Bean(name = "bookingService")
//    public BookingService bookingService() {
//        return new BookingService();
//    }
//
//    @Bean(name = "bookingService")
//    public CustomLocalDateTimeEditor dateTimeEditor() {
//        return new CustomLocalDateTimeEditor();
//    }
}
