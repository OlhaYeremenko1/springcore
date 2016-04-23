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
           return 5;
        if ((user.getTickets().size() + 1) % 10 == 0 )
            return 50;
        if (numberOfTickets % 10 == 0 )
            return 50;
        return 0;
    }


}
