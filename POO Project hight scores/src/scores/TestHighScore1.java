package scores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * A fake game. Step 1.
 * @author Bezet & Robilliard 
 *
 */
public class TestHighScore1 {
	
	static final String filePath = "data/scoreSamples.txt";
	
	/**
	 * Do:
	 * 1) Ask the name of the player
	 * 2) reads all fake scores from the file
	 * 3) choose a random score
	 * 4) output the name of the player and his score
	 * -) create a highScore and call getScore and print the results.
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

	} // main

}

