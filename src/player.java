

import javax.swing.ImageIcon;

import java.awt.*;
import java.net.URL;
public class player {
	private int x;// x-position
	private int y;//y-position
	private Image a;//the image of the player

	public player(int x, int y){
		
		this.x=x;
		this.y=y;
		URL loc = this.getClass().getResource("creeper.png");
		ImageIcon o = new ImageIcon(loc);
		a = o.getImage();
	}


	/*
	 * Description: This method is used to get the image of the player
	 * Parameters: nothing
	 * Return: the image of the player
	 */
	public Image getP(){
		return a;
	}
	/*
	 * Description: This method is used to get the x position of player
	 * Parameters: nothing
	 * Return: the x position of the player
	 */
	public int getX(){
		return this.x;
	}
	/*
	 * Description: This method is used to get the y position of player
	 * Parameters: nothing
	 * Return: the y position of the player
	 */
	public int getY(){
		return this.y;

	}
	/*
	 * Description: This method is used to change the x position of the area
	 * Parameters: nothing
	 * Return: nothing
	 */
	public void setX(int b){
		this.x=b;
	}
	/*
	 * Description: This method is used to change the y position of the area
	 * Parameters: nothing
	 * Return: nothing
	 */
	public void setY(int b){
		this.y=b;

	}

	
	
}