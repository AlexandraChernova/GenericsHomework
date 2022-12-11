package TicketManager;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String depAirport;
    private String arrAirport;
    private int flightTime;

    public Ticket(int id, int price, String depAirport, String arrAirport, int flightTime) {
        this.id = id;
        this.price = price;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public int getFlightTime() {
        return flightTime;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if(this.getPrice() < otherTicket.getPrice()){
            return -1;
        }
        if(this.getPrice() > otherTicket.getPrice()){
            return 1;
        }
        return 0;
    }
}
