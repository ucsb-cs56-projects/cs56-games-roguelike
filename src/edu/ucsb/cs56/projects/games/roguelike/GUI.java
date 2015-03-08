// package edu.ucsb.cs56.projects.games.roguelike;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

/**
 * GUI - used to make the main menu interface
 * @author Derek Wang
 */
public class GUI
{

    public static void main(String[] args)
    {
	
	new GUI(); //call class constructor to make the GUI
    }

    /**
     * This GUI class constructor makes the frame and the buttons
     */
    public GUI()
    {
	final JFrame guiFrame = new JFrame("Roguelike"); // frame window title will be Roguelike
        

	Dimension buttonDimension = new Dimension(200,100); // used to set button size
       
	JButton playButton = new JButton("Play"); //new button with text "Play"
	playButton.setPreferredSize(buttonDimension); //sets button size
	playButton.setBackground(Color.BLACK); // sets button background color
	playButton.setForeground(Color.WHITE); // sets button text color
	//	playButton.addActionListener(

	JButton instrButton = new JButton("Instructions");
	instrButton.setPreferredSize(buttonDimension);
	instrButton.setBackground(Color.BLACK);
	instrButton.setForeground(Color.WHITE);
	instrButton.addActionListener(new ActionListener(){ // make anonymous innerclass to call openInstructionsWindow, which does what it says
		public void actionPerformed(ActionEvent e)
		{
		    openInstructionsWindow();
		}
	    });

	JButton hiscoreButton = new JButton("View Highscores");
	hiscoreButton.setPreferredSize(buttonDimension);
	hiscoreButton.setBackground(Color.BLACK);
	hiscoreButton.setForeground(Color.WHITE);
	hiscoreButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    openHighScoresWindow();
		}
	    });

	JButton quitButton = new JButton("Quit");
	quitButton.setPreferredSize(buttonDimension);
	quitButton.setBackground(Color.BLACK);
	quitButton.setForeground(Color.WHITE);
	quitButton.addActionListener(new ActionListener(){ // make anonymous inner class to quit program when quit button is clicked
		public void actionPerformed(ActionEvent e)
		{
		    System.exit(0);
		}
	});

	guiFrame.add(playButton);
	guiFrame.add(instrButton);
	guiFrame.add(hiscoreButton);
	guiFrame.add(quitButton);

	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	guiFrame.getContentPane().setLayout(new GridLayout(4,1)); // grid layout with 4 vertically stacked components

	guiFrame.pack();
	guiFrame.setLocationRelativeTo(null); // makes GUI appear in screen's center
	guiFrame.setVisible(true);
    }

    /**
     * Opens a new window with game instructions displayed
     */
    public void openInstructionsWindow()
    {
	String content = String.format("The player, represented by @, begins each level by starting in the middle of the map, with all but his surrounding tiles enshrouded in darkness. The player 'discovers' the rest of the map by navigating using WASD. Monsters also move around in random patterns. Note that the game is turn-based in that monsters move once every time the player moves. The player attacks by moving directly adjacent to a monster, and then pressing the arrow key that would move the player onto the same tile as the monster if it were not there. The player can be attacked, and hp lowered, by a monster when the monster does the same thing to him. As soon as all the monsters of a level are killed, the player is automatically teleported to the next level. Reaching higher levels increases the strength of the monsters. When the player reaches 0 hp, he dies permanently.");

	Font font = new Font("Times New Roman", Font.PLAIN, 14);
	
	JTextArea instructions = new JTextArea(content, 20, 40);
	instructions.setFont(font);
	instructions.setForeground(Color.WHITE);
	instructions.setBackground(Color.BLACK);
	instructions.setEditable(false);
	instructions.setLineWrap(true);
	instructions.setWrapStyleWord(true);

	JScrollPane scrollPane = new JScrollPane(instructions);
	
	JFrame instrFrame  = new JFrame("Instructions");
	
	instrFrame.add(scrollPane);
	instrFrame.pack();
        instrFrame.setVisible(true);
	instrFrame.setLocationRelativeTo(null);
    }

    public void openHighScoresWindow()
    {




    }

}
