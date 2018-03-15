package edu.ucsb.cs56.projects.games.roguelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LosingScreen {
    public LosingScreen(int score) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        String hScore = "YOU LOSE\nSCORE: " + score + "\nHigh Scores: \n";
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
        for (int i : array) hScore += "  " + i + "\n";
        JTextArea highScores = new JTextArea(hScore, 10, 40);
        highScores.setForeground(Color.CYAN);
        highScores.setBackground(Color.BLACK);
        highScores.setFont(highScores.getFont().deriveFont(18f));
        highScores.setEditable(false);
        highScores.setLineWrap(true);
        highScores.setWrapStyleWord(true);
        panel.add(highScores,BorderLayout.NORTH);

        JButton playAgainButton = new JButton("Play Again?");
        setButtonCharacteristics(playAgainButton);
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sound.menuMusic.stop();
                if (!GUI.mute)
                    Sound.gameMusic1.loop();
                String diffStr = "" + GUI.difficulty;
                String[] args = {diffStr};
                RogueController.main(args);
                frame.setVisible(false);
            }
        });
        JButton mainMenuButton = new JButton("Back to Main Menu");
        setButtonCharacteristics(mainMenuButton);
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sound.gameMusic1.stop();
                Sound.gameMusic2.stop();
                Sound.gameMusic3.stop();
                new GUI();
                if (!GUI.mute)
                    Sound.menuMusic.loop();
                frame.setVisible(false);
            }
        });
        panel.add(playAgainButton,BorderLayout.EAST);
        panel.add(mainMenuButton,BorderLayout.WEST);
        playAgainButton.setVisible(true);
        mainMenuButton.setVisible(true);
        highScores.setVisible(true);
        panel.revalidate();
        panel.repaint();
        panel.setVisible(true);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(Color.CYAN);
        frame.setBackground(Color.BLACK);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setButtonCharacteristics(JButton b) {
        Dimension buttonDimension = new Dimension(300, 125); // used to set button size
        b.setPreferredSize(buttonDimension); //sets button size
        b.setBackground(Color.BLACK); // sets button background color
        b.setForeground(Color.WHITE); // sets button text color
    }
}
