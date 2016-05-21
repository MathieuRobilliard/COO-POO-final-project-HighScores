package scores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestHighScore4 {
	
static final String filePath = "data/scoreSamples.txt";
	
	/**
	 * Step 4, and use the others steps.
	 * @param args0
	 * @throws IOException 
	 */
	public static void main(String[] args0) throws IOException {
		
		
		String keepOn = "yes";
		Scanner scanner = new Scanner(System.in);
		while (keepOn.equals("yes"))
		{
			// Create the top10 array, with the best player in first.
			HighScore4 highScore4 = new HighScore4();
			List<String> highScoresArray = highScore4.getScores();
			BestPlayer[] top10 = new BestPlayer[10];
			top10 = highScore4.tenBestScores(highScoresArray);
			// Print the ten best lines.
			for(int j = 0 ; j < top10.length; j++) {
				System.out.println(top10[j].getScore() + " " + top10[j].getPlayer());
			}
			
			/*
			// Call getScores and print lines
			HighScore4 highScore = new HighScore4();
			List<String> highScoreList = highScore.getScores();
			
			for (int i = 0; i < highScoreList.size(); i++)
			{
				System.out.println(highScoreList.get(i));
			}
			*/
			
			//Ask if the player wants to start a game
			System.out.println("Do you want to start a new game ? yes/no : ");
			keepOn = scanner.nextLine();		
	

			if (keepOn.equals("yes")) 
			{

				// Ask the name of the player
				System.out.println("Please write the name of the player : ");
				String namePlayer = scanner.nextLine();		
				
	
				// reads all fake scores from the file
				Path file = Paths.get(filePath);
	
				List<String> scores = Files.readAllLines(file);
				int random = (int) (Math.random() * scores.size());
				String Score = scores.get(random);
				int score = Integer.parseInt(Score);
				System.out.println("The player " + namePlayer + " has a score of "+ Score);

				
				boolean testQualified = false;
				for(int j = 0 ; j < top10.length; j++) {
					if (score >= top10[j].getScore())
					{
						testQualified = true;
					}
				}
				if (testQualified == true) 
				{
					System.out.println("You are one of the 10 best players ! ");
					BestPlayer newBest = new BestPlayer (namePlayer, score);
					HighScore4.sendScore(newBest);
				}
			
			}

		}
		scanner.close();
	} // main

}