package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *This class represents a class of monster called a Bat which is a weak melee monster.
 */

public class Bat extends Monster{ 

    /**
     *creates a Bat with 10 hitPoints and 10 attack with no random movement
     *
     */
    public Bat(){
	super(10,10,0,10);    
    }
    /**
     * creates a Bat with 10 HP and 10 attack
     * @ param randomMovement whether or not the bat will move randomly
     */
    public Bat(int typeOfMovement){
	super(10,10,typeOfMovement,10);
    }
    
    /**
     * creates a Bat with hit points, attack, and random movement
     * @param hitPoints the Bat's hitPoints
     * @param attack the Bat's attack
     * @param randomMovement whether or not the Troll will move randomly or not
     */
    public Bat(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints,attack,typeOfMovement,10);
    }
    public Bat(int hp,int att,int typeOfMove, int points){
	super(hp,att,typeOfMove,points);
    }
}
