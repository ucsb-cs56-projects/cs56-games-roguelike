package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan and Richard Nguyen
 *@version cs56 Spring 13
 *
 *
 *
 *This class represents a class of Item called Beef which increases a player's Attack points. Its icon in the game is a '+' character*/

public class Beef extends Item {
    private char icon;

    /**
     *  This is the default constructor for the Beef.
     *  Its default value is 20;
     *  Its default icon is '+'
    */
    public Beef() {
        super(20);
        this.setIcon('+');
    }
    /**
     *  This is an 1 arg constructor that will set how much the beef will increase the player's attack damage.
     *  @param buffs This will be the value the programmer or computer wants the beef to add to the players attack damage.
    */
    public Beef(int buffs) {
        super(buffs);
        this.setIcon('+');
    }
    /**
     *   This is an 1 arg constructor that will set whether the item has been used or not.
     *  @param use Parameter to set the use of the item to true or false.
    */
    public Beef(boolean use) {
        super(use);
        this.setIcon('+');
    }

    /**
       This method uses the effect value to affect the player in someway.
       In this method it adds attack points to the player.
    */
    @Override public void UseEffect(Player p) {
        p.setAttack(this.getEffect() + p.getAttack());
    }



}
