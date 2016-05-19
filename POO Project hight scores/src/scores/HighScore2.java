package scores;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HighScore2 {
	
	// Ici mettre les fonctions de highScore1
	public static void main(String[] args0) {
		getScores();
	}
	/**
	 * This method open a HTTP connection with the web site and asks scores.
	 * @return A array of few interesting lines to know for the scores.
	 */
	public static List<String> getScores() {

		List<String> highScoresArray = new ArrayList<>();	
		
		try {
			URL channelFeedURL = new URL("https://api.thingspeak.com/channels/109322/fields/1.json?results=2");
			URLConnection connexion = channelFeedURL.openConnection();
			InputStream flux = connexion.getInputStream();
			int dataToRead = connexion.getContentLength();
			
			for(;dataToRead != 0; dataToRead--)
			System.out.print((char)flux.read());
			flux.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		return highScoresArray;
	}


	/**
	 * 
	 * @param readScores Array get by the method geScores()
	 * @return 
	 */
	public static BestPlayer[] tenBestScores(List<String> readScores) {
		BestPlayer[] allBest = new BestPlayer[10];
		List<BestPlayer> playerRecords = new ArrayList<BestPlayer>(readScores.size());
		for(String line : readScores)
		{
			String[] fields = line.split(",");
			playerRecords.add(new BestPlayer(fields[1], Integer.parseInt(fields[2])));
		}
		Collections.sort(playerRecords, Collections.reverseOrder());

		for(int i = 0; i < playerRecords.size() && i < 10; i++)
			allBest[i] = playerRecords.get(i);

		return allBest;
		}
		
		
}