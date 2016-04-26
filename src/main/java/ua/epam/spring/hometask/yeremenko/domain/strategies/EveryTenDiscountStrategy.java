package ua.epam.spring.hometask.yeremenko.domain.strategies;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Component
public class EveryTenDiscountStrategy implements IDiscountStrategy {


    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        if ((user.getTickets().size() + 1) % 10 == 0)
            return 10;
        if (numberOfTickets % 10 == 0)
            return 10;
        return 0;
    }
}
