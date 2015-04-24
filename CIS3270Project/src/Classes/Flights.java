package Classes;

public class Flights {

	private String flightNumber;
	
	private String departCity;
	
	private String departState;
	
	private String arriveCity;
	
	private String arriveState;
	
	private int maxPassengers;
	
	private int bookedPassengers;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public String getDepartState() {
		return departState;
	}

	public void setDepartState(String departState) {
		this.departState = departState;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	public String getArriveState() {
		return arriveState;
	}

	public void setArriveState(String arriveState) {
		this.arriveState = arriveState;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public int getBookedPassengers() {
		return bookedPassengers;
	}

	public void setBookedPassengers(int bookedPassengers) {
		this.bookedPassengers = bookedPassengers;
	}
	
	
}
