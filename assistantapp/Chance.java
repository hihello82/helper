package assistantapp;

import java.io.IOException;
import java.util.*;

import assistantapp.apps.AIApp;

public class Chance {
	
	static String[] WeatherKeys = new String[] {"weather", "cold", "hot"};
	static String[] CalcKeys = new String[] {"+", "-", "x", "divide", "multipl", "times", "plus", "minus", "/", "^", "power"};
	static String[] TimeKeys = new String[] {"time"};
	static String[] MiscKeys2 = new String[] {"what", "is", "in", "the"}; 
	static String[] MiscKeys = new String[] {"town", "cit", "what", "in", "the", "is"};
	static String[] MiscKeysAbb = new String[] {"what's", "whats"};
	
	/*
	 * weather
	 * calculator
	 * time
	 * other -> AI
	 * 		image generation
	 * 		text generation
	 * 
	 * 100% threshold -> 1.04 
	 */
	
	public static String calcChance(String command){
		HashMap<String, Double> map = calcChance(breakUp(command));
		System.out.println(map.get("weather"));
		System.out.println(map.get("calc"));
		System.out.println(map.get("time"));

		if(map.get("calc") >= 1.04) {
			ButtonFrame.displayResponse("you're probably doing a calculation");
		} else if (map.get("weather") >= 1.04) {
			ButtonFrame.displayResponse("you're probably trying to get the weather");
		} else if (map.get("time") >= 1.04) {
			ButtonFrame.displayResponse("you're probably trying to get the time");
		} else {
			System.out.println(AIApp.Chat(command));
			ButtonFrame.displayResponse(AIApp.Chat(command));
		}
		return "errorincalculating chance";
	}
	
	static ArrayList<String> breakUp(String command) {
		StringTokenizer st = new StringTokenizer(command);
		ArrayList<String> ret = new ArrayList<String>();
		
		while(st.hasMoreTokens()) ret.add(st.nextToken().toLowerCase());
		
		return ret;
	}
	
	static HashMap<String, Double> calcChance(ArrayList<String> arr){

		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Double wC = compareWords(arr, WeatherKeys, true) + compareWords(arr, MiscKeys, false) + compareWords(arr, MiscKeysAbb, false);
		Double cC = compareWords(arr, CalcKeys, true) + compareWords(arr, MiscKeys2, false) + compareWords(arr, MiscKeysAbb, false);
		Double tC = compareWords(arr, TimeKeys, true) + compareWords(arr, MiscKeys2, false) + compareWords(arr, MiscKeysAbb, false); 
		
		map.put("weather", wC);
		map.put("calc", cC);
		map.put("time", tC);
		
		return map;
	}
	static Double compareWords(ArrayList<String> arr, String[] keys, boolean main) {
		Double count = 0.0;
		for(int i = 0; i < keys.length; i++) {
			if(main && arr.contains(keys[i])) {
				count++;
			} else if (!main && arr.contains(keys[i])) count += 0.02;
		}
		
		return count;
	}
}
