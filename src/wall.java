
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
public class wall {

	private int x;// the x position of the wall
	private int y;// the y position of the wall
	private Image a;// the image of the wall


	public wall(int x, int y){
		this.x= x;
		this.y=y;
		URL loc = this.getClass().getResource("L.png");
		ImageIcon o = new ImageIcon(loc);
		a = o.getImage();

	}
	/*
	 * Description: This method is used to get the x position of the wall
	 * Parameters: nothing
	 * Return: int x-position of the wall
	 */
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	/*
	 * Description: This method is used to get the image of the wall
	 * Parameters: nothing
	 * Return: image of the wall
	 */
	public Image getP(){
		return a;
	}






}
