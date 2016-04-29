package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class AuditoriumDAO {

    private List<Auditorium> auditoriumsList;

    /**
     * Gets auditoriums.
     *
     * @return the auditoriums
     */
    public List<Auditorium> getAuditoriums() {

        if (auditoriumsList == null)
            throw new InstantiationError("Events DAO has not been instantiated");
        return auditoriumsList;
    }

    public void setAuditoriumsList(List<Auditorium> auditoriumsList) {
        this.auditoriumsList = auditoriumsList;
    }

}
