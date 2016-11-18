package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 


 *This class represents a class of Item called Beef which increases a player's Attack points Its in game icon is +*/

public class Beef extends Item{
    private char icon;
    
    /**
       this is the default constructor for the Beef.
       its default value is 20; with icon +
    */
    public Beef(){
	super(20);
	this.setIcon('+');
    }
    /**
       this is an 1 arg consrtuctor that will set how much the beef will increase the player's attack
       @param buffs this will be the value the programmer or computer wants the beef to add to the players attack
    */
    public Beef(int buffs){
	super(buffs);
	this.setIcon('+');
    }
    /**
       this is an 1 arg consrtuctor that will set whether the item has been used or not
       @param use is the param to set the use of the item to true or false.
    */
    public Beef(boolean use){
	super(use);
	this.setIcon('+');
    }
    
        /**
       this method uses the effect value in someway.
       in this method it just adds attack points to the player
    */
    @Override public void UseEffect(Player p){
	p.setAttack(this.getEffect()+p.getAttack());	
    }



}
