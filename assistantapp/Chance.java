package assistantapp;

import java.util.*;

public class Chance {
	
	String[] WeatherKeys = new String[] {"weather", "cold", "hot"};
	String[] CalcKeys = new String[] {"+", "-", "x", "divide", "multipl", "times", "plus", "minus", "/", "^", "power"};
	String[] TimeKeys = new String[] {"time"};
	String[] MiscKeys2 = new String[] {"what", "is", "in", "the"}; 
	String[] MiscKeys = new String[] {"town", "cit", "what", "in", "the", "is"};
	
	/*
	 * weather
	 * calculator
	 * time
	 * other -> AI
	 * 
	 * 100% threshold -> 1.04 
	 */
	
	Chance(String command){
		HashMap<String, Double> map = calcChance(breakUp(command));
		System.out.println(map.get("weather"));
		System.out.println(map.get("calc"));
		System.out.println(map.get("time"));
	}
	
	ArrayList<String> breakUp(String command) {
		StringTokenizer st = new StringTokenizer(command);
		ArrayList<String> ret = new ArrayList<String>();
		
		while(st.hasMoreTokens()) ret.add(st.nextToken().toLowerCase());
		
		return ret;
	}
	
	HashMap<String, Double> calcChance(ArrayList<String> arr){

		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Double wC = compareWords(arr, WeatherKeys, true) + compareWords(arr, MiscKeys, false);
		Double cC = compareWords(arr, CalcKeys, true) + compareWords(arr, MiscKeys2, false);
		Double tC = compareWords(arr, TimeKeys, true) + compareWords(arr, MiscKeys2, false); 
		
		map.put("weather", wC);
		map.put("calc", cC);
		map.put("time", tC);
		
		return map;
	}
	Double compareWords(ArrayList<String> arr, String[] keys, boolean main) {
		Double count = 0.0;
		for(int i = 0; i < keys.length; i++) {
			if(main && arr.contains(keys[i])) {
				count++;
			} else if (!main && arr.contains(keys[i])) count += 0.02;
		}
		
		return count;
	}
}
