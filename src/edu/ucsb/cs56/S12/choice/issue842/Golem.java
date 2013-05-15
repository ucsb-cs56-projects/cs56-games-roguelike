package edu.ucsb.cs56.projects.games.roguelike;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *
 */

public class Golem{ 
    private int hitPoints;
    private int attack;
    private int direction = 0;
    private int typeOfMovement;
    private int[] position = new int[2];
    private int pointValue=20;

    /**
     *creates a Golem with 50 hitPoints and 20 attack with no random movement
     *
     */
    public Golem(){
	this (50,20,0);    
    }
    /**
     * creates a Golem with 50 HP and 20 attack
     * @ param randomMovement whether or not the Golem will move randomly
     */
    public Golem(int typeOfMovement){
	this(50,20,typeOfMovement);
    }
    
    /**
     * creates a Golem with hit points, attack, and random movement
     * @param hitPoints the Golem's hitPoints
     * @param attack the Golem's attack
     * @param randomMovement whether or not the Golem will move randomly or not
     */
    public Golem(int hitPoints, int attack, int typeOfMovement){
	this.hitPoints = hitPoints;
	this.attack = attack;
	this.typeOfMovement = typeOfMovement;
    }
    /**
     * @return the Golem's hitPoints
     * 
     */
    public int getHitPoints(){
	//return this.hitPoints;
	return -42; //@@stub
    }

    /**
     * @return the Golem's attack
     * 
     */
    public int getAttack(){
	//return this.attack;
	return -42; //@@stub
    }

    /** 
     * sets the hitPoints of the Golem
     * @param newHp is the new hp for the Golem
     */
    public void setHitPoints(int newHp){
	//this.hitPoints = newHp;
	this.hitPoints=-42; //@@stub

    }
    /**
     * gets the point value of the Golem
     */
    	
    public int getPointValue(){
    //return this.pointValue;
    return -42;
    }
    /**
	* sets the pointValue of the Golem
	* @param pointValue number of points for killing the Golem.
	*/
     
    public void setPointValue(int pointValue){
     //this.pointValue=pointValue;
     this.pointValue=-42;
    }


}

