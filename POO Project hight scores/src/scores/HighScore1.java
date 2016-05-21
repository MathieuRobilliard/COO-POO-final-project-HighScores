package scores;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HighScore1 { 
	
	/**
	 * This method opens an HTTP connection with the ThingSpeak website site and asks for scores.
	 * @return containing the different interesting lines of result
	 */
	public List<String> getScores() {

		List<String> highScoresList = new ArrayList<>();	
		
		try {
			URL channelFeedURL = new URL("https://api.thingspeak.com/channels/109322/feeds.csv");
			InputStream scores = channelFeedURL.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(scores));
			// Skipping the first line.
			reader.readLine();
			String readString = reader.readLine();
			while (readString != null) {
				if (readString.length() > 0) {
					highScoresList.add(readString);
				}
				readString = reader.readLine();
			
			} // End While 
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		return highScoresList;
	}

}
