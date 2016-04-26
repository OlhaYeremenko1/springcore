package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.service.IAuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
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
     return  getAll().stream().filter(a->a.getName().equals(name)).findAny().get();
    }

    @Nullable
    public Long getSeatsNumber(Auditorium auditorium) {
        return auditorium.getNumberOfSeats();
    }

    @Nullable
    public Set<Long> getVipSeats(Auditorium auditorium) {
        return auditorium.getVipSeats();
    }

    public void setAuditoriumsDAO(AuditoriumDAO auditoriumsDAO) {
        this.auditoriumsDAO = auditoriumsDAO;
    }

}
