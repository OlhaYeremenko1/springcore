package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class AuditoriumDAO {

    @Autowired
    @Resource(name = "auditoriumsList")
    private List<Auditorium> auditoriumsList;

    public AuditoriumDAO() {
    }

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
}
