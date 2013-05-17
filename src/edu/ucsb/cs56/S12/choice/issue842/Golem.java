package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *This is a monster called a golem that is very healthy with a ton of attack.
 */

public class Golem extends Monster{ 
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

        public Golem(int hp,int att,int typeOfMove, int points){
	super(hp,att,typeOfMove,points);
    }
    /**
     * @return the Golem's hitPoints
     * 
     */
    public int getHitPoints(){
	return this.hitPoints;
    }

    /**
     * @return the Golem's attack
     * 
     */
    public int getAttack(){
	return this.attack;
 }

    /** 
     * sets the hitPoints of the Golem
     * @param newHp is the new hp for the Golem
     */
    public void setHitPoints(int newHp){
	this.hitPoints = newHp;
        
    }
    /**
     * gets the point value of the Golem
     */
    	
    public int getPointValue(){
    return this.pointValue;
    }
    /**
	* sets the pointValue of the Golem
	* @param pointValue number of points for killing the Golem.
	*/
     
    public void setPointValue(int pointValue){
    this.pointValue=pointValue;
    }


}

