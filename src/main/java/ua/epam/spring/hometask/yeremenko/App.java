package ua.epam.spring.hometask.yeremenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.jdbc.DBManager;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class App {

    @Autowired
    private AppRunner appRunner;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = (App) ctx.getBean(App.class);
        app.appRunner.run();
        ctx.close();
    }
}
