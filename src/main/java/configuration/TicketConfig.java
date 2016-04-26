package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.epam.spring.hometask.yeremenko.domain.Ticket"})
@Import({AuditoriumConfig.class, EventConfig.class, UserConfig.class})
public class TicketConfig {

//
//    @Autowired
//    private AuditoriumConfig auditoriumConfig;
//    @Bean
//    public Ticket ticket(){
//        auditoriumConfig.get
//        return new Ticket();
//    }


}
