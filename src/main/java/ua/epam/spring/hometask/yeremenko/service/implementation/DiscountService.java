package ua.epam.spring.hometask.yeremenko.service.implementation;

import ua.epam.spring.hometask.yeremenko.domain.DiscountStrategy;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.service.IDiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class DiscountService  implements IDiscountService{


    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }


    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {

        return  discountStrategy.getDiscount(user,event,airDateTime,numberOfTickets);
    }
}
