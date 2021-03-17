package day16Proj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsSender {
	public static void main(String[] args) {
        
        try {
            // Construct data
            String apiKey = "apikey=" + "NDc0ZDdiOTdmOTc5OGE1YjliYjIyN2JiMWZjYzZiMWY=";
            String message = "&message=" + "Greetings from Simplifying Tech! Have a nice day!";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + "8870174655";
 
            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
             
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            System.out.println(stringBuffer.toString());
            rd.close();
 
 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
