package assistantapp.apps;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class AIApp {

	public static String chatGPT(String command) throws IOException {
		
		File file = new File("/Users/ben/eclipse-workspace/assistantapp/GPTkey2.txt");
		BufferedReader br = new BufferedReader(new FileReader (file));
		
		String url = "https://api.openai.com/v1/chat/completions";
		String key = br.readLine();
		String model = "gpt-3.5-turbo";
		
		try {
			URL obj = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Authorization", "Bearer " + key);
	        connection.setRequestProperty("Content-Type", "application/json");
	
	        // The request body
	        String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + command + "\"}]}";
	        connection.setDoOutput(true);
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	        writer.write(body);
	        writer.flush();
	        writer.close();
	
	        // Response from ChatGPT
	        BufferedReader br2 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	
	        StringBuffer response = new StringBuffer();
	
	        while ((line = br2.readLine()) != null) {
	            response.append(line);
	        }
	        br2.close();
	
	        return extractMessageFromJSONResponse(response.toString());

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
	
	public static String extractMessageFromJSONResponse(String response) {
		
	    int start = response.indexOf("content")+ 11;
	    int end = response.indexOf("\"", start);
	    return response.substring(start, end);
		
	}
	
	public static String Chat(String command){
		try {
			return (chatGPT(command));
		} catch (IOException e) {
			return "error";
		}
	}

}
