package ua.epam.spring.hometask.yeremenko.dao;

import ua.epam.spring.hometask.yeremenko.domain.Ticket;

import java.util.List;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
public class TicketDAO {

    public static  List<Ticket> getTickets() {
        return tickets;
    }

    public static void setTickets(List<Ticket> tickets) {
        TicketDAO.tickets = tickets;
    }

    private static List<Ticket> tickets;

}
