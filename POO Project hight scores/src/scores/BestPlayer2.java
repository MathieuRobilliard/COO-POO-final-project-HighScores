package scores;

public class BestPlayer2 {
	private String player;
	private int score;
	
	/**
	 * To know if the score of the player is better than the best player
	 * @param p The player you want to compare with the best player.
	 * @return 
	 */
	public int compareTo(BestPlayer2 p) {
		if (this.score == p.score) {
			return (0);
		} else if (this.score < p.score) {
			return (-1);
		} else if (this.score > p.score) {
			return (1);
		}
	}

}
