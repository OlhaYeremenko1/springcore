package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.service.IAuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class AuditoriumService implements IAuditoriumService {

    @Autowired
    private AuditoriumDAO auditoriumsDAO;

    @Nonnull
    @Override
    public List<Auditorium> getAll() {
        return auditoriumsDAO.getAuditoriums();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumsDAO.getAuditoriumByName(name).get(0);
    }

    public  void addAuditorium(String name, int seats, String vipseats){
        auditoriumsDAO.addAuditorim(name,seats,vipseats);
    }

}
