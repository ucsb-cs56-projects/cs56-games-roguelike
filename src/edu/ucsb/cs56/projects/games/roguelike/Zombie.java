package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Rick Lee
 *@version cs56 Winter 14
 */
/**
 *This class represents a monster called a zombie that is a medium health, low damaged melee creature. Zombie have icon Z
 */

public class Zombie extends Monster{ 
    private char icon;

    /**
     *creates a zombie with 15 hitPoints and 2 attack with no random movement
     *with icon Z
     */
    public Zombie(){
	super(15,2,0,15);    
	this.setIcon('Z');
    }
    /**
     * creates a Zombie with 15 HP and 2 attack with icon Z
     * @param randomMovement whether or not the monster will move randomly
     */
    public Zombie(int typeOfMovement){
	super(15,2,typeOfMovement,15);
	this.setIcon('Z');
    }
    
    /**
     * creates a zombie with hit points, attack, and random movement with icon Z
     * @param hitPoints the Zombie's hitPoints
     * @param attack the Zombie's attack
     * @param randomMovement whether or not the Zombie will move randomly or not
     */
    public Zombie(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints, attack, typeOfMovement,15);
	this.setIcon('Z');
    }
    /**
     *creates a Zombie to the parameters given to it
     * @param hp the Zombie's hitPoints
     * @param att the Zombie's attack
     * @param typeOfMove whether or not the Zombie will move randomly or not
     * @param points the amount of points the Zombie is worth
     */
    public Zombie(int hitPoints,int att,int typeOfMove, int points){
	super(hitPoints,att,typeOfMove,points); 
	this.setIcon('Z');
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
