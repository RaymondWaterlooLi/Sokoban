import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.*;

import javax.swing.*;




public class menu extends Canvas implements ActionListener{
 
	static ArrayList<play> ranks= new ArrayList<play>();
	static String player="";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;//Jframe
	private JPanel contentPane;//JPanel
	private ImageIcon image;
	private JLabel imageLabel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new menu();
	}
	public menu(){

		Main();
	    player= JOptionPane.showInputDialog("What is your name? My dear player.");


	}

	public void Main(){


		setMinimumSize (new Dimension (150, 150));

		frame = new JFrame ("Main Menu");
		frame.setSize (605, 500);
		frame.setResizable (false);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		frame.setMinimumSize (new Dimension (300, 300));
		frame.setLocationRelativeTo (null);
		
		


		contentPane = new JPanel ();
		contentPane.setLayout (null);

		//contentPane.add(this,BorderLayout.CENTER);


		//                      JLabel label1 = new JLabel ();
		//                      label1.setText ("Sokoban");
		//                      label1.setBounds (210, 50, 150, 10);
		//
		//                      contentPane.add (label1);


		JButton button = new JButton ("Play");
		button.addActionListener (this);
		button.setActionCommand ("Play");
		button.setBounds (480, 355, 85, 21);
		contentPane.add (button);

		JButton button2 = new JButton ("Option");
		button2.addActionListener (this);
		button2.setActionCommand ("Option");
		button2.setBounds (480, 385, 85, 22);
		contentPane.add (button2);

		JButton button3 = new JButton ("Rank");
		button3.addActionListener (this);
		button3.setActionCommand ("Rank");
		button3.setBounds (480, 415, 85, 22);
		contentPane.add (button3);

		JButton button4 = new JButton ("Exit");
		button4.addActionListener (this);
		button4.setActionCommand ("Exit");
		button4.setBounds (480, 445, 85, 22);
		contentPane.add (button4);






		image = new ImageIcon("Capture.PNG");
		imageLabel = new JLabel(image); 
		imageLabel.setBounds(0, 80, 620, 267);
		imageLabel.setVisible(true);
		contentPane.add (imageLabel);

		ImageIcon sokoban = new ImageIcon("sokoban.png");
		JLabel sokobanLabel = new JLabel(sokoban); 
		sokobanLabel.setBounds(0, 160, 500, 500);
		sokobanLabel.setVisible(true);
		contentPane.add (sokobanLabel);

		image = new ImageIcon ("title.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(0,0,600,80);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);


		frame.setContentPane (contentPane);
		frame.setVisible (true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String name = e.getActionCommand ();

		if (name.equals ("Play"))
		{ //to sub menu #1
			frame.setVisible(false);
			new board();
			//setVisible(false);
		}
		else if (name.equals ("Option"))
		{ //exit the program
			System.out.println ("Option");
			options();
		}
		else if (name.equals ("Rank"))
		{ //exit the program
			System.out.println ("Rank");
			rank();
		}
		else if (name.equals ("Exit"))
		{ //exit the program
			System.out.println ("Bye Bye");
			System.exit (0);
		}
		else if (name.equals ("Main")){
			frame.setVisible (false);
			Main();
		}
		else if(name.equals("level1")){
			board.Level=1;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level2")){
			board.Level=2;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level3")){
			board.Level=3;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level4")){
			board.Level=4;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level5")){
			board.Level=5;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level6")){
			board.Level=6;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level7")){
			board.Level=7;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level8")){
			board.Level=8;
			frame.setVisible(false);
			new board();
		}
		else if(name.equals("level9")){
			board.Level=9;
			frame.setVisible(false);
			new board();
		}
		
		
	}

	public void play(){
		String name="";
		boolean ok =true;
		System.out.println("playPlay");
		frame.setVisible(false);

		frame = new JFrame ("Sokoban");
		frame.setSize (615, 500);
		frame.setResizable (true);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel ();
		contentPane.setLayout (null);

		frame.setMinimumSize (new Dimension (300, 300));
		frame.setLocationRelativeTo (null);
		
		frame.setContentPane (contentPane);
		frame.setVisible(true);
		do
		{
			ok = true;
			try
			{
				name =  (JOptionPane.showInputDialog ("please enter name"));
				
			}
			catch (Exception e)
			{
				System.out.println ("Invalid Input");
				ok = false;
			}
		}
		while (!ok);
		
		
		
		


		frame.setContentPane (contentPane);
		frame.setVisible(true);
	}

	public void options(){
		
	//	System.out.println("Levels");
		frame.setVisible(false);
		frame = new JFrame ("Option");
		frame.setSize (615, 500);
		frame.setResizable (true);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


		frame.setMinimumSize (new Dimension (300, 300));
		frame.setLocationRelativeTo (null);
		contentPane = new JPanel ();
		contentPane.setLayout (null);

		
		
		
		JButton exit = new JButton ("Main Menu");
		exit.addActionListener (this);
		exit.setActionCommand ("Main");
		exit.setBounds (450, 400, 125, 26);
		contentPane.add (exit);

		JButton level1 = new JButton ("1");
		level1.addActionListener (this);
		level1.setActionCommand ("level1");
		level1.setBounds (40, 75, 41, 26);
		contentPane.add (level1);

		JButton level2 = new JButton ("2");
		level2.addActionListener (this);
		level2.setActionCommand ("level2");
		level2.setBounds (100, 75, 41, 26);
		contentPane.add (level2);

		JButton level3 = new JButton ("3");
		level3.addActionListener (this);
		level3.setActionCommand ("level3");
		level3.setBounds (160, 75, 41, 26);
		contentPane.add (level3);

		JButton level4 = new JButton ("4");
		level4.addActionListener (this);
		level4.setActionCommand ("level4");
		level4.setBounds (220, 75, 41, 26);
		contentPane.add (level4);

		JButton level5 = new JButton ("5");
		level5.addActionListener (this);
		level5.setActionCommand ("level5");
		level5.setBounds (280, 75, 41, 26);
		contentPane.add (level5);

		JButton level6 = new JButton ("6");
		level6.addActionListener (this);
		level6.setActionCommand ("level6");
		level6.setBounds (340, 75, 41, 26);
		contentPane.add (level6);

		JButton level7 = new JButton ("7");
		level7.addActionListener (this);
		level7.setActionCommand ("level7");
		level7.setBounds (400, 75, 41, 26);
		contentPane.add (level7);

		JButton level8 = new JButton ("8");
		level8.addActionListener (this);
		level8.setActionCommand ("level8");
		level8.setBounds (460, 75, 41, 26);
		contentPane.add (level8);

		JButton level9 = new JButton ("9");
		level9.addActionListener (this);
		level9.setActionCommand ("level9");
		level9.setBounds (520, 75, 41, 26);
		contentPane.add (level9);

		
		
		image = new ImageIcon ("1.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(8,150,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("2.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(4,180,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("3.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(5,210,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("4.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(3,240,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("5.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(3,270,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("6.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(3,300,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("7.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(0,330,630,38);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		image = new ImageIcon ("please choose a level.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(13,100,569,50);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);

		image = new ImageIcon ("options.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(150,5,301,68);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);

		image = new ImageIcon ("UV9qmUi.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(0,0,615,500);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);

		image = new ImageIcon ("please choose a level.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(0,0,600,100);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		


		frame.setContentPane (contentPane);
		frame.setVisible(true);
		
	    

	}

	public void rank(){
		
		frame.setVisible(false);
		frame = new JFrame ("Ranks");
		frame.setSize (615, 500);
		frame.setResizable (true);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


		frame.setMinimumSize (new Dimension (300, 300));
		frame.setLocationRelativeTo (null);
		contentPane = new JPanel ();
		contentPane.setLayout (null);
		
		JButton exit = new JButton ("Main Menu");
		exit.addActionListener (this);
		exit.setActionCommand ("Main");
		exit.setBounds (450, 400, 125, 26);
		contentPane.add (exit);
		
		image = new ImageIcon ("CaptureSSS.png");
		imageLabel = new JLabel (image);
		imageLabel.setBounds(0,0,615,500);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
		
		
		try{
			BufferedReader in = new BufferedReader (new FileReader("1.txt"));
			String s="";
			while(s!=null){
				s=in.readLine();				
					player=s.substring(0, s.indexOf(" "));
					int a=Integer.parseInt(s.substring(s.indexOf(" ")+1));
					ranks.add(new play(player,a));
				
			}
		}catch(FileNotFoundException e){}
		catch(IOException e){}
		catch(NullPointerException e){}
		
		
		Collections.sort(ranks);
		System.out.println(ranks);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setContentPane (contentPane);
		frame.setVisible(true);

	}
}
