package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.domain.strategies.BirthdayDiscountStrategy;
import ua.epam.spring.hometask.yeremenko.domain.strategies.EveryTenDiscountStrategy;
import ua.epam.spring.hometask.yeremenko.service.IDiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class DiscountService implements IDiscountService {

    @Autowired
    @Resource(name = "birthdayDiscountStrategy")
    private BirthdayDiscountStrategy birthdayDiscountStrategy;

    @Autowired
    @Resource(name = "everyTenDiscountStrategy")
    private EveryTenDiscountStrategy everyTenDiscountStrategy;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        byte discount = everyTenDiscountStrategy.getDiscount(user, event, airDateTime, numberOfTickets);
        if (discount == 0)
            discount = birthdayDiscountStrategy.getDiscount(user, event, airDateTime, numberOfTickets);
        return discount;
    }
}
