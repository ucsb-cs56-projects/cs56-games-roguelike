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

    public void stop() {
        if(clip == null) return;
        clip.stop();
    }

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

    public boolean isActive() {
        return clip.isActive();
    }
}
