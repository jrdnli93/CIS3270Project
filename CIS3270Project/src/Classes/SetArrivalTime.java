package Classes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class SetArrivalTime {

	public String arrivalTime (String departureTime, String departureCity, String arrivalCity) {
		//Splits departure time into month day year hour minute and AM/PM
		
		String[] s = departureTime.split("[/: ]");
		
		int departMonth = Integer.parseInt(s[0]);
		
		int departDay = Integer.parseInt(s[1]);
		
		int departYear = Integer.parseInt(s[2]);
		
		int departTimeHour = Integer.parseInt(s[3]);
		
		int departTimeMinutes = Integer.parseInt(s[4]);
		
		String departAmPm = s[5];
		
		if (departAmPm.equals("PM") && departTimeHour < 12) {
			departTimeHour += 12;
		}
		
		int timeZone = 0;
		
		
		//finds GMT timezone for departure city
		//Atlanta and New York GMT-4
		if (departureCity.equals("Atlanta, GA") || departureCity.equals("New York, NY")) {
			timeZone  = 4;
		}
		//Austin GMT-5
		else if (departureCity.equals("Austin, TX")) {
			timeZone = 5;
		}
		//Los Angeles GMT-7
		else if (departureCity.equals("Los Angeles, CA")) {
			timeZone = 7;
		}
		//Honolulu GMT-10
		else if (departureCity.equals("Honolulu, HI")) {
			timeZone = 10;
		}
		
		int timeZoneArrival = 0;
		
		//Finds GMT timezone for arrival city
		if (arrivalCity.equals("Atlanta, GA") || arrivalCity.equals("New York, NY")) {
			timeZoneArrival  = 4;
		}
		else if (arrivalCity.equals("Austin, TX")) {
			timeZoneArrival = 5;
		}
		else if (arrivalCity.equals("Los Angeles, CA")) {
			timeZoneArrival = 7;
		}
		else if (arrivalCity.equals("Honolulu, HI")) {
			timeZoneArrival = 10;
		}
		
		int flightHours = 0;
		
		int flightMinutes = 0;
		
		if (departureCity.equals("Atlanta, GA") && arrivalCity.equals("New York, NY")) {
			flightHours = 2;
			flightMinutes = 25;
		}
		else if (departureCity.equals("Atlanta, GA") && arrivalCity.equals("Los Angeles, CA")) {
			flightHours = 4;
			flightMinutes = 25;
		}
		else if (departureCity.equals("Atlanta, GA") && arrivalCity.equals("Austin, TX")) {
			flightHours = 2;
			flightMinutes = 15;
		}
		else if (departureCity.equals("Atlanta, GA") && arrivalCity.equals("Honolulu, Hawaii")) {
			flightHours = 8;
			flightMinutes = 50;
		}
		else if (departureCity.equals("New York, NY") && arrivalCity.equals("Atlanta, GA")) {
			flightHours = 2;
			flightMinutes = 25;
		}
		else if (departureCity.equals("New York, NY") && arrivalCity.equals("Los Angeles, CA")) {
			flightHours = 5;
			flightMinutes = 45;
		}
		else if (departureCity.equals("New York, NY") && arrivalCity.equals("Austin, TX")) {
			flightHours = 4;
			flightMinutes = 0;
		}
		else if (departureCity.equals("New York, NY") && arrivalCity.equals("Honolulu, HI")) {
			flightHours = 10;
			flightMinutes = 25;
		}
		else if (departureCity.equals("Los Angeles, CA") && arrivalCity.equals("Atlanta, GA")) {
			flightHours = 4;
			flightMinutes = 25;
		}
		else if (departureCity.equals("Los Angeles, CA") && arrivalCity.equals("Austin, TX")) {
			flightHours = 3;
			flightMinutes = 0;
		}
		else if (departureCity.equals("Los Angeles, CA") && arrivalCity.equals("New York, NY")) {
			flightHours = 5;
			flightMinutes = 45;
		}
		else if (departureCity.equals("Los Angeles, CA") && arrivalCity.equals("Honolulu, HI")) {
			flightHours = 5;
			flightMinutes = 30;
		}
		else if (departureCity.equals("Austin, TX") && arrivalCity.equals("Atlanta, GA")) {
			flightHours = 2;
			flightMinutes = 15;
		}
		else if (departureCity.equals("Austin, TX") && arrivalCity.equals("Los Angeles, CA")) {
			flightHours = 3;
			flightMinutes = 0;
		}
		else if (departureCity.equals("Austin, TX") && arrivalCity.equals("New York, NY")) {
			flightHours = 4;
			flightMinutes = 0;
		}
		else if (departureCity.equals("Austin, TX") && arrivalCity.equals("Honolulu, HI")) {
			flightHours = 9;
			flightMinutes = 45;
		}
		else if (departureCity.equals("Honolulu, HI") && arrivalCity.equals("Atlanta, GA")) {
			flightHours = 8;
			flightMinutes = 50;
		}
		else if (departureCity.equals("Honolulu, HI") && arrivalCity.equals("Austin, TX")) {
			flightHours = 5;
			flightMinutes = 30;
		}
		else if (departureCity.equals("Honolulu, HI") && arrivalCity.equals("New York, NY")) {
			flightHours = 10;
			flightMinutes = 25;
		}
		else if (departureCity.equals("Honolulu, HI") && arrivalCity.equals("Los Angeles, CA")) {
			flightHours = 5;
			flightMinutes = 30;
		}
		
		Date arrivalTime = new Date();
		DateFormat df = new SimpleDateFormat();
		
		//df.setTimeZone(TimeZone.getTimeZone("GMT-" + timeZone));
		
		arrivalTime.setYear(arrivalTime.getYear());
		arrivalTime.setMonth(departMonth-1);
		arrivalTime.setDate(departDay);
		arrivalTime.setHours(departTimeHour + flightHours);
		arrivalTime.setMinutes(departTimeMinutes + flightMinutes);
		
		
		//Fix timezone
		df.setTimeZone(TimeZone.getTimeZone("GMT-" + timeZoneArrival));
		
		
		
		return df.format(arrivalTime.getTime());
		
		
		
	}
}
