package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;

import javax.annotation.Resource;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class TicketDAO {

    private Set<Ticket> tickets;

    public Set<Ticket> getTickets() {
        if(tickets==null)
                return new TreeSet<Ticket>();
        return tickets;
    }

    public void addTickets(Set<Ticket> bookedTickets){
        getTickets().addAll(bookedTickets);
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

}
