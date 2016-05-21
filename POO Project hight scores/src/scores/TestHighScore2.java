
package scores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestHighScore2 {
	
static final String filePath = "data/scoreSamples.txt";
	
	/**
	 * Step 1 and step2.
	 * @param args0
	 */
	public static void main(String[] args0) {
		
		// Call getScores and print lines
		HighScore1 highScore = new HighScore1();
		List<String> highScoreList = highScore.getScores();
		
		for (int i = 0; i < highScoreList.size(); i++)
		{
			System.out.println(highScoreList.get(i));
		}
		
		// Ask the name of the player
		Scanner nameScanner = new Scanner(System.in);
		System.out.println("Please write the name of the player : ");
		String namePlayer = nameScanner.nextLine();
		nameScanner.close();
		
		// reads all fake scores from the file
		Path file = Paths.get(filePath);
		try {
			
			List<String> scores = Files.readAllLines(file);
			int random = (int) (Math.random() * scores.size());
			String Score = scores.get(random);
			System.out.println("The player " + namePlayer + " has a score of "+ Score);
		
		} catch (IOException e) { 

			e.printStackTrace();
		}
		
		// Create the top10 array, with the best player in first.
		HighScore2 highScore2 = new HighScore2();
		List<String> highScoresArray = highScore2.getScores();
		BestPlayer[] top10 = new BestPlayer[10];
		top10 = highScore2.tenBestScores(highScoresArray);
		
		// Print the ten best lines.
		for(int j = 0 ; j < top10.length; j++) {
			System.out.println(top10[j].getScore() + " " + top10[j].getPlayer());
		}

	} // main

}