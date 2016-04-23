package ua.epam.spring.hometask.yeremenko.service.implementation;

import ua.epam.spring.hometask.yeremenko.dao.AuditoriumDAO;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.service.IAuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class AuditoriumService implements IAuditoriumService {

    public AuditoriumService() {
    }

    @Nonnull
    @Override
    public List<Auditorium> getAll() {
        return AuditoriumDAO.getAuditoriums();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
     return  AuditoriumDAO.getAuditoriums().stream().filter(a->a.getName().equals(name)).findAny().get();
    }
}
