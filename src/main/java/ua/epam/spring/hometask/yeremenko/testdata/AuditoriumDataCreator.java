package ua.epam.spring.hometask.yeremenko.testdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Olha_Yeremenko on 4/26/2016.
 */
@Component
public class AuditoriumDataCreator implements IDataCreator {

    @Autowired
    public Auditorium redAuditorium;

    @Autowired
    public Auditorium blueAuditorium;

    @Autowired
    public AuditoriumDAO auditoriumDAO;

    @Override
    public void populateData() {
        redAuditorium= new Auditorium();
        redAuditorium.setName("redAuditorium");
        redAuditorium.setNumberOfSeats(50);
        redAuditorium.setVipSeats("10,11,12,13");

        blueAuditorium = new Auditorium();
        blueAuditorium.setName("blueAuditorium");
        blueAuditorium.setNumberOfSeats(20);
        blueAuditorium.setVipSeats("18,19,20");
        auditoriumDAO.setAuditoriumsList(Arrays.asList(redAuditorium, blueAuditorium));
    }
}
