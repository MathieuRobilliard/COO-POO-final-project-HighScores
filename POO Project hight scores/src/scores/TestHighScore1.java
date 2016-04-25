package scores;
import java.io.*;
import java.util.Scanner;

public class TestHighScore1 {
	
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

		// 3) choose a random score
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
		int randomNumber = (int)(Math.random() * (counterLines) - 1);
		String selectedScore = scoresArray[randomNumber];
		
		// 4) output the name of the player and his score
		System.out.println(selectedScore + " " + namePlayer);
		
		// -) create a highScore and call getScore and print the results.
		HighScore1 highScore1 = new HighScore1();
		String[] highScoresArray = highScore1.getScores();
		for (int i = 0; i < (highScoresArray.length); i++) {
			System.out.println(highScoresArray[i]);
		}
	}
	

}


