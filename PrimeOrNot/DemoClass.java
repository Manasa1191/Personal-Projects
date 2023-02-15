package demoPack;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.json.simple.JSONObject;
//import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;
public class DemoClass implements RequestStreamHandler{
	

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		// JSONParser reads JSON data from API
		JSONParser parser = new JSONParser();
		//BufferedReader reads data efficient way character by character 
	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    //JSONObject shows collection of name value pairs from the data
	    JSONObject responseJson = new JSONObject();
	    JSONObject event;
	    String isPrime="Not prime";
	    try {
			event = (JSONObject) parser.parse(reader);
			context.getLogger().log("input " + event.get("body"));
		    int myCount = Integer.parseInt((String)event.get("body"));
			
			int count=0;
			
			for(int i=2;i<myCount;i++) {
				if(myCount%i==0) {
					count++;
				}
			}
			if(count==0) {
				isPrime="prime";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		//return "my Count: "+myCount;
		
		JSONObject responseBody = new JSONObject();
        responseBody.put("message", "Your input is: "+isPrime);
        responseJson.put("statusCode", 200);
        responseJson.put("body", responseBody.toString());
        OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
	}
}
