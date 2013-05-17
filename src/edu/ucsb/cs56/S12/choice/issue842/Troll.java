package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *This class represents a monster called a troll that is a medium damaged melee creature.
 */

public class Troll extends Monster{ 
    private int hitPoints;
    private int attack;
    private int direction = 0;
    private int typeOfMovement;
    private int[] position = new int[2];
    private int pointValue=15;

    /**
     *creates a troll with 15 hitPoints and 10 attack with no random movement
     *
     */
    public Troll(){
	this (15,10,0);    
    }
    /**
     * creates a troll with 15 HP and 10 attack
     * @ param randomMovement whether or not the monster will move randomly
     */
    public Troll(int typeOfMovement){
	this(15,10,typeOfMovement);
    }
    
    /**
     * creates a troll with hit points, attack, and random movement
     * @param hitPoints the Troll's hitPoints
     * @param attack the Trolls's attack
     * @param randomMovement whether or not the Troll will move randomly or not
     */
    public Troll(int hitPoints, int attack, int typeOfMovement){
	this.hitPoints = hitPoints;
	this.attack = attack;
	this.typeOfMovement = typeOfMovement;
    }
    /**
     * @return the Trolls's hitPoints
     * 
     */
    public int getHitPoints(){
	return this.hitPoints;
    }

    /**
     * @return the Trolls's attack
     * 
     */
    public int getAttack(){
	return this.attack;
 }

    /** 
     * sets the hitPoints of the Trolls
     * @param newHp is the new hp for the Trolls
     */
    public void setHitPoints(int newHp){
	this.hitPoints = newHp;
	
    }
        /**
	* gets the point value of the Troll
	*/
    
    public int getPointValue(){
    return this.pointValue;
    }
    /**
	* sets the pointValue of the Troll.
	* @param pointValue number of points for killing the Troll.
	*/
     
    public void setPointValue(int pointValue){
     this.pointValue=pointValue;
    }

}


