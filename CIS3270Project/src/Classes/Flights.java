package Classes;

public class Flights {

	private String flightNumber;
	
	private String departCity;
	
	private String departState;
	
	private String arriveCity;
	
	private String arriveState;
	
	private String departTime;
	
	private String arrivalTime;
	
	private String date;
	
	private String Price;
	
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

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
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
