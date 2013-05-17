package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *This class represents a class of monster called a Bat which is a weak melee monster.
 */

public class Bat extends Monster{ 
    private int hitPoints;
    private int attack;
    private int direction = 0;
    private int typeOfMovement;
    private int[] position = new int[2];
    private int pointValue=10;

    /**
     *creates a Bat with 10 hitPoints and 10 attack with no random movement
     *
     */
    public Bat(){
	this (10,10,0);    
    }
    /**
     * creates a Bat with 10 HP and 10 attack
     * @ param randomMovement whether or not the bat will move randomly
     */
    public Bat(int typeOfMovement){
	this(10,10,typeOfMovement);
    }
    
    /**
     * creates a Bat with hit points, attack, and random movement
     * @param hitPoints the Bat's hitPoints
     * @param attack the Bat's attack
     * @param randomMovement whether or not the Troll will move randomly or not
     */
    public Bat(int hitPoints, int attack, int typeOfMovement){
	this.hitPoints = hitPoints;
	this.attack = attack;
	this.typeOfMovement = typeOfMovement;
    }
    public Bat(int hp,int att,int typeOfMove, int points){
	this.hitPoints = hp;
        this.attack = att;
        this.typeOfMovement = typeOfMovement;
	this.pointValue=points;
    }
    /**
     * @return the Bat's hitPoints
     * 
     */
    public int getHitPoints(){
	return this.hitPoints;
	
    }

    /**
     * @return the Bat's attack
     * 
     */
    public int getAttack(){
	return this.attack;
	
    }

    /** 
     * sets the hitPoints of the Bat
     * @param newHp is the new hp for the Bat
     */
    public void setHitPoints(int newHp){
	this.hitPoints = newHp;
	

    }
    /**
     * 	get the point value of the Bat
     */
    public int getPointValue(){
    	return this.pointValue;
    	
    }
    /**
     * sets the pointValue of the Bat
     * @param pointValue number of points for killing the bat.
     */
     
    public void setPointValue(int pointValue){
    	this.pointValue=pointValue;
    	
    }


}

