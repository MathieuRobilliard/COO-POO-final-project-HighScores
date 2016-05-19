package scores;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class TestHighScore2 {
	
	/**
	 * Do:
	 * 1) Ask the name of the player
	 * 2) reads all fake scores from the file
	 * 3) choose a random score
	 * 4) output the name of the player and his score
	 * -) create a highScore and call getScore and print the results.
	 * @param args0	For main.
	 */
	public static void main(String[] args0) {
		
		// 1) Ask the name of the player	-- OK
		Scanner nameScanner = new Scanner(System.in);
		System.out.println("Please write the name of the player : ");
		String namePlayer = nameScanner.nextLine();
		
		// 2) reads all fake scores from the file
		int counterLines = 0;	// to know how many lines in the file
		try  {
			File scoreSamples = new File("scoreSamples.txt");	// File in the ~ of the project
			FileReader scoreSamplesReader = new FileReader(scoreSamples); 
			BufferedReader bufferedReader = new BufferedReader(scoreSamplesReader);
			
			try {
				System.out.println("Scores list: ");
		        String line = bufferedReader.readLine();
		        counterLines++;	
		        while (line != null) {
		        	System.out.println(line);
		        	counterLines++;	
		            line = bufferedReader.readLine();	
		            
		        }
		        bufferedReader.close();
		        scoreSamplesReader.close();
		    }
		    catch (IOException exception) {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception) {
		    System.out.println ("Le fichier n'a pas été trouvé");
		}

		String[] scoresArray = new String[counterLines];	// Contain all the scores
		int counterArray = 0;	// To know where we are in the array.
		
		try  {
			File scoreSamples = new File("scoreSamples.txt");	// File in the ~ of the project
			FileReader scoreSamplesReader = new FileReader(scoreSamples); 
			BufferedReader bufferedReader = new BufferedReader(scoreSamplesReader);
			try {
		        String line = bufferedReader.readLine();
		        while (line != null) {
		            scoresArray[counterArray] = line;
		            counterArray++;
		            line = bufferedReader.readLine();
		        }
		        bufferedReader.close();
		        scoreSamplesReader.close();
		    }
		    catch (IOException exception) {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception) {
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
		
		System.out.println("---");
				
		// 4) output the names of the players and their scores
		
		// -) create a highScore and call getScore and print the results.
		HighScore2 highScore2 = new HighScore2();
		List<String> highScoresArray = highScore2.getScores();
		BestPlayer[] top10 = new BestPlayer[10];
		top10 = highScore2.tenBestScores(highScoresArray);
		
		System.out.println(top10);
		for(int j = 0 ; j < top10.length; j++) {
			System.out.println(top10[j].getScore() + " " + top10[j].getPlayer());
		}
	}
	

}


