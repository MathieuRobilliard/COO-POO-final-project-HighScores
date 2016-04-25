package scores;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HighScore1 {
	
	
	public static void main(String[] args0) {
		getScores();
	}
	/**
	 * This method open a HTTP connection with the web site and asks scores.
	 * @return A array of few interesting lines to know for the scores.
	 */
	public static String[] getScores() {

		String[] highScoresArray = new String[10];	// Taille à définir.
		
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
}

/* A faire:
 * Extraire correctement les scores de la chaine de caractères.
 * Les mettre dans un tab
 * Renvoyer ce tab
 */
