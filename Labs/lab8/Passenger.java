class Passenger {
	private int passportNum;
	private Flight flight;
	
	public Passenger(int passport) {
		this.passportNum = passport;
	}
	
	public void board(Flight flight) {
		if(this.flight == null) {
			this.flight = flight;
			this.flight.addPassenger(this);
		}
	}
	
	public void disembark() {
		if(this.flight != null) {
			this.flight.removePassenger(this);
			this.flight = null;
		}
	}
	
	public void connect(Flight f) {
		if(this.flight != null
		&& this.flight.getDestination().equals(f.getOrigin())) {
			disembark();
			board(f);
		}
	}
	
	public String toString() {
		return "Passenger " + this.passportNum;
	}
}
