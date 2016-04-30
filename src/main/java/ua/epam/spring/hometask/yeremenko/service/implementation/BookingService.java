package ua.epam.spring.hometask.yeremenko.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.dao.TicketDAO;
import ua.epam.spring.hometask.yeremenko.domain.Event;
import ua.epam.spring.hometask.yeremenko.domain.EventRating;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;
import ua.epam.spring.hometask.yeremenko.domain.User;
import ua.epam.spring.hometask.yeremenko.service.IBookingService;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class BookingService implements IBookingService {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;


    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        byte discount = discountService.getDiscount(user, event, dateTime, seats.size());
        double price = event.getTicketBasePrice() * discount / 100 * seats.size();

        int countVipSeats = (int) event.getAuditoriums().get(dateTime).countVipSeats(seats);
        int countAllSeats = event.getAuditoriums().get(dateTime).getAllSeats().size();

        double finalPrice = 0;
        if (countAllSeats >= seats.size()) {
            finalPrice = seats.size() * price + countVipSeats * price;

            if (event.getRating().equals(EventRating.HIGH)) {
                finalPrice *= 1.5;
            }
        }
        return finalPrice;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        tickets.forEach(ticket -> {
            if (!ticketDAO.getAllTickets().contains(ticket)) {
                String date=ticket.getDateTime().toString().split("T")[0].toString();
                ticketDAO.addTicket(ticket.getUser().getEmail(),ticket.getEvent().getEventName(),date,(int)ticket.getSeat());
                ticket.getUser().getTickets().add(ticket);
            } else {
                System.out.println(String.format("Ticket has already booked %s", ticket.toString()));
            }
        });
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        Set<Ticket> ticketsForAllDates = ticketDAO.getAllTickets().stream().filter(ticket -> ticket.getEvent()
                .equals(event)).collect(Collectors.toSet());
        Set<Ticket> needed = ticketsForAllDates.stream().filter(ticket -> ticket.getDateTime()
                .equals(dateTime)).collect(Collectors.toSet());
        return needed;
    }

    public void addTicket(String eventName, String date, String userEmail,int seat) {
         ticketDAO.addTicket(userEmail,eventName,date,seat);
    }

}
