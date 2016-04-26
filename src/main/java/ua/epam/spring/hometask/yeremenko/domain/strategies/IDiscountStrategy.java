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
public interface IDiscountStrategy {
    byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets);

}
