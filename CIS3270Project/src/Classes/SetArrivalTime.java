package Classes;
import java.util.Date;
import java.util.GregorianCalendar;

public class SetArrivalTime {

	public String arrivalTime (String departureTime, String departureCity, String arrivalCity) {
		
		String[] s = departureTime.split("[: ]");
		
		int departTimeHour = Integer.parseInt(s[0]);
		
		int departTimeMinutes = Integer.parseInt(s[1]);
		
		String departAmPm = s[3];
		
		GregorianCalendar g = new GregorianCalendar();
		
		
		
		int timeZone = 0;
		
		if (departureCity.equals("Atlanta, GA") || departureCity.equals("New York, NY")) {
			timeZone  = 0;
		}
		else if (departureCity.equals("Austin, TX")) {
			timeZone = 1;
		}
		else if (departureCity.equals("Los Angeles, CA")) {
			timeZone = 3;
		}
		else if (departureCity.equals("Honolulu, HI")) {
			timeZone = 6;
		}
		
		
		
	}
}
