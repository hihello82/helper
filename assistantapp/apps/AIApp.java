package assistantapp.apps;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class AIApp {

	public static String chat(String command) throws IOException {
		
		File file = new File("/Users/ben/eclipse-workspace/assistantapp/GPTkey2.txt");
		BufferedReader br = new BufferedReader(new FileReader (file)); // to keep the api key secret
		
		String url = "https://api.openai.com/v1/chat/completions";
		String key = br.readLine(); 
		String model = "gpt-3.5-turbo";
		
		try { // api call is made here
			URL obj = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Authorization", "Bearer " + key);
	        connection.setRequestProperty("Content-Type", "application/json");
	
	        String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + command + "\"}]}";
	        connection.setDoOutput(true);
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	        writer.write(body);
	        writer.flush();
	        writer.close();
	
	        BufferedReader br2 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	
	        StringBuffer response = new StringBuffer();
	
	        while ((line = br2.readLine()) != null) {
	            response.append(line);
	        }
	        br2.close();
	        return formatResponse(extract(response.toString())); // formats the response and returns it
    } catch (IOException e) { // exception handler
        throw new RuntimeException(e);
    }
}
	
	public static String extract(String response) { // isolates the just the response and gets rid of everything else
	    int start = response.indexOf("content")+ 11;
	    int end = response.indexOf("}", start) - 7;
	    return response.substring(start, end);
	}
	
	public static String formatResponse(String response) { // makes sure that any line break that the api call has is formatted properly	
		response = response.replace("\\n", "\n");
		response = response.replace("\\", " "); 
		return response;
	}
}
