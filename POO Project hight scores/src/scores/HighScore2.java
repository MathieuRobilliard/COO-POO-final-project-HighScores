package scores;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScore2 {
	
	/**
	 * This method opens an HTTP connection with the ThingSpeak web site site and asks for scores.
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
	}//End getScores()
	
	/**
	 * Take the list from the URL and parse each line to keep only the name and the score.
	 * @param readScores List with all the lines from the csv file.
	 * @return An array with the ten best players of the game. The best score is in first.
	 */
	public BestPlayer[] tenBestScores(List<String> readScores) {
		
		List<BestPlayer> allBest = new ArrayList<>();	// All scores from the URL parsed
		BestPlayer[] top10 = new BestPlayer[10];	// The 10 best scores
		
		//For each line in readScore, we insert the name and the score of the player of the line in allBest
		String[] line;
		for (int i = 0; i<readScores.size(); i++) 
		{
			line = readScores.get(i).split(",");
			String nomPlayer = line[3];
			int scorePlayer = Integer.parseInt(line[2]);
			BestPlayer player = new BestPlayer(nomPlayer,scorePlayer);
			allBest.add(player);
		}
		
		// Order allBest by score with the best player in first.
		Collections.sort(allBest, Collections.reverseOrder());
		
		for (int i = 0; i <10; i++) {
			top10[i] = allBest.get(i);
		}

		return top10; 
		
		}

}
=======
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
>>>>>>> origin/master
