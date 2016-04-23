package ua.epam.spring.hometask.yeremenko;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.hometask.yeremenko.dao.EventDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class App {

    public void setAppRunner(AppRunner appRunner) {
        this.appRunner = appRunner;
    }

    private AppRunner appRunner;



    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.appRunner.run();
        ctx.close();
    }
}
