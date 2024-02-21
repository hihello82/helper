package assistantapp.apps;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;

public class WeatherApp {
	
	
	public static String getLocation() throws IOException {
		File file = new File("/Users/ben/eclipse-workspace/assistantapp/weatherKey.txt");
		BufferedReader br = new BufferedReader(new FileReader (file));
		
		String location = "boston";
		String key = br.readLine();	
		String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + location + "&limit=1&appid=" + key;
		
		try {
			
		} catch (Exception e) {
			return "error in getting location";
		}
		
		return null;
	}
	
	
	
	
}
