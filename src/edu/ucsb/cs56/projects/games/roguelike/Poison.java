package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *  @author Hans Marasigan & Richard Nguyen
 *  @version cs56 Spring 13
 *  This class represents a class of Item called a Poison which takes away HP from the players Health Points (hit points)
 *  Its in game icon is '!'.
 */

public class Poison extends Item {
    private char icon;

    /**
     *  This is the default constructor for the Poison.
     *  Its default value is 20 with icon '!'.x
     */
    public Poison() {
        super(20);
        this.setIcon('!');
    }
    /**
     *  This is an 1 arg consrtuctor that will set how much the poison will take away.
     *  @param Health This will be the value the programmer or computer wants the poison to damage for.
     */
    public Poison(int Health) {
        super(Health);
        this.setIcon('!');
    }
    /**
     *  This is an 1 arg consrtuctor that will set whether the item has been used or not.
     *  @param use Is the param to set the use of the item to true or false.
     */
    public Poison(boolean use) {
        super(use);
        this.setIcon('!');
    }

    /**
     * This method uses the effect value to affect the player in some way.
     * In this method it just subtracts health from the player.
     */
    @Override public void UseEffect(Player p) {
        p.setHitPoints(p.getHitPoints() - this.getEffect());
    }



}
