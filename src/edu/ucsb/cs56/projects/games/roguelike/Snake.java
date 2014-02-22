package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Clayven Anderson
 *@author Hans Marasigan & Richard Nguyen
 *@author Rick Lee
 *@version cs56 Winter 14
 */
/**
 *This class represents a monster called a snake that is low health, medium damaged melee creature. Snakes have icon S
 */

public class Snake extends Monster{ 
    private char icon;

    /**
     *creates a snake with 5 hitPoints and 15 attack with no random movement
     *with icon S
     */
    public Snake(){
	super(5,15,0,10);    
	this.setIcon('S');
    }
    /**
     * creates a snake with 5 HP and 15 attack with icon S
     * @param randomMovement whether or not the monster will move randomly
     */
    public Snake(int typeOfMovement){
	super(5,15,typeOfMovement,10);
	this.setIcon('S');
    }
    
    /**
     * creates a snake with hit points, attack, and random movement with icon S
     * @param hitPoints the Snake's hitPoints
     * @param attack the Snake's attack
     * @param randomMovement whether or not the Snake will move randomly or not
     */
    public Snake(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints, attack, typeOfMovement,10);
	this.setIcon('S');
    }
    /**
     *creates a Snake to the parameters given to it
     * @param hp the Snake's hitPoints
     * @param att the Snake's attack
     * @param typeOfMove whether or not the Snake will move randomly or not
     * @param points the amount of points the Snake is worth
     */
    public Snake(int hitPoints,int att,int typeOfMove, int points){
	super(hitPoints,att,typeOfMove,points); 
	this.setIcon('S');
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
