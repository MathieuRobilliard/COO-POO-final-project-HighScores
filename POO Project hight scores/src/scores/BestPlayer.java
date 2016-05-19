package scores;

public class BestPlayer {
	private String player;
	private int score;
	
	public BestPlayer(String player, int score){
		this.player = player;
		this.score = score;
	}

	/**
	 * To know if the score of the player is better than the best player
	 * @param p The player you want to compare with the best player.
	 * @return 
	 */
	public int compareTo(BestPlayer p) {
		if (this.score == p.score) {
			return (0);
		} else if (this.score < p.score) {
			return (-1);
		} else {
			return (1);
		}
	}
	public int getScore(){
		return this.score;
	}
	public String getPlayer(){
		return this.player;
	}

}
