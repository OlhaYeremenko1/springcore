package ua.epam.spring.hometask.yeremenko.domain.strategies;


import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class BirthdayDiscountStrategy implements IDiscountStrategy {

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        if (airDateTime.isAfter(user.getBirthday()) && airDateTime.isBefore(user.getBirthday().plus(5, ChronoUnit.DAYS)))
            return 5;
        return 0;
    }
}
