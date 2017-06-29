
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
public class Winscreen{

	private Image a;


	public Winscreen(){

		URL loc = this.getClass().getResource("win.jpg");
		ImageIcon o = new ImageIcon(loc);
		a = o.getImage();

	}
	/*
	 * Description: This method is used to get the image of the win screen
	 * Parameters: nothing
	 * Return: image of the win screen
	 */
	public Image getP(){
		return a;
	}
	





}
