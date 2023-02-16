class Ticket {
    private String name;
    private double price;
    private int miles;

    public Ticket(String name, double price, int miles) {
        this.name = name;
        this.price = price;
        this.miles = miles;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public double getMiles() {
        return this.miles;
    }
}

class MilesCard {
    private String name;
    private int points;
    private double rate;

    public MilesCard(String name) {
        this.name = name;
        this.points = 0;
        this.rate = 10;
    }

    public void addMiles(double euros) {
        this.points += (int)euros * rate;
    }

    public void addMiles(Ticket ticket) {
        if(this.name.equals(ticket.getName())) {
            this.points += ticket.getMiles();
        }
    }

    public boolean buyTicket(Ticket ticket) {
        if(this.name.equals(ticket.getName()) && ticket.getPrice() * rate <= this.points) {
            points -= (int)ticket.getPrice() * rate;
            return true;
        }
        return false;
    }

    public String toString() {
        return name + ": " + points + " points";
    }

    public boolean equals(MilesCard other) {
        return this.name.equals(other.name);
    }
}

class MilesTraveller {
    public static void main(String args[]) {
        MilesCard card = new MilesCard("Panayiotis");
        
        Ticket ticket1 = new Ticket("Panayiotis", 800, 3000);
        card.addMiles(ticket1);

        Ticket ticket2 = new Ticket("Panayiotis", 520, 1000);
        System.out.println(card);

        while(!card.buyTicket(ticket2)) {
            card.addMiles(100);
            System.out.println(card);
        }
        System.out.println(card);
    }
}
