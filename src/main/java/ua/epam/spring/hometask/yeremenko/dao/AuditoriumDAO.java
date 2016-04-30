package ua.epam.spring.hometask.yeremenko.dao;

import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Auditorium;
import ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static ua.epam.spring.hometask.yeremenko.jdbc.SQlQuery.SQlQueryConst.AUDITORIUMS_TABLE_NAME;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class AuditoriumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Gets auditoriums.
     *
     * @return the auditoriums
     */
    public List<Auditorium> getAuditoriums() {
        String sql= SQlQuery.uiSqlBuilder().select("*").from(AUDITORIUMS_TABLE_NAME).build();
        return     jdbcTemplate.query(sql,getAuditoriumRowMapper());
    }

    public List<Auditorium> getAuditoriumByName(String name) {
        String sql= SQlQuery.uiSqlBuilder().select("*").from(AUDITORIUMS_TABLE_NAME).where("NAME="+name).build();
        return     jdbcTemplate.query(sql,getAuditoriumRowMapper());
    }

    public void addAuditorim(String name, int seats, String vipseats){
        String sql= SQlQuery.uiSqlBuilder().insertIntoAuditoriums().values("?,?,?").build();
        jdbcTemplate.update(sql,name,seats,vipseats);
    }

    private RowMapper<Auditorium> getAuditoriumRowMapper() {
        return new RowMapper<Auditorium>() {
            @Override
            public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
                String name = resultSet.getString("name");
                String seats = resultSet.getString("seats");
                String vips = resultSet.getString("vips");
                Auditorium auditorium =new Auditorium();
                auditorium.setName(name);
                auditorium.setNumberOfSeats(Long.parseLong(seats));
                auditorium.setVipSeats(vips);
                return auditorium;
            }
        };
    }



}
