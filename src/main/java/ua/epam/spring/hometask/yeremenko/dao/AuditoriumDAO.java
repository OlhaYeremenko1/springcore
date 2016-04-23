package ua.epam.spring.hometask.yeremenko.dao;

import ua.epam.spring.hometask.yeremenko.domain.Auditorium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class AuditoriumDAO {

    public static void setAuditoriums(List<Auditorium> auditoriums) {
        AuditoriumDAO.auditoriums = auditoriums;
    }

    /**
     * The Auditoriums.
     */
    private static List<Auditorium> auditoriums;

    /**
     * Gets auditoriums.
     *
     * @return the auditoriums
     */
    public static List<Auditorium> getAuditoriums() {
        return auditoriums;
    }
}
