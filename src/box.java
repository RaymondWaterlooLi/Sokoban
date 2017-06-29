import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;

public class box extends wall {

    private int x;
    private int y;
    private Image a;
    
	public box(int x, int y){
		super(x,y);
		
		URL loc = this.getClass().getResource("boxMC.png");
		ImageIcon o = new ImageIcon(loc);
		a = o.getImage();
	}
	/*
	 * Description: This method is used to get the image of the box
	 * Parameters: nothing
	 * Return: image of the box
	 */
	public Image getP(){
		return a;
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
	
	/*
	 * Description: This method is used to change  the image of the area
	 * Parameters: nothing
	 * Return: nothing
	 */
public void setImage(){
		
		URL loc = this.getClass().getResource("boxFinalMC.png");//find the image
		
		ImageIcon o = new ImageIcon(loc);
		
		a = o.getImage();
		
	}
	

	
}
