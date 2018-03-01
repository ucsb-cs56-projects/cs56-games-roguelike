package edu.ucsb.cs56.projects.games.roguelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * GUI - Class used to create the menu interface. This class creates the frame and buttons and adds the actionListener events for different menu options. The Main Menu includes buttons for:
 * >Play
 * >Instructions
 * >Options
 * >View Highscores
 * >Quit
 *
 * @author Derek Wang
 */


//change to cardlayout?
public class GUI {
    public static int difficulty = 1;

    /*
     * All the main does is call the no-arg constructor of the GUI class
     */
    public static void main(String[] args) {
        if (!GUI.mute && !Sound.menuMusic.isActive())
            Sound.menuMusic.loop();
        new GUI(); //call class constructor to make the GUI
    }

    /**
     * This GUI class constructor makes the frame and the buttons for the menu screen.
     */
    public GUI() {
        final JFrame guiFrame = new JFrame("Roguelike"); // frame window title will be Roguelike

        JButton playButton = new JButton("Play"); //new button with text "Play"
        setButtonCharacteristics(playButton);
        playButton.addActionListener(new ActionListener() {
            int currDifficulty = difficulty;

            public void actionPerformed(ActionEvent e) {
                openGameWindow();
                guiFrame.setVisible(false); //Takes away menu after game starts
            }
        });

        JButton instrButton = new JButton("Instructions");
        setButtonCharacteristics(instrButton);
        instrButton.addActionListener(new ActionListener() { // make anonymous innerclass to call openInstructionsWindow, which does what it says
            public void actionPerformed(ActionEvent e) {
                //Close Main Menu until close button is clicked
                guiFrame.setVisible(false);
                openInstructionsWindow();
            }
        });

        JButton optionButton = new JButton("Options");
        setButtonCharacteristics(optionButton);
        optionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Close Main Menu until close button is clicked
                guiFrame.setVisible(false);
                openOptionsWindow();
            }
        });


        JButton hiscoreButton = new JButton("View Highscores");
        setButtonCharacteristics(hiscoreButton);
        hiscoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Close Main Menu until close button is clicked
                guiFrame.setVisible(false);
                openHighScoresWindow();
            }
        });

        JButton quitButton = new JButton("Quit");
        setButtonCharacteristics(quitButton);
        quitButton.addActionListener(new ActionListener() { // make anonymous inner class to quit program when quit button is clicked
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        guiFrame.add(playButton);
        guiFrame.add(instrButton);
        guiFrame.add(optionButton);
        guiFrame.add(hiscoreButton);
        guiFrame.add(quitButton);


        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.getContentPane().setLayout(new GridLayout(5, 1)); // grid layout with 5 vertically stacked components
        guiFrame.pack();
        guiFrame.setLocationRelativeTo(null); // makes GUI appear in screen's center
        guiFrame.setVisible(true);
    }

    /**
     * Opens a new window with game instructions displayed.
     */
    public void openInstructionsWindow() {
        String content = String.format("Prepare yourself to be spooked out of existense.\n This Roguelike is like no other Roguelike.\n You are an @ symbol who has managed to find itself in the spookiest of dungeons. \nArmed with the ability to move in a desired direction, you will discover the true horrors that hide in the darkness.Muahahaha \n \nInstructions:\nUse WASD to move UP LEFT DOWN RIGHT \nUse QEZC to move UPLEFT UPRIGHT DOWNLEFT DOWNRIGHT \nUse L to shiver in fear and let a turn pass you by\n(Trust me, you\'re gonna press this button a lot muahahahha)\n \nNOTE: \n*Attack monsters by attempting to move directly on them. \n(IF THEY DON\'T KILL YOU FIRST o_O)\n \n*Monsters can steal items by moving on them. \n(OH BOY, this game is gonna make you rage!)\n\n*You will progress to next level if you can get over your fear and slay each monster in the dungeon.\n\n*Discover the darkness by exploring the dungeon on each level.\n(This isn\'t just any darkness, it\'s ADVANCED darkness!)\n\n*These monsters get more RIPPED, NASTY, and just utterly more DISGUSTING each level you progress.\n \nMonster Drops:\n-20%% [H] Health Potion(+20hp)\n-20%% [+] Beef(+Attack Power) \n-15%% [!] Poison(-20hp) \n-5%%  [S] Elixir(increases movement steps)\n");

        Font font = new Font("Times New Roman", Font.PLAIN, 12);

        JTextArea instructions = new JTextArea(content, 20, 40);
        instructions.setFont(font);
        instructions.setForeground(Color.CYAN);
        instructions.setBackground(Color.BLACK);
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(instructions);

        JFrame instrFrame = new JFrame("Instructions");

        instrFrame.add(scrollPane);
        instrFrame.pack();
        instrFrame.setVisible(true);
        instrFrame.setLocationRelativeTo(null);
        RogueController.MakeCloseOptionToMainMenu(instrFrame);
    }

    static boolean mute = false;

    public void openOptionsWindow() {


        JTextArea optionsText = new JTextArea("Options Menu", 20, 40);

        Font font = new Font("Times New Roman", Font.PLAIN, 12);
        optionsText.setFont(font);
        optionsText.setForeground(Color.CYAN);
        optionsText.setBackground(Color.BLACK);
        optionsText.setEditable(false);
        optionsText.setLineWrap(true);
        optionsText.setWrapStyleWord(true);

        JButton muteButton = new JButton("Mute: " + mute);
        setButtonCharacteristics(muteButton);
        muteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mute = !mute;
                muteButton.setText("Mute: " + mute);
                if (!mute)
                    Sound.menuMusic.loop();
                else
                    Sound.menuMusic.stop();
            }
        });

        //increasing the difficultyLevel increases the max number of monsters you start with
        JButton difficultyButton = new JButton("Difficulty: " + GUI.difficulty);
        setButtonCharacteristics(difficultyButton);
        difficultyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GUI.difficulty += 1;
                if (GUI.difficulty > 3) {
                    GUI.difficulty = 1;
                }
                difficultyButton.setText("Difficulty: " + GUI.difficulty);

                //System.out.println("Difficulty AFTER pressing is: " + getDifficulty());
            }
        });


        JFrame optionsFrame = new JFrame("Options");
        optionsFrame.add(optionsText);
        optionsFrame.add(muteButton);
        optionsFrame.add(difficultyButton);
        optionsFrame.pack();
        optionsFrame.setVisible(true);
        optionsFrame.getContentPane().setLayout(new GridLayout(3, 1));
        optionsFrame.setLocationRelativeTo(null);
        RogueController.MakeCloseOptionToMainMenu(optionsFrame);
    }


    /*
     * This function calls a static method in the RogueController class that opens the losing screen (which contains high scores)
     */
    public static boolean highScoreWindow = false;

    public void openHighScoresWindow() {
        highScoreWindow = true;
        RogueController.goToLosingScreen();
        highScoreWindow = false;
        //JFrame highScoreFrame = new JFrame("High Scores");
        // display the HighScore after game is over by reading from Score.txt...

}

    /*
     * This function opens up the game window for the player to begin playing the game.
     */
    public void openGameWindow() {
        Sound.menuMusic.stop();
        if (!GUI.mute)
            Sound.gameMusic1.loop();

        String diffStr = "" + GUI.difficulty;
        String[] args = {diffStr};
        RogueController.main(args);
    }

    /**
     * This function sets the size and color for the menu buttons
     */
    public void setButtonCharacteristics(JButton b) {
        Dimension buttonDimension = new Dimension(250, 125); // used to set button size
        b.setPreferredSize(buttonDimension); //sets button size
        b.setBackground(Color.BLACK); // sets button background color
        b.setForeground(Color.WHITE); // sets button text color
    }

}
