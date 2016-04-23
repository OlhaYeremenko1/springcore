package ua.epam.spring.hometask.yeremenko.domain;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DiscountStrategy {

    private DiscountStrategy() {
    }

    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        if(airDateTime.isAfter( user.getBirthday())&& airDateTime.isBefore(user.getBirthday().plus(5, ChronoUnit.DAYS)))
           return getBirthdayDiscount();
        if ((user.getTickets().size() + 1) % 10 == 0 )
            return getTenthTicketDiscount();
        if (numberOfTickets % 10 == 0 )
            return getTenthTicketDiscount();
        return 100;
    }

    public byte getBirthdayDiscount(){
        return 5;
    }

    public byte getTenthTicketDiscount(){
        return 50;
    }



}
