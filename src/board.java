

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;

public class board extends Thread implements  KeyListener{
	private static final long serialVersionUID = 1L;
	JFrame map;
	JPanel contentPane;
	Winscreen contentWin;

	player h;//player controlled
	box item;//box the player get pushed
	int upper=80;//the y position used to determine all objects' y-positions
	int side=40;//the x position used to determine all objects' x-positions
	int velX=0;// the x direction movement of the player
	int velY=0;// the y direction movement of the player
	int x= 0;
	int y=0;
	int number=0;
	static boolean winning=false;//used to determine whether win
	boolean losing =false;//used to determine whether lose
	int steps =0; //the initail step
	int limit=350;//step limitation
	static int score;// the remaining step
	static int Level=1;//initial level
	static boolean b= false;//whether need name
	
	
	
	

	ArrayList <wall>walls= new ArrayList<wall>();//the list contains all the walls
	ArrayList <box>boxes= new ArrayList<box>();//the list contains all the boxes
	ArrayList <area>areas= new ArrayList<area>();//the list contains all the areas
	ArrayList <box>woods = new ArrayList<box>();//the list contains all the boxes reached certain areas


	public board(){
		
		
		
		h= new player(0,0);
		map =new JFrame();
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(500,500);
		map.setTitle("Pushing boxes!");
		map.setLocationRelativeTo (null);

		//map.setLocationRelativeTo(null);



		contentPane = new JPanel ();
		contentPane.setLayout (new BoxLayout (contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setFocusable(true);
		contentPane.add (new MyCanvas ());
		contentPane.addKeyListener(this);


		map.setContentPane(contentPane);
		map.setVisible(true);

	}

	/*
	 * Description: This method is used to give order when press certain keys
	 * Parameters: KeyEvent event: the key player pressed
	 * Return: nothing
	 */
	public void keyPressed(KeyEvent event) {
		int e = event.getKeyCode();
		
		if(e==KeyEvent.VK_B)
		{
			new board();//restart the game
		}
		if(e==KeyEvent.VK_M){
			b=true;
			map.setVisible(false);
			Level=1;//back to level 1
			new menu();//return  to the main menu
		}
		if(e==KeyEvent.VK_SHIFT){
			if(Level!=level.times.length&&winning)//if the player passes this level or it is not the last level then he/she can goes to next level
			Level++;// go to next level
			map.setVisible(false);
			new board();
		}
		if(e==KeyEvent.VK_SPACE){
			if(Level!=1)//if it is not the first level
			Level--;//back to previous one
			map.setVisible(false);
			new board();
		}
		if (e == KeyEvent.VK_LEFT)
		{
			if(collision(1)){//if collisioned the 
				return;
			}else{				
				if(check(1)==1||check(1)==2){// check whether if the player meets the wall or two boxes together
					return;
				}else{				
					velX+=-20;//move left then
				}				
			}
			steps++;//steps add up
		
			if(win()){//check whether the player wins
				winning=true;
				score=limit-steps;//get the score
				if(Level==9){//chekc whether it is the last level (only last one has the rank)
					rank1.ranks.add(new play(rank1.player,score));
				
				try{
					PrintWriter out = new PrintWriter(new FileWriter("1.txt",true));//write the score to the file
					out.println(rank1.player+" "+score);
					out.close();
				}catch(IOException v){}
				}
			}
			if(lose()){
				losing=true;
			}
			for(int i=0;i<areas.size();i++){
				area b = areas.get(i);
				if(h.getX()-20==b.getX()&&h.getY()==b.getY()){//check if the boxes are in the certain areas
					b.emptyImage();//clear the original image of the boxes
				}
			}


		}
		else if (e == KeyEvent.VK_RIGHT)
		{
			if(collision(2)){//player move right
				return;
			}else{

				if(check(2)==1||check(2)==2){
					return;
				}
				else{
					velX+=20;//move right then
				}		
			}
			steps++;
		
			if(win()){
				winning=true;
				score=limit-steps;
				if(Level==9){
					rank1.ranks.add(new play(rank1.player,score));
				
				try{
					PrintWriter out = new PrintWriter(new FileWriter("1.txt",true));
					out.println(rank1.player+" "+score);
					out.close();
				}catch(IOException v){}
				}
			}
			if(lose()){
				losing=true;
			}
			for(int i=0;i<areas.size();i++){
				area b = areas.get(i);
				if(h.getX()+20==b.getX()&&h.getY()==b.getY()){
					b.emptyImage();
				}
			}

		}
		else if (e == KeyEvent.VK_UP)// check the player moving up
		{

			if(collision(3)){
				return;
			}else{

				if(check(3)==1||check(3)==2){
					return;
				}else{
					velY+=-20;
				}

			}
			steps++;
			if(win()){
				winning=true;
				score=limit-steps;
				if(Level==9){
					rank1.ranks.add(new play(rank1.player,score));
				
				try{
					PrintWriter out = new PrintWriter(new FileWriter("1.txt",true));
					out.println(rank1.player+" "+score);
					out.close();
				}catch(IOException v){}
				}
			}
			if(lose()){
				losing=true;
			}
			for(int i=0;i<areas.size();i++){
				area b = areas.get(i);
				if(h.getX()==b.getX()&&h.getY()-20==b.getY()){
					b.emptyImage();
				}
			}

		}
		else if (e== KeyEvent.VK_DOWN)//check the player moving down
		{
			if(collision(4)){
				return;
			}else{
				if(check(4)==1||check(4)==2){
					return;
				}
				else{
					velY+=20;
				}
			}
			steps++;
			if(win()){
				winning=true;
				score=limit-steps;
				if(Level==9){
					rank1.ranks.add(new play(rank1.player,score));
					//System.out.println(rank1.ranks);
				
				try{
					PrintWriter out = new PrintWriter(new FileWriter("1.txt", true));
					out.println(rank1.player+" "+score);
					out.close();
				}catch(IOException v){}
				}
			}
			if(lose()){
				losing=true;
			}
			for(int i=0;i<areas.size();i++){
				area b = areas.get(i);
				if(h.getX()==b.getX()&&h.getY()+20==b.getY()){
					b.emptyImage();
				}
			}

		}
		contentPane.repaint();
	}
	/*
	 * Description: no use (interface)
	 * Parameters: KeyEvent event: the key player pressed
	 * Return: nothing
	 */
	public void keyReleased(KeyEvent e) {

	}


	/*
	 * Description: no use (interface)
	 * Parameters: KeyEvent event: the key player pressed
	 * Return: nothing
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	

	/*
	 * Description: it is used to check whether player has collisioned the wall
	 * Parameters: int a: represents four directions
	 * 1 means left
	 * 2 means right
	 * 3 means up
	 * 4 means down
	 * Return: nothing
	 */
	public boolean collision(int a){
		for(int i= 0; i<walls.size();i++){
			wall k= walls.get(i);
			if(a==1){			
				if(h.getX()-20==k.getX()&&h.getY()==k.getY())
					return true;					
			}
			if(a==2){
				if(h.getX()+20==k.getX()&&h.getY()==k.getY())
					return true;		
			}
			if(a==3){
				if(h.getX()==k.getX()&&h.getY()-20==k.getY())
					return true;					
			}
			if(a==4){
				if(h.getX()==k.getX()&&h.getY()+20==k.getY())
					return true;
			}
		}
		return false;
	}



	/*
	 * Description: This method is used to check whether the player meets the wall or the box pushed by the player meet the wall
	 * Parameters: int a: describe different situations:
	 * 1 means left
	 * 2 means right
	 * 3 means up
	 * 4 means down
	 * Return: 1 means box pushed by the player collisions the wall
	 * 2 means box pushed by the player meets another box
	 * 3 the player only meet one box rather than 2
	 * 0 the player does not meet neither wall or box
	 */
	public int check (int a){
		for(int i= 0; i<boxes.size();i++){	//check whether each box touches the wall
			box k= boxes.get(i);
			if(a==1){
				int l= 0;
				if(h.getX()-20==k.getX()&&h.getY()==k.getY()){//if the player moving left then meets the box
					item=boxes.get(i);
					box j = new box(item.getX()-20,item.getY());
					for(int p=0; p<walls.size();p++){
						wall o = walls.get(p);
						if(j.getX()==o.getX()&&j.getY()==o.getY()){// if the box pushed by the player collisions the wall
							return 1;
						}
					}
					for(int q=0;q<boxes.size();q++){
						box w = boxes.get(q);
						if(w.getX()==j.getX()&&w.getY()==j.getY()){//check if the box meets another box
							l++;					//the box will meet itself too
						}
					}
					if(l>=1){
						return 2;//if it meets another box
					}
					boxes.set(i, j);//change the position of the box being pushed
					return 3;//the player meets only one box
				}
			}
			else if(a==2){
				int l= 0;
				if(h.getX()+20==k.getX()&&h.getY()==k.getY()){//if the player moving right then meets the box
					item=boxes.get(i);
					box j = new box(item.getX()+20,item.getY());
					for(int p=0; p<walls.size();p++){
						wall o = walls.get(p);
						if(j.getX()==o.getX()&&j.getY()==o.getY()){// if the box pushed by the player collisions the wall
							return 1;
						}
					}
					for(int q=0;q<boxes.size();q++){
						box w = boxes.get(q);
						if(w.getX()==j.getX()&&w.getY()==j.getY()){//check if the box meets another box
							l++;//the box will meet itself too
						}
					}
					if(l>=1){
						return 2;//if it meets another box
					}

					boxes.set(i, j);
					return 3;
				}
			}
			else if(a==3){
				int l= 0;
				if(h.getX()==k.getX()&&h.getY()-20==k.getY()){//if the player moving up then the boxes meet the wall
					item=boxes.get(i);
					box j = new box(item.getX(),item.getY()-20);
					for(int p=0; p<walls.size();p++){
						wall o = walls.get(p);
						if(j.getX()==o.getX()&&j.getY()==o.getY()){
							return 1;
						}
					}
					for(int q=0;q<boxes.size();q++){
						box w = boxes.get(q);
						if(w.getX()==j.getX()&&w.getY()==j.getY()){
							l++;
						}
					}
					if(l>=1){
						return 2;
					}

					boxes.set(i, j);
					return 3;
				}
			}
			else if(a==4){
				int l= 0;
				if(h.getX()==k.getX()&&h.getY()+20==k.getY()){//if the player moving down then the boxes meet the wall
					item=boxes.get(i);
					box j = new box(item.getX(),item.getY()+20);
					for(int p=0; p<walls.size();p++){
						wall o = walls.get(p);
						if(j.getX()==o.getX()&&j.getY()==o.getY()){
							return 1;
						}
					}
					for(int q=0;q<boxes.size();q++){
						box w = boxes.get(q);
						if(w.getX()==j.getX()&&w.getY()==j.getY()){
							l++;
						}
					}
					if(l>=1){
						return 2;
					}

					boxes.set(i, j);
					return 3;
				}
			}
		}
		return 0;//the player neither meets the box or the wall
	}

	public static void getFrom(){
		try{
		BufferedReader in = new BufferedReader (new FileReader("1.txt"));
		String s="";
		while(s!=null){
			s=in.readLine();				
			rank1.player=s.substring(0, s.indexOf(" "));
			int a=Integer.parseInt(s.substring(s.indexOf(" ")+1));
			rank1.ranks.add(new play(rank1.player,a));

		}
	}catch(FileNotFoundException h){}
	catch(IOException h){}
	catch(NullPointerException he){}
	}



	class MyCanvas extends JComponent{
		private static final long serialVersionUID = 1L;

		/*
		 * Description: This method is used to paint all the images and texts
		 * Parameters: graphics g: used to paint
		 * Return: nothing
		 */
		public void paint(Graphics g) {
			if(!winning&&!losing){
				//System.out.println("IN PAINT");
				super.paint(g);
				Image background;
				URL loc = this.getClass().getResource("sky.jpg");
				ImageIcon o = new ImageIcon(loc);
				background = o.getImage();
				g.drawImage(background,0, 0, this.getWidth(), this.getHeight(),null);
				level.addLevel();
				String chosen= level.getLevel(Level);
				limit= level.getTime(Level);
				//	g.drawRect (50, 50, 100, 100);
				//System.out.println(chosen);

				for(int i=0;i<chosen.length();i++){
					char c = chosen.charAt(i);
					//System.out.println(c);
					if(c==' '){
						side+=20;//add up to the x-position 
					}
					else if(c=='#'){
						side+=20;
						if(number==0)//if it is the first time print out
							walls.add(new wall(side,upper));//add to the wall list
					}
					else if(c=='$'){
						side+=20;
						if(number==0)
							boxes.add(new box(side, upper));


					}
					else if(c=='\n'){
						side=0;
						upper+=20;
					}
					else if (c=='.'){
						side+=20;
						if(number==0)
							areas.add(new area(side, upper));//add to the areas list
					}
					else if(c=='a'){
						side+=20;
						h= new player(side+velX,upper+velY);//change the position of the player
						g.drawRect (h.getX(), h.getY(), 20, 20);
						g.drawImage(h.getP(), h.getX(),h.getY(),20,20, null);//draw the player

					}

				}
				number++;// the number of paint times add
				side=40;//reset the initial x position
				upper=80;//reset the initial y position
				//			System.out.println("here");
				for(int i=0;i<walls.size();i++){
					//System.out.println("HERE");
					wall a= walls.get(i);
					//				System.out.println("X: "+a.getX());
					//				System.out.println("Y: "+a.getY());
					g.drawRect (a.getX(), a.getY(), 20, 20);
					//g.drawRect(30, 30, 100, 100);
					g.drawImage(a.getP(), a.getX(),a.getY(), 20, 20,null);
				}
				/*
				 * This section is used to draw the boxes
				 */
				for(int i=0;i<boxes.size();i++){
					box a= boxes.get(i);
					g.drawRect (a.getX(), a.getY(), 20, 20);
					g.drawImage(a.getP(), a.getX(),a.getY(),20,20, null);
				}
				/*
				 * This section is used to draw the areas
				 */
				for(int i=0; i<areas.size();i++){
					area a = areas.get(i);
					g.drawRect (a.getX(), a.getY(), 20, 20);
					g.drawImage(null, a.getX(),a.getY(),20,20, null);
				}
				//System.out.println(m.getTime());
				g.drawString ("Steps: " + steps, 300, 400);
				g.drawString ("Remaining steps: " + (limit-steps), 300, 420);//show the remaining steps 
			}
			else if(losing){//change the screen if you lose
				Image background;
				URL loc = this.getClass().getResource("over.jpg");
				ImageIcon o = new ImageIcon(loc);
				background = o.getImage();
				g.drawImage(background,0, 0, this.getWidth(), this.getHeight(),null);
			}
			else if(winning){//change the screen if you win
                
				Image background;
				URL loc = this.getClass().getResource("win.jpg");
				ImageIcon o = new ImageIcon(loc);
				background = o.getImage();
				g.drawImage(background,0, 0, this.getWidth(), this.getHeight(),null);
			}


		


		}
	}
	

	/*
	 * Description: This method is used to check whether the player wins this level
	 * Parameters: nothing
	 * Return: return true: if player wins
	 * return false: if player does not win
	 */

	public boolean win(){
		int num=0;//number of the boxes are in the areas
		for(int i=0;i<boxes.size();i++){
			box a =boxes.get(i);
			for(int j=0;j<areas.size();j++){
				area b = areas.get(j);
				if(a.getX()==b.getX()&&a.getY()==b.getY()){//check whether all the boxes have been in the certain areas
					//System.out.println(j);
					//System.out.println("area: "+j);
					b.emptyImage();//clear the original image of boxes
				    a.setImage();//change to the colorful one
					num++;
				}
				else{
					//	   b.setImage(); 					
				}
			}
		}
		
		if(num==areas.size()){//whether their number are same 
			num=0;
			return true;
		}
		return false;
	}
	
	/*
	 * Description: This method is used to check whether the player loses this level
	 * Parameters: nothing
	 * Return: return true: if player loses
	 * return false: if player does not lose
	 */
	public boolean lose(){
		if(steps>limit)
			return true;
		return false;
	}
	
	
public static void main(String[] args) {
    new board();
}











}
