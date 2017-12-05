package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 * @author Ishjot Walia & Josue Montenegro
 * @version cs56 Winter 16
 * This class represents a class of Item called a Elixir which increases the Player's speed, allowing them to move 2 spaces instead of 1.
 * This item is very rare.
 * Its in game icon is E
 */

public class Elixir extends Item {
    private char icon;

    /**
     *  Default constructor for Elixir
     *  Its default value is 1; with icon S
     */
    public Elixir() {
        super(1);
        this.setIcon('S');
    }

    /**
     *  This is an 1 arg constructor that will set whether the item has been used or not
     *  @param use Is the param to set the use state of the item to true or false.
     */
    public Elixir(boolean use) {
        super(use);
        this.setIcon('S');
    }

    /**
     *  This method uses the effect value in someway.
     *  in this method it adds the speed value to the player.
     */
    @Override public void UseEffect(Player p) {
        p.setSpeed(p.getSpeed() + this.getEffect());
    }



}
