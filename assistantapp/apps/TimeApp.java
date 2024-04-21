package assistantapp.apps;

import java.util.Calendar;
import java.util.Date;

public class TimeApp {

	static Calendar calendar = Calendar.getInstance();
	static Date date = calendar.getTime();
	static String time = date.toString();
	
	public static String getTime() {
		int hr = Integer.parseInt(time.substring(11, 13));
		String min = time.substring(14, 16);
		
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
	
	public static String getDate() {
		String[] abbArr = new String[] {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};
		String[] repArr = new String[] {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		String day = "";
		String abb = time.substring(0, 3);
		
		for(int i = 0; i < 7; i++) {
			if(abb.equals(abbArr[i])) day = repArr[i];
		}
		
		return "Today is: " + day + ", " + time.substring(4, 10) + ", " + time.substring(24);
	}

}
