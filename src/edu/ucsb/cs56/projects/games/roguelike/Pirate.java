package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Rick Lee
 *@version cs56 Winter 14
 */
/**
 *This class represents a monster called a Pirate that is a medium health, medium damaged melee creature. Pirate have icon P
 */

public class Pirate extends Monster{ 
    private char icon;

    /**
     *creates a Pirate with 15 hitPoints and 5 attack with no random movement
     *with icon P
     */
    public Pirate(){
	super(15,5,0,20);    
	this.setIcon('P');
    }
    /**
     * creates a pirate with 15 HP and 5 attack with icon P
     * @param randomMovement whether or not the monster will move randomly
     */
    public Pirate(int typeOfMovement){
	super(15,5,typeOfMovement,20);
	this.setIcon('P');
    }
    
    /**
     * creates a pirate with hit points, attack, and random movement with icon P
     * @param hitPoints the Pirate's hitPoints
     * @param attack the Pirate's attack
     * @param randomMovement whether or not the Pirate will move randomly or not
     */
    public Pirate(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints, attack, typeOfMovement,20);
	this.setIcon('P');
    }
    /**
     *creates a Pirate to the parameters given to it
     * @param hp the Pirate's hitPoints
     * @param att the Pirate's attack
     * @param typeOfMove whether or not the Pirate will move randomly or not
     * @param points the amount of points the Pirate is worth
     */
    public Pirate(int hitPoints,int att,int typeOfMove, int points){
	super(hitPoints,att,typeOfMove,points); 
	this.setIcon('P');
    }
    /** 
     *This is the getter to figure out what piece icon it is. 
     */ 
    @Override public char getIcon(){
	return this.icon;
    }
    /** 
     *This is the setter for the Icon it will be 
     *@param NewIcon is the icon of piece that will be in the game 
     */ 
    @Override public void setIcon(char NewIcon){
	    this.icon=NewIcon;

    }
}
