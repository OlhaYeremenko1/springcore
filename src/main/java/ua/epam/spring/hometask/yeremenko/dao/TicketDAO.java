package ua.epam.spring.hometask.yeremenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.Ticket;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class TicketDAO {

    @Autowired
    @Resource(name = "ticketsList")
    private List<Ticket> tickets;

    /**
     * Gets tickets.
     *
     * @return the tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }
}
