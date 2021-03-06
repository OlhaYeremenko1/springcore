package ua.epam.spring.hometask.yeremenko.service.implementation;

import ua.epam.spring.hometask.yeremenko.dao.TicketDAO;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.EventRating;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.service.IBookingService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class BookingService implements IBookingService {

    private DiscountService discountService;

    private TicketDAO ticketDAO;



    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        byte discount=discountService.getDiscount(user,event,dateTime,seats.size());
        double price= event.getBasePrice()*discount/100*seats.size();

        int countVipSeats = (int)event.getAuditoriums().get(dateTime).countVipSeats(seats);
        int countAllSeats = event.getAuditoriums().get(dateTime).getAllSeats().size();

        double finalPrice=0;
        if(countAllSeats>=seats.size()){
            finalPrice=seats.size()*price+countVipSeats*price;

            if(event.getRating().equals(EventRating.HIGH)){
                finalPrice*=1.5;
            }
        }
        return finalPrice;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
       tickets.forEach(ticket -> {
         ticket.getUser().getTickets().add(ticket);
       });
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return ticketDAO.getTickets().stream().filter(ticket -> ticket.getEvent().equals(event) && ticket.getDateTime().equals(dateTime)).collect(Collectors.toSet());
    }

}
