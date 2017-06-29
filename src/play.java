
public class play implements Comparable<play> {
    String name ="";//the name of the player
    int score;//the score of the player
    
    public play(String name,int score){
    	this.name= name;
    	this.score= score;
    }
    
    /*
	 * Description: This method is used to compare which player's score is higher
	 * Parameters: play a: the player a that compared with
	 * Return: positive: if a is higher than this one
	 * negative: if this is higher than a
	 * 0: they are the same
	 */
    public int compareTo(play a){
		return (a.score-this.score);
	}
    
    /*
	 * Description: This method is used to get the strint of player's name and score
	 * Parameters: nothing
	 * Return:the name of the player and the score
	 */
    public String toString(){
    	return (name+"   "+score);
    }
    

    
    
}
