package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class TicketDAO {

    @Autowired
    @Resource(name = "ticketsList")
    private Set<Ticket> tickets;

    /**
     * Gets tickets.
     *
     * @return the tickets
     */
    public Set<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Add tickets.
     *
     * @param ticket the ticket
     */
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
    public void addTickets(Set<Ticket> bookedTickets){
        getTickets().addAll(bookedTickets);
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

}
