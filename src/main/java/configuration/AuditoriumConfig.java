package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;

import java.util.Arrays;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.epam.spring.hometask.yeremenko.domain.Auditorium", "ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO"})
@PropertySource("classpath:auditoriums.properties")
public class AuditoriumConfig {

//    @Value("${name.red}")
//    String redName;
//
//    @Value("${seats.red}}")
//    Long redNumberOfSeats;
//
//    @Value("${vip.red}")
//    String redVipSeats;
//
//
//    @Value("${name.blue}")
//    String blueName;
//
//    @Value("${seats.blue}}")
//    Long blueNumberOfSeats;
//
//    @Value("${vip.blue}")
//    String blueVipSeats;
//
//    @Bean(name = "auditorium")
//    public Auditorium getAuditorium() {
//        return new Auditorium();
//    }
//
//    @Bean(name = "redAuditorium")
//    public Auditorium getRedAuditorium() {
//        Auditorium auditorium = new Auditorium();
//        auditorium.setName(redName);
//        auditorium.setNumberOfSeats(redNumberOfSeats);
//        auditorium.setVipSeats(redVipSeats);
//        return auditorium;
//    }
//
//    @Bean(name = "blueAuditorium")
//    public Auditorium getBlueAuditorium() {
//        Auditorium auditorium = new Auditorium();
//        auditorium.setName(blueName);
//        auditorium.setNumberOfSeats(blueNumberOfSeats);
//        auditorium.setVipSeats(blueVipSeats);
//        return auditorium;
//    }
//
//    @Bean(name = "auditoriumsDao")
//    public AuditoriumDAO auditoriumsDao() {
//        AuditoriumDAO auditoriumDAO = new AuditoriumDAO();
//        auditoriumDAO.setAuditoriumsList(Arrays.asList(getBlueAuditorium(), getRedAuditorium()));
//        return auditoriumDAO;
//    }

}
