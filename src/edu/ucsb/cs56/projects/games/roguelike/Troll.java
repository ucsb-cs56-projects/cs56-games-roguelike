package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 */
/**
 *This class represents a monster called a troll that is a medium damaged melee creature. Trolls have icon T
 */

public class Troll extends Monster{ 
    private char icon;

    /**
     *creates a troll with 10 hitPoints and 3 attack with no random movement
     *with icon T
     */
    public Troll(){
	super(10,3,0,15);    
	this.setIcon('T');
    }
    /**
     * creates a troll with 10 HP and 3 attack with icon T
     * @ param randomMovement whether or not the monster will move randomly
     */
    public Troll(int typeOfMovement){
	super(10,3,typeOfMovement,15);
	this.setIcon('T');
    }
    
    /**
     * creates a troll with hit points, attack, and random movement with icon T
     * @param hitPoints the Troll's hitPoints
     * @param attack the Trolls's attack
     * @param randomMovement whether or not the Troll will move randomly or not
     */
    public Troll(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints, attack, typeOfMovement,15);
	this.setIcon('T');
    }
    /**
     *creates a Troll to the parameters given to it
     * @param hp the Troll's hitPoints
     * @param att the Troll's attack
     * @param typeOfMove whether or not the Troll will move randomly or not
     * @param points the amount of points the Troll is worth
     */
    public Troll(int hitPoints,int att,int typeOfMove, int points){
	super(hitPoints,att,typeOfMove,points); 
	this.setIcon('T');
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
