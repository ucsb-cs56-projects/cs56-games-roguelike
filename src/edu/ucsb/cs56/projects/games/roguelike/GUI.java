// package edu.ucsb.cs56.projects.games.roguelike;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

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
	instrButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    openInstructionsWindow();
		}
	    });

	JButton hiscoreButton = new JButton("View Highscores");
	hiscoreButton.setPreferredSize(buttonDimension);
	hiscoreButton.setBackground(Color.BLACK);
	hiscoreButton.setForeground(Color.WHITE);

	JButton quitButton = new JButton("Quit");
	quitButton.setPreferredSize(buttonDimension);
	quitButton.setBackground(Color.BLACK);
	quitButton.setForeground(Color.WHITE);
	quitButton.addActionListener(new ActionListener(){ // make anonymous inner class to close window when quit button is clicked
		public void actionPerformed(ActionEvent e)
		{
		    guiFrame.dispose();
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
	String instructions = "";



	JFrame instrFrame  = new JFrame("Instructions");
        instrFrame.setVisible(true);
	//instrFrame.setDefaultCloseOperation(instrFrame.EXIT_ON_CLOSE);
	instrFrame.setLocationRelativeTo(null);


    }
}
