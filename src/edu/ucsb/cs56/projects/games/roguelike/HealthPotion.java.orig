package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan and Richard Nguyen
 *@version cs56 Spring 13
 


 *This class represents a class of Item called a HealthPotion which adds HP to the players Health Points (hit points)
 */

public class HealthPotion extends Item{
    private char icon;
    
    /**
       this is the default constructor for the health potion.
       its default value is 20; with icon H
    */
    public HealthPotion(){
	super(20);
	this.setIcon('H');
    }
    /**
       this is an 1 arg consrtuctor that will set how much the potion will heal
       @param Health this will be the value the programmer or computer wants the potion to heal for.
    */
    public HealthPotion(int Health){
	super(Health);
	this.setIcon('H');
    }
    /**
       this is an 1 arg consrtuctor that will set whether the item has been used or not
       @param use is the param to set the use of the item to true or false.
    */
    public HealthPotion(boolean use){
	super(use);
	this.setIcon('H');
    }
    
    
    @Override public void UseEffect(Player p){
	p.setHitPoints(this.getEffect()+p.getHitPoints());	
    }



}
