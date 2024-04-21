package assistantapp;

import java.io.IOException;
import java.util.*;

import assistantapp.apps.AIApp;
import assistantapp.apps.TimeApp;

public class Chance {
	
	static String[] TimeKeys = new String[] {"time", "right", "now"}; // these arrays are keywords to check which feature is being requested
	static String[] DateKeys = new String[] {"date", "today", "day"}; 
	static String[] MiscKeys2 = new String[] {"what", "is", "in", "the"}; // the misc arrays are for "small" keywords which don't impact the calculation too much
	static String[] MiscKeysAbb = new String[] {"what's", "whats"};
	
	/*
	 * time
	 * date
	 * other -> AI
	 * 		text generation
	 * 
	 * 100% threshold -> 1.04 
	 */
	
	public static String calcChance(String command){
		HashMap<String, Double> map = calcChance(breakUp(command)); // creates a map for each feature and its probability

		if (map.get("time") >= 1.04) {
			ButtonFrame.displayResponse(TimeApp.getTime()); // uses the time feature
			ButtonFrame.processing = false;
		} else if (map.get("date") >= 1.04){
			ButtonFrame.displayResponse(TimeApp.getDate()); // uses the date feature
			ButtonFrame.processing = false;
		} else {
			try {
				ButtonFrame.displayResponse(AIApp.chat(command)); // uses the chatgpt api feature
				ButtonFrame.processing = false;
			} catch (IOException e){
				ButtonFrame.displayResponse("error in chatgpting response"); // in case the api returns an error
				ButtonFrame.processing = false;
			}
		}
		return "error, please try again"; // if the try catch block somehow fails
	}
	
	static ArrayList<String> breakUp(String command) { // this function breaks down the entire command into individual words and puts them into an arraylist
		StringTokenizer st = new StringTokenizer(command);
		ArrayList<String> ret = new ArrayList<String>();
		
		while(st.hasMoreTokens()) ret.add(st.nextToken().toLowerCase());
		
		return ret;
	}
	
	static HashMap<String, Double> calcChance(ArrayList<String> arr){ // this function calculates the chances of each function

		HashMap<String, Double> map = new HashMap<String, Double>(); 
		
		Double tC = compareWords(arr, TimeKeys, true) + compareWords(arr, MiscKeys2, false) + compareWords(arr, MiscKeysAbb, false); 
		Double dC = compareWords(arr, DateKeys, true) + compareWords(arr, MiscKeys2, false) + compareWords(arr, MiscKeysAbb, false);
		// the true and false determines if a certain keyword array will make a big/small impact
		
		map.put("time", tC);
		map.put("date", dC);
		
		return map;
	}

	static Double compareWords(ArrayList<String> arr, String[] keys, boolean main) { 
		// this function checks how many words match with the keyword array fed into it and adds up the total probability
		Double count = 0.0;
		for(int i = 0; i < keys.length; i++) {
			if(main && arr.contains(keys[i])) {
				count++; // important keyword
			} else if (!main && arr.contains(keys[i])) count += 0.02; // if it's a not-as-important keyword
		}
		
		return count;
	}
}
