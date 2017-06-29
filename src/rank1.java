import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class rank1 extends JPanel implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<play> ranks= new ArrayList<play>();
	static String player="";
	String topFive;//the top five players list
	JFrame map;// the main frame
	JPanel contentPane;
	public rank1(){
		map=new JFrame();
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(500,500);
		map.setTitle("Ranks!");
		map.setLocationRelativeTo (null);
		board.getFrom();


		contentPane = new JPanel ();
		contentPane.setLayout (new BoxLayout (contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setFocusable(true);

		contentPane.add (new MyCanvas ());
		contentPane.addKeyListener(this);
		map.add(contentPane);
		map.setVisible(true);
	}

	class MyCanvas extends JComponent{
		

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/*
		 * Description: This method is used to paint all the images and texts
		 * Parameters: graphics g: used to paint
		 * Return: nothing
		 */
		public void paint(Graphics g){
			super.paint(g);
			Image background;
			URL loc = this.getClass().getResource("CaptureSSS.PNG");// set the background image
			ImageIcon o = new ImageIcon(loc);
			background = o.getImage();
			g.drawImage(background,0, 0, 500,500,null);
			/*
			 * This section is to read the players' scores from the file
			 */
			
			Collections.sort(ranks);//rank the scores from highest to lowest
			int y=200;//the y- postion of the name
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));//change the fonts of the letters
			g.setColor(Color.magenta);//change the color of the words
			g.drawString("Position, name and score respectively", 50, 130);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			//System.out.println(ranks);
			if(ranks.size()>5){
				for(int i=0;i<5;i++){
					topFive=(i+1)+"      "+ranks.get(i);//get top player 
					if(i==0)
						g.setColor(Color.RED);
					else
						g.setColor(Color.YELLOW);
					g.drawString(topFive, 100, y);//paint them
					y+=50;
				}
			}
			else{
				for(int i=0;i<ranks.size();i++){
					topFive=(i+1)+".      "+ranks.get(i);//get top player 
					if(i==0)
						g.setColor(Color.RED);
					else
						g.setColor(Color.YELLOW);
					g.drawString(topFive, 100, y);//paint them
					y+=50;
				}
			}
			g.setColor(Color.MAGENTA);
			g.drawString("Press M back to menu", 260, y);

			//g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 



		}
	}
	/*
	 * Description: This method is used to give order when press certain keys
	 * Parameters: KeyEvent event: the key player pressed
	 * Return: nothing
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		int e = event.getKeyCode();

		if(e==KeyEvent.VK_M)//if pressed M 
		{
			board.b=true;// do not need to enter name again
			map.setVisible(false);//delete the frame
			//board.winning=false;
			new menu();//return to main menu

		}
		contentPane.repaint();//repaint the panel

	}
	@Override
	/*
	 * Description: no use (interface)
	 * Parameters: KeyEvent event: the key player pressed
	 * Return: nothing
	 */
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	/*
	 * Description: no use(interface)
	 * Parameters: KeyEvent event: the key player pressed
	 * Return: nothing
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}


