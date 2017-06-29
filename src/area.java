
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
public class area{

	private int x;//the x position of chosen area
	private int y;//the y position of chosen area
	private Image a;//the image of chosen area

	
	public area(int x, int y){
		this.x= x;
		this.y=y;
		URL loc = this.getClass().getResource("wood.png");
		ImageIcon o = new ImageIcon(loc);
		a = o.getImage();

	}
	/*
	 * Description: This method is used to get the x position of the area
	 * Parameters: nothing
	 * Return: int x: the x position of the area
	 */
	public int getX(){
		return this.x;
	}
	/*
	 * Description: This method is used to get the x position of the area
	 * Parameters: nothing
	 * Return: int y: the y position of the area
	 */
	public int getY(){
		return this.y;
	}
	/*
	 * Description: This method is used to get the image of the area
	 * Parameters: nothing
	 * Return: image a: the image of the area
	 */
	public Image getP(){
		return a;
	}
	
	/*
	 * Description: This method is clear the image of the area, change it into null
	 * Parameters: nothing
	 * Return: nothing	 */
	public void emptyImage(){
//		URL loc = this.getClass().getResource("boxFinalMC.png");
//		ImageIcon o = new ImageIcon(loc);
		a = null;
	}
	
	public void setImage(){
		
		URL loc = this.getClass().getResource("wood.png");//find the image
		
		ImageIcon o = new ImageIcon(loc);
		
		a = o.getImage();
		
	}






}
