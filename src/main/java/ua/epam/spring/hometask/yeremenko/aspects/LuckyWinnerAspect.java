package ua.epam.spring.hometask.yeremenko.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.Set;


@Aspect
@Component
public class LuckyWinnerAspect {

    @Before("execution(public void bookTickets(@Nonnull Set<Ticket> tickets)) && args(tickets) && within(ua.epam.spring.hometask.yeremenko.service.implementation.BookingService))")
    private void luckyTicketBook(@Nonnull Set<Ticket> tickets) {
        Random randomno = new Random();
        tickets.forEach(ticket -> {
            ticket.getUser().setLucky(randomno.nextBoolean());
        });
    }
}
