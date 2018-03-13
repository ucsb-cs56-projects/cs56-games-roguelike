package edu.ucsb.cs56.projects.games.roguelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class GUI implements ItemListener {
    public static int difficulty = 1;
    static boolean mute = false;
    public static JPanel guiFrame;

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
        JFrame frame = new JFrame("Roguelike");
        JPanel mainMenu = new JPanel();
        JPanel instructions = new JPanel();
        JPanel options = new JPanel();
        JPanel highScore = new JPanel();

        //PLAY BUTTON
        JButton playButton = new JButton("Play"); //new button with text "Play"
        setButtonCharacteristics(playButton);
        playButton.addActionListener(new ActionListener() {
            int currDifficulty = difficulty;
            public void actionPerformed(ActionEvent e) {
                openGameWindow();
                frame.setVisible(false); //Takes away menu after game starts
            }
        });

        //QUIT BUTTON
        JButton quitButton = new JButton("Quit");
        setButtonCharacteristics(quitButton);
        quitButton.addActionListener(new ActionListener() { // make anonymous inner class to quit program when quit button is clicked
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //MUTE BUTTON
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

        //DIFFICULTY BUTTON
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

        //INSTRUCTIONS STUFF
        String content = String.format("Prepare yourself to be spooked out of existense.\n This Roguelike is like no other Roguelike.\n You are an @ symbol who has managed to find itself in the spookiest of dungeons. \nArmed with the ability to move in a desired direction, you will discover the true horrors that hide in the darkness.Muahahaha \n \nInstructions:\nUse WASD to move UP LEFT DOWN RIGHT \nUse QEZC to move UPLEFT UPRIGHT DOWNLEFT DOWNRIGHT \nUse L to shiver in fear and let a turn pass you by\n(Trust me, you\'re gonna press this button a lot muahahahha)\n \nNOTE: \n*Attack monsters by attempting to move directly on them. \n(IF THEY DON\'T KILL YOU FIRST o_O)\n \n*Monsters can steal items by moving on them. \n(OH BOY, this game is gonna make you rage!)\n\n*You will progress to next level if you can get over your fear and slay each monster in the dungeon.\n\n*Discover the darkness by exploring the dungeon on each level.\n(This isn\'t just any darkness, it\'s ADVANCED darkness!)\n\n*These monsters get more RIPPED, NASTY, and just utterly more DISGUSTING each level you progress.\n \nMonster Drops:\n-20%% [H] Health Potion(+20hp)\n-20%% [+] Beef(+Attack Power) \n-15%% [!] Poison(-20hp) \n-5%%  [S] Elixir(increases movement steps)\n");
        Font font = new Font("Times New Roman", Font.PLAIN, 12);
        JTextArea inst = new JTextArea(content, 35, 45);
        inst.setFont(font);
        inst.setForeground(Color.CYAN);
        inst.setBackground(Color.BLACK);
        inst.setEditable(false);
        inst.setLineWrap(true);
        inst.setWrapStyleWord(true);
        instructions.add(inst);

        //HIGH SCORE STUFF
        int[] array = new int[5];
        int a = 0;
        try {
            File myFile = new File("Score.txt");
            FileReader fileReader = new FileReader("Score.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                array[a] = Integer.parseInt(line);
                a++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String hScore = "High Scores: \n";
        for (int i: array) hScore += "  " + i + "\n";
        JTextArea highScores = new JTextArea(hScore, 35, 45);
        highScores.setFont(font);
        highScores.setForeground(Color.CYAN);
        highScores.setBackground(Color.BLACK);
        highScores.setEditable(false);
        highScores.setLineWrap(true);
        highScores.setWrapStyleWord(true);
        highScore.add(highScores);


        JPanel comboBoxPanel = new JPanel();
        guiFrame = new JPanel(new CardLayout());
        String comboBoxItems[] = {"Main Menu","Instructions","Options","High Scores"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.setPreferredSize(new Dimension(500,75));
        cb.setForeground(Color.CYAN);
        cb.setBackground(Color.BLACK);
        cb.setOpaque(false);
        cb.addItemListener(this);
        comboBoxPanel.add(cb);


        mainMenu.setForeground(Color.CYAN);
        mainMenu.setBackground(Color.BLACK);
        mainMenu.add(playButton);
        mainMenu.add(quitButton);

        options.setForeground(Color.CYAN);
        options.setBackground(Color.BLACK);
        options.add(muteButton);
        options.add(difficultyButton);


        highScore.setForeground(Color.CYAN);
        highScore.setBackground(Color.BLACK);

        instructions.setForeground(Color.CYAN);
        instructions.setBackground(Color.BLACK);

        guiFrame.add(mainMenu, "Main Menu");
        guiFrame.add(instructions, "Instructions");
        guiFrame.add(options, "Options");
        guiFrame.add(highScore, "High Scores");
        guiFrame.setForeground(Color.CYAN);
        guiFrame.setBackground(Color.BLACK);


        frame.setForeground(Color.CYAN);
        frame.setBackground(Color.BLACK);
        frame.add(comboBoxPanel, BorderLayout.PAGE_START);
        frame.add(guiFrame, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // makes GUI appear in screen's center
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout c1 = (CardLayout)(guiFrame.getLayout());
        c1.show(guiFrame, (String)evt.getItem());
    }

    /*
     * This function opens up the game window for the player to begin playing the game.
     */
    public void openGameWindow() {
        Sound.menuMusic.stop();
        if (!GUI.mute)
            Sound.gameMusic1.loop();
        guiFrame.setVisible(false);
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
