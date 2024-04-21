package assistantapp.apps;

import java.util.Calendar;
import java.util.Date;

public class TimeApp {

	static Calendar calendar = Calendar.getInstance();
	static Date date = calendar.getTime();
	static String time = date.toString();
	
	public static String getTime() { // time function
		int hr = Integer.parseInt(time.substring(11, 13)); // int because its fine for the hour to not start with a 0
		String min = time.substring(14, 16); // has to be a string and not an int because some minutes start with 0, but ints can't do that
		
		// these if statements convert the 24 hr time into 12 hr time
		if(hr >= 12) {
			if(hr > 12) hr -= 12;
			return "The current time is: " + hr + ":" + min + " PM";
		}
		if(hr == 00) {
			hr = 12;
			return "The current time is: " + hr + ":" + min + " AM";
		}
		return "The current time is: " + hr + ":" + min + " AM";
	}
	
	public static String getDate() { // date function
		// these two arrays make the response look better by replacing abbreviations with whole words
		String[] abbArr = new String[] {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] repArr = new String[] {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		String day = "";
		String abb = time.substring(0, 3); 
		
		for(int i = 0; i < 7; i++) {
			if(abb.equals(abbArr[i])) day = repArr[i]; // replaces abbreviation with whole word
		}
		
		return "Today is: " + day + ", " + time.substring(4, 10) + ", " + time.substring(24);
	}

}
