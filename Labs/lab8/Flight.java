import java.util.ArrayList;

class Flight {
	private String origin;
	private String destination;
	private ArrayList<Passenger> passengers;
	
	public Flight(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
		this.passengers = new ArrayList<Passenger>();
	}
	
	public void addPassenger(Passenger p) {
		this.passengers.add(p);
	}
	
	public void removePassenger(Passenger p) {
		this.passengers.remove(p);
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public String toString() {
		String ret = "Flight:" + this.origin + "-" + this.destination + "\n";
				
		for(Passenger p: this.passengers) {
			ret += p + "\n";
		}

		return ret;
	}
}
