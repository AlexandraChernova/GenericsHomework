package TicketManager;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket product) {
        repository.add(product);
    }

    public Ticket[] findAll(String depAirport, String arrAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, depAirport, arrAirport)){
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }


    private boolean matches(Ticket ticket, String depAirport, String arrAirport) {
        if (ticket.getDepAirport().equals(depAirport)){
            if (ticket.getArrAirport().equals(arrAirport)){
                return true;
            }
            }
        return false;
        }
    }



