package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void shouldSortTickets(){
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(12, 200,"SVO", "EGO", 5);
        Ticket ticket2 = new Ticket(20, 900,"DME", "LED", 2);
        Ticket ticket3 = new Ticket(15, 800,"DME", "LED", 8);
        Ticket ticket4 = new Ticket(1, 700,"FRU", "DME", 3);
        Ticket ticket5 = new Ticket(200, 500,"DME", "LED", 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket5, ticket3, ticket2};
        Ticket[] actual = manager.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsInOneCase(){
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(12, 200,"SVO", "EGO", 5);
        Ticket ticket2 = new Ticket(20, 900,"DME", "LED", 2);
        Ticket ticket3 = new Ticket(15, 800,"DME", "LED", 8);
        Ticket ticket4 = new Ticket(1, 700,"FRU", "DME", 3);
        Ticket ticket5 = new Ticket(200, 500,"DME", "LED", 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("FRU", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsInZeroCase(){
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(12, 200,"SVO", "EGO", 5);
        Ticket ticket2 = new Ticket(20, 900,"DME", "LED", 2);
        Ticket ticket3 = new Ticket(15, 800,"DME", "LED", 8);
        Ticket ticket4 = new Ticket(1, 700,"FRU", "DME", 3);
        Ticket ticket5 = new Ticket(200, 500,"DME", "LED", 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }


}