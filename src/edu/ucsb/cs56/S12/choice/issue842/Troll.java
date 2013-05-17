package edu.ucsb.cs56.S12.choice.issue842;

import java.util.Random;

/**
 *@author Hans Marasigan & Richard Nguyen
 *@version cs56 Spring 13
 *This class represents a monster called a troll that is a medium damaged melee creature.
 */

public class Troll extends Monster{ 

    /**
     *creates a troll with 15 hitPoints and 10 attack with no random movement
     *
     */
    public Troll(){
	super(15,10,0,15);    
    }
    /**
     * creates a troll with 15 HP and 10 attack
     * @ param randomMovement whether or not the monster will move randomly
     */
    public Troll(int typeOfMovement){
	super(15,10,typeOfMovement,15);
    }
    
    /**
     * creates a troll with hit points, attack, and random movement
     * @param hitPoints the Troll's hitPoints
     * @param attack the Trolls's attack
     * @param randomMovement whether or not the Troll will move randomly or not
     */
    public Troll(int hitPoints, int attack, int typeOfMovement){
	super(hitPoints, attack, typeOfMovement,15);
    }
    public Troll(int hitPoints,int att,int typeOfMove, int points){
	super(hitPoints,att,typeOfMove,points);  
 }
    
}
