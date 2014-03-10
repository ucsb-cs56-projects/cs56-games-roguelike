package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Clayven Anderson
 *@author Hans Marasigan & Richard Nguyen
 *@author Rick Lee
 *@version cs56 Winter 14
 */

/**
 *This class represents a class of monster called a Bat which is a weak melee monster. Bat icon is B
 */

public class Bat extends Monster{ 
    private char icon;
    /**
     *creates a Bat with 5 hitPoints and 1 attack with no random movement
     *with icon B
     */
    public Bat(){
	super(5,1,0,10);
	this.setIcon('B');
	
    }
    /**
     * creates a Bat with 5 HP and 1 attack with icon B
     * @ param randomMovement whether or not the bat will move randomly
     */
    public Bat(int typeOfMovement){
	super(5,1,typeOfMovement,10);
	this.setIcon('B');
    }
    
    /**
     * creates a Bat with hit points, attack, and random movement with icon B
     * @param hitPoints the Bat's hitPoints
     * @param attack the Bat's attack
     * @param typeOfMovement whether or not the Bat will move randomly or not
     */
    public Bat(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints,attack,typeOfMovement,10);
	this.setIcon('B');
    }
    /**
     *creates a Bat to the parameters given to it, with icon B
     * @param hp the Bat's hitPoints
     * @param att the Bat's attack
     * @param typeOfMove whether or not the Bat will move randomly or not
     * @param points the amount of points the Bat is worth
     */
    public Bat(int hp,int att,int typeOfMove, int points){
	super(hp,att,typeOfMove,points);
	this.setIcon('B');
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
