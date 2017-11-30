package edu.ucsb.cs56.projects.games.roguelike;

import javax.sound.sampled.*;
import java.io.File;

/**
 * This class stores music and methods to loop
 * or stop those songs
 * @author Max de Visser and Artem Jivotovski
 * @version cs56 F16
*/

public class Sound {

    private Clip clip;

    public static Sound gameMusic = new Sound("./src/edu/ucsb/cs56/projects/games/roguelike/music/gameMusic.wav");
    public static Sound menuMusic = new Sound("./src/edu/ucsb/cs56/projects/games/roguelike/music/menuMusic.wav");
    /**
     * Constructs a Sound object from the name of a music/sound file. This Constructor opens the sound file and extracts the sound data.
     */
    public Sound (String fileName) {
        try {
            File file = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Stops playing a given Sound in the program.
     */
    public void stop() {
        if(clip == null) return;
        clip.stop();
    }
    /**
     * Continues to play a Sound in the program continously and repeats on a loop.
     */
    public void loop() {
        try {
            if (clip != null) {
                new Thread() {
                    public void run() {
                        synchronized (clip) {
                            clip.stop();
                            clip.setFramePosition(0);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        }
                    }
                } .start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Checks if there is a Sound clip playing.
     * @return boolean value of true if sound is active, false otherwise.
     */
    public boolean isActive() {
        return clip.isActive();
    }
}
